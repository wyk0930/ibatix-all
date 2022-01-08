package com.ibatix.util;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.beans.BeanMap;
import org.objenesis.ObjenesisStd;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * JavaBean属性复制工具类
 *
 * @author master
 */
public final class PropertyUtils {

    /**
     * BeanCopier的缓存
     */
    private static final ConcurrentHashMap<Integer, BeanCopier> BEAN_COPIER_CACHE;

    /**
     * 对象创建器
     */
    private static final ThreadLocal<ObjenesisStd> OBJENESIS_THREAD_LOCAL;

    static {
        BEAN_COPIER_CACHE = new ConcurrentHashMap<>();
        OBJENESIS_THREAD_LOCAL = ThreadLocal.withInitial(ObjenesisStd::new);
    }

    /**
     * 复制List对象
     *
     * @param sources    源对象集合
     * @param targetType 目标类型
     * @param <S>        源类型
     * @param <T>        目标类型
     * @return 复制结果
     */
    public static <S, T> List<T> copyList(List<S> sources, Class<T> targetType) {
        if (sources.isEmpty()) {
            return Collections.emptyList();
        }
        List<T> list = new ArrayList<>(sources.size());
        for (S source : sources) {
            if (source == null) {
                list.add(null);
            } else {
                T target = copy(source, targetType);
                list.add(target);
            }
        }
        return list;
    }

    /**
     * 属性复制并创建一个JavaBean
     *
     * @param source     源对象
     * @param targetType 目标对象类型
     * @param <S>        源类型
     * @param <T>        目标类型
     * @return 复制结果
     */
    public static <S, T> T copy(S source, Class<T> targetType) {
        T obj = OBJENESIS_THREAD_LOCAL.get().newInstance(targetType);
        return copy(source, obj);
    }

    /**
     * 属性复制
     *
     * @param source 源对象
     * @param target 目标对象
     * @param <S>    源类型
     * @param <T>    目标类型
     * @return 复制结果
     */
    public static <S, T> T copy(S source, T target) {
        return copy(source, target, false);
    }

    /**
     * 属性复制
     *
     * @param source       源对象
     * @param target       目标对象
     * @param useConverter 是否使用转换器
     * @param <S>          源类型
     * @param <T>          目标类型
     * @return 复制结果
     */
    public static <S, T> T copy(S source, T target, boolean useConverter) {
        int hashCode = newKey(source, target);
        BeanCopier beanCopier = getCacheBeanCopier(source.getClass(), target.getClass(), useConverter, hashCode);
        beanCopier.copy(source, target, null);
        return target;
    }

    /**
     * 将Map转换为JavaBean
     *
     * @param source     源对象
     * @param targetType 目标对象类型
     * @param <K>        源对象键类型
     * @param <V>        源对象值类型
     * @param <T>        目标类型
     * @return 复制结果
     */
    public static <K, V, T> T mapToBean(Map<K, V> source, Class<T> targetType) {
        T bean = OBJENESIS_THREAD_LOCAL.get().newInstance(targetType);
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(source);
        return bean;
    }

    /**
     * 将JavaBean转换为Map类型
     *
     * @param source 源对象
     * @param <K>    源对象键类型
     * @param <V>    源对象值类型
     * @param <T>    目标类型
     * @return 复制结果
     */
    public static <K, V, T> Map<K, V> beanToMap(T source) {
        return BeanMap.create(source);
    }

    /**
     * 生成key
     *
     * @param source 源对象
     * @param target 目标对象
     * @param <S>    源类型
     * @param <T>    目标类型
     * @return 缓存Key
     */
    private static <S, T> int newKey(S source, T target) {
        return Objects.hash(source, target);
    }

    /**
     * 获取 BeanCopier
     *
     * @param sourceType 源对象类型
     * @param targetType 目标对象类型
     * @param useConvert 是否使用自定义转换器
     * @param cacheKey   缓存键
     * @param <S>        源类型
     * @param <T>        目标类型
     * @return BeanCopier对象
     */
    private static <S, T> BeanCopier getCacheBeanCopier(Class<S> sourceType, Class<T> targetType, boolean useConvert, int cacheKey) {
        BeanCopier beanCopier;
        if (BEAN_COPIER_CACHE.containsKey(cacheKey)) {
            beanCopier = BEAN_COPIER_CACHE.get(cacheKey);
        } else {
            beanCopier = BeanCopier.create(sourceType, targetType, useConvert);
            BEAN_COPIER_CACHE.put(cacheKey, beanCopier);
        }
        return beanCopier;
    }
}

