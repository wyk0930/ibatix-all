package com.ibatix.core.data.jdbc;

import javax.sql.DataSource;

/**
 * 关系型数据库连接配置
 *
 * @author master
 */
public interface SqlConfiguration {

    /**
     * 获取驱动类名称
     *
     * @return 驱动类名称
     */
    String getDriverClassName();

    /**
     * 设置驱动类名称
     *
     * @param driverClassName 驱动类名称
     */
    void setDriverClassName(String driverClassName);

    /**
     * 获取数据库连接地址
     *
     * @return 数据库连接地址
     */
    String getUrl();

    /**
     * 设置数据库连接地址
     *
     * @param url 数据库连接URL
     */
    void setUrl(String url);

    /**
     * 获取数据库连接用户名
     *
     * @return 数据库连接用户名
     */
    String getUsername();

    /**
     * 设置数据库连接用户名
     *
     * @param username 数据库连接用户名
     */
    void setUsername(String username);

    /**
     * 获取数据库连接用户密码
     *
     * @return 数据库连接用户密码
     */
    String getPassword();

    /**
     * 设置数据库连接用户密码
     *
     * @param password 数据库连接用户密码
     */
    void setPassword(String password);

    /**
     * 获取数据源
     *
     * @return 数据源
     */
    DataSource getDataSource();

    /**
     * 设置数据源
     *
     * @param dataSource 数据源
     */
    void setDataSource(DataSource dataSource);

}
