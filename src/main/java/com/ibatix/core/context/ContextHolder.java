package com.ibatix.core.context;

/**
 * 上下文工具类
 *
 * @author master
 */
public final class ContextHolder {
    private static final IBatixContext context;

    static {
        context = new AbstractIBatixContext() {
        };
    }

    private ContextHolder() {

    }

    public static IBatixContext getContext() {
        return context;
    }

    public static void put(Object value) {
        context.put(value);
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
