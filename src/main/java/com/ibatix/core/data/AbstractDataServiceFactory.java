package com.ibatix.core.data;

import com.ibatix.util.NullUtils;

public abstract class AbstractDataServiceFactory<T extends DataService>
        implements DataServiceFactory<T> {

    private ThreadLocal<T> localService;
    private DataServiceConfiguration config;

    protected AbstractDataServiceFactory() {
        localService = new ThreadLocal<>();
    }

    @Override
    public T connect() {
        if (NullUtils.isNotNull(getService())) {
            return getService();
        }
        T service = open();
        putService(service);
        return service;
    }

    @Override
    public DataServiceFactory withConfig(DataServiceConfiguration config) {
        this.config = config;
        return this;
    }

    @Override
    public DataServiceConfiguration getConfig() {
        return config;
    }

    protected abstract T open();

    protected T getService() {
        return localService.get();
    }

    protected void putService(T service) {
        localService.set(service);
    }
}
