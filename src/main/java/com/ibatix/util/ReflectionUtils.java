package com.ibatix.util;


import org.objenesis.ObjenesisStd;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 反射工具类。不推荐使用
 *
 * @author master
 */
public final class ReflectionUtils {

    /**
     * 构造器
     */
    private ReflectionUtils() {

    }

    /**
     * 对象创建器
     */
    private static final ThreadLocal<ObjenesisStd> OBJENESIS_THREAD_LOCAL = ThreadLocal.withInitial(ObjenesisStd::new);

    /**
     * 获取类上的泛型
     *
     * @param clazz 指定类型
     * @return 泛型
     */
    public static Type getFirstActualTypeArgument(Class<?> clazz) {
        return getAllActualTypeArguments(clazz)[0];
    }

    /**
     * 获取类上包含的所有泛型
     *
     * @param clazz 指定类型
     * @return 泛型
     */
    public static Type[] getAllActualTypeArguments(Class<?> clazz) {
        Type superClass = clazz.getGenericSuperclass();
        return ((ParameterizedType) superClass).getActualTypeArguments();
    }

    /**
     * 获取指定对象的构造器
     *
     * @param clazz          指定类型
     * @param parameterTypes 构造器参数列表的参数类型
     * @param <T>            构造器运行时类型
     * @return 构造器对象
     */
    public static <T> Constructor<T> getConstructor(Class<T> clazz, Class<?>... parameterTypes) {
        Constructor<T> constructor = null;
        try {
            constructor = clazz.getDeclaredConstructor(parameterTypes);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return constructor;
    }

    /**
     * 使用默认构造器创建对象
     *
     * @param type 对象类型
     * @param <T>  对象类型
     * @return 对象
     */
    public static <T> T newInstanceByDefaultConstructor(Class<T> type) {
        return newInstance(type, null, null);
    }

    /**
     * 通过OBJENESIS_THREAD_LOCAL创建指定类型的对象
     *
     * @param type 对象类型
     * @param <T>  对象类型
     * @return 对象
     */
    public static <T> T newInstance(Class<T> type) {
        return OBJENESIS_THREAD_LOCAL.get().newInstance(type);
    }

    /**
     * 通过构造器反射创建指定类型的对象
     *
     * @param type           对象类型
     * @param parameterTypes 构造器列表参数类型
     * @param initArguments  构造器初始化参数
     * @param <T>            对象类型
     * @return 对象
     */
    public static <T> T newInstance(Class<T> type, Class<?>[] parameterTypes, Object[] initArguments) {
        return newInstance(type, parameterTypes, initArguments, true);
    }

    /**
     * 通过构造器反射创建指定类型的对象
     *
     * @param type           对象类型
     * @param parameterTypes 构造器列表参数类型
     * @param initArguments  构造器初始化参数
     * @param accessible     构造器为私有时是否支持访问
     * @param <T>            对象类型
     * @return 对象
     */
    public static <T> T newInstance(Class<T> type, Class<?>[] parameterTypes, Object[] initArguments, boolean accessible) {
        Constructor<T> constructor = getConstructor(type, parameterTypes);
        constructor.setAccessible(accessible);
        T instance = null;
        try {
            instance = constructor.newInstance(initArguments);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }
}
