package com.ibatix.core.context;

import com.ibatix.core.exception.UnknownException;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据库连接工厂构造器
 *
 * @author master
 */
public abstract class AbstractIBatixContext implements IBatixContext {
    private static final Map<String, Object> CTX_HOLDER = new HashMap<>();

    /**
     * 构造器
     */
    protected AbstractIBatixContext() {

    }

    @Override
    public <T> T get(String name, Class<T> type) {
        return type.cast(get(name));
    }

    @Override
    public Object get(String name) {
        return CTX_HOLDER.get(name);
    }

    @Override
    public <T> T get(Class<T> type) {
        return get(createDefaultServiceName(type), type);
    }

    @Override
    public void put(Object value) {
        put(createDefaultServiceName(value.getClass()), value);
    }

    @Override
    public void put(String name, Object value) {
        put(name, value, true);
    }

    @Override
    public void put(String name, Object value, boolean override) {
        if (contains(name) && !override) {
            throw new UnknownException();
        }
        CTX_HOLDER.put(name, value);
    }

    @Override
    public boolean contains(String name) {
        return CTX_HOLDER.containsKey(name);
    }

    /**
     * 根据类名创建默认服务名称
     *
     * @param type 类型
     * @param <T>  运行时类型
     * @return 默认服务名称
     */
    private <T> String createDefaultServiceName(Class<T> type) {
        return ContextHolder.createDefaultServiceName(type);
    }
}
