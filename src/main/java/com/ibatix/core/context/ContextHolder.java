package com.ibatix.core.context;

import com.ibatix.core.exception.UnknownException;
import com.ibatix.util.NullUtils;

/**
 * 上下文工具类
 *
 * @author master
 */
public final class ContextHolder {
    private static IBatixContext context;

    private ContextHolder() {

    }

    public static IBatixContext getContext() {
        if (NullUtils.isNull(context)) {
            synchronized (ContextHolder.class) {
                if (NullUtils.isNull(context)) {
                    context = new AbstractIBatixContext() {
                    };
                }
            }
        }
        return context;
    }

    public static void put(Object value) {
        getContext().put(value);
    }

    public static void put(String name, Object value) {
        getContext().put(name, value);
    }

    public static <T> T get(String name, Class<T> type) {
        return getContext().get(name, type);
    }

    public static <T> T get(Class<T> type) {
        return getContext().get(type);
    }

    public static <T> String createDefaultServiceName(Class<T> type) {
        char[] arr = type.getSimpleName().toCharArray();
        if (arr[0] == '_' || arr[0] == '$') {
            throw new UnknownException();
        }
        if (arr[0] >= 65 && arr[0] <= 90) {
            arr[0] = (char) (arr[0] + 32);
        }
        return String.valueOf(arr);
    }

}
