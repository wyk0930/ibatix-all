package com.ibatix.core.data;

/**
 * 数据服务工厂，用于创建数据访问服务
 *
 * @author master
 */
public interface DataServiceFactory<T extends DataService> {

    T connect();

    DataServiceFactory withConfig(DataServiceConfiguration config);

    DataServiceConfiguration getConfig();

}
