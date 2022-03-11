package com.ibatix.core.context;

import com.ibatix.core.data.AbstractDataServiceContext;
import com.ibatix.core.data.DataServiceContext;

/**
 * 上下文工具类
 *
 * @author master
 */
public final class ContextHolder {
    private static final DataServiceContext context;

    static {
        context = new AbstractDataServiceContext() {
        };
    }

    private ContextHolder() {

    }

    public static DataServiceContext getContext() {
        return context;
    }

    public static void put(String name, Object value) {
        context.put(name, value);
    }

    public static <T> T get(String name, Class<T> type) {
        return context.get(name, type);
    }

    public static <T> T get(Class<T> type) {
        return context.get(type);
    }
}
