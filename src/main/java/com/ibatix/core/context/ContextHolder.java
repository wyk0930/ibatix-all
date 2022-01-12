package com.ibatix.core.context;

import com.ibatix.util.NullUtils;

import java.util.HashMap;
import java.util.Map;

public final class ContextHolder {
    private static ContextHolder instance;
    private boolean initialize;
    private Map<String, String> cache;

    private ContextHolder() {
    }

    public static void init() {
        if (NullUtils.isNull(instance)) {
            synchronized (ContextHolder.class) {
                if (NullUtils.isNull(instance)) {
                    instance = new ContextHolder();
                    instance.init(true);
                }
            }
        }
    }

    private void init(boolean initialize) {
        if (initialize) {
            return;
        }
        this.initialize = true;
        cache = new HashMap<>();

    }
}
