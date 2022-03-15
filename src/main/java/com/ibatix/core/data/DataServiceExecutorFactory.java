package com.ibatix.core.data;

/**
 * 数据服务工厂，用于创建数据访问服务
 *
 * @author master
 */
public interface DataServiceExecutorFactory<T extends DataServiceExecutor> {

    T connect();

    void disconnect();

    void setName(String name);

    String getName();

    void setConfig(DataServiceConfiguration config);

    DataServiceConfiguration getConfig();

}
