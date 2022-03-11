package com.ibatix.core.data;

/**
 * 数据库管理上下文
 *
 * @author master
 */
public interface DataServiceContext {

    /**
     * 获取指定名称、类型的对象
     *
     * @param name 名称
     * @param type 类型
     * @param <T>  运行时对象类型
     * @return 对象
     */
    <T> T get(String name, Class<T> type);

    /**
     * 获取指定类型的对象
     *
     * @param type 类型
     * @param <T>  运行时对象类型
     * @return 对象
     */
    <T> T get(Class<T> type);

    /**
     * 获取指定名称的对象
     *
     * @param name 名称
     * @return 对象
     */
    Object get(String name);

    /**
     * 保存指定的变量
     *
     * @param value 值
     */
    void put(Object value);

    /**
     * 保存指定的变量
     *
     * @param name  名称
     * @param value 值
     */
    void put(String name, Object value);

    /**
     * 保存指定的变量
     *
     * @param name     名称
     * @param value    值
     * @param override 是否自动覆盖
     */
    void put(String name, Object value, boolean override);

    /**
     * 是否包含指定名称的对象
     *
     * @param name 名称
     * @return 对象
     */
    boolean contains(String name);

}
