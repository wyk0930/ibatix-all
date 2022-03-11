package com.ibatix.core.data;

import com.ibatix.core.context.ContextHolder;

public class AbstractDataServiceExecutor implements DataServiceExecutor {
    private final String factoryName;

    protected AbstractDataServiceExecutor(String factoryName) {
        this.factoryName = factoryName;
    }

    @Override
    public void destroy() {
        ContextHolder.getContext()
                .get(factoryName, DataServiceExecutorFactory.class)
                .disconnect();
    }
}
