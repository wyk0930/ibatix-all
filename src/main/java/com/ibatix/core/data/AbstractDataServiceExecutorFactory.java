package com.ibatix.core.data;

import com.ibatix.util.NullUtils;

public abstract class AbstractDataServiceExecutorFactory<T extends DataServiceExecutor>
        implements DataServiceExecutorFactory<T> {

    private ThreadLocal<T> localExecutor;
    private String name;
    private DataServiceConfiguration config;

    protected AbstractDataServiceExecutorFactory() {
        localExecutor = new ThreadLocal<>();
    }

    @Override
    public DataServiceExecutorFactory withConfig(DataServiceConfiguration config) {
        this.config = config;
        return this;
    }

    @Override
    public DataServiceConfiguration getConfig() {
        return config;
    }

    @Override
    public T connect() {
        if (NullUtils.isNotNull(getExecutor())) {
            return getExecutor();
        }
        T executor = create();
        setExecutor(executor);
        return executor;
    }

    @Override
    public DataServiceExecutorFactory withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void disconnect() {
        localExecutor.remove();
    }

    protected abstract T create();

    protected T getExecutor() {
        return localExecutor.get();
    }

    protected void setExecutor(T executor) {
        localExecutor.set(executor);
    }
}
