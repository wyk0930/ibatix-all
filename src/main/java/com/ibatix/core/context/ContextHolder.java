package com.ibatix.core.context;

import com.ibatix.util.NullUtils;

import java.util.HashMap;
import java.util.Map;

public final class ContextHolder {
    private static ContextHolder _instance;
    private Map<String, Object> cache;

    private ContextHolder() {
        cache = new HashMap<>();
    }

    public static ContextHolder getInstance() {
        if (NullUtils.isNull(_instance)) {
            synchronized (ContextHolder.class) {
                if (NullUtils.isNull(_instance)) {
                    _instance = new ContextHolder();
                }
            }
        }
        return _instance;
    }

    /**
     * 根据指定名称及类型获取对象
     *
     * @param name 对象名称
     * @param type 对象类型
     * @param <T>  运行时类型
     * @return 对象
     */
    public static <T> T get(String name, Class<T> type) {
        Object target = get(name);
        return type.cast(target);
    }

    /**
     * 获取指定名称的对象
     *
     * @param name 对象名称
     * @return 对象
     */
    public static Object get(String name) {
        return getInstance().cache.get(name);
    }
}
