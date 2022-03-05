package com.ibatix.data.jdbc;

import javax.sql.DataSource;

/**
 * 默认数据库配置对象
 *
 * @author master
 */
public class DefaultSqlConfiguration implements SqlConfiguration {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private DataSource dataSource;

    /**
     * 构造器
     * 需要自定义连接数据库所需要的参数
     */
    public DefaultSqlConfiguration() {
    }

    /**
     * 构造器
     * 使用JDBC方式连接数据库
     *
     * @param driverClassName 数据库驱动类名
     * @param url             数据库连接地址
     * @param username        数据库连接用户名
     * @param password        数据库连接用户密码
     */
    public DefaultSqlConfiguration(String driverClassName,
                                   String url,
                                   String username,
                                   String password) {
        this.driverClassName = driverClassName;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /**
     * 构造器
     * 使用自定义数据源连接数据库
     *
     * @param dataSource 数据源
     */
    public DefaultSqlConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取驱动类名称
     *
     * @return 驱动类名称
     */
    public String getDriverClassName() {
        return driverClassName;
    }

    /**
     * 设置驱动类名称
     *
     * @param driverClassName 驱动类名称
     */
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    /**
     * 获取数据库连接地址
     *
     * @return 数据库连接地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置数据库连接地址
     *
     * @param url 数据库连接URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取数据库连接用户名
     *
     * @return 数据库连接用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置数据库连接用户名
     *
     * @param username 数据库连接用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取数据库连接用户密码
     *
     * @return 数据库连接用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置数据库连接用户密码
     *
     * @param password 数据库连接用户密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取数据源
     *
     * @return 数据源
     */
    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 设置数据源
     *
     * @param dataSource 数据源
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
