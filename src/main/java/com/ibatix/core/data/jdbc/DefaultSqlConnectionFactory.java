package com.ibatix.core.data.jdbc;

import javax.sql.DataSource;

/**
 * 默认数据库连接工厂类
 *
 * @author master
 */
public class DefaultSqlConnectionFactory implements SqlConnectionFactory {
    private static SqlConnectionFactory _instance;
    private SqlConfiguration config;
    private DataSource dataSource;

    /**
     * 构造器
     *
     * @param config 配置信息
     */
    public DefaultSqlConnectionFactory(SqlConfiguration config) {
        this.config = config;
    }

    /**
     * 构造器
     *
     * @param dataSource 数据源对象
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 构造器
     *
     * @param config     数据库配置信息
     * @param dataSource 数据源
     */
    public DefaultSqlConnectionFactory(SqlConfiguration config, DataSource dataSource) {
        this.config = config;
        this.dataSource = dataSource;
    }

    public SqlConnection openConnection() {
        return null;
    }
}
