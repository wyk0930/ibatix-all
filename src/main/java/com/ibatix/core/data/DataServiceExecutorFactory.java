package com.ibatix.core.data;

/**
 * 数据服务工厂，用于创建数据访问服务
 *
 * @author master
 */
public interface DataServiceExecutorFactory<T extends DataServiceExecutor> {

    T connect();

    void disconnect();

    DataServiceExecutorFactory withName(String name);

    String getName();

    DataServiceExecutorFactory withConfig(DataServiceConfiguration config);

    DataServiceConfiguration getConfig();

}
