package com.ibatix.core.data.jdbc;

/**
 * 数据库连接工厂构造器
 *
 * @author master
 */
public interface SqlConnectionContext {

    /**
     * 构建数据库连接工厂
     *
     * @return 数据连连接工厂
     */
    SqlConnectionFactory build();

    /**
     * 根据自定义数据库配置信息构建数据连接工厂
     *
     * @param config 数据库配置信息
     * @return 数据库连接工厂
     */
    SqlConnectionFactory build(SqlConfiguration config);


    /**
     * 指定驱动类名称
     *
     * @param driverClassName 驱动类名称
     * @return 数据库连接工厂构造器
     */
    SqlConnectionContext withDriverClassName(String driverClassName);

    /**
     * 指定数据库连接地址
     *
     * @param url 数据库连接地址
     * @return 数据库连接工厂构造器
     */
    SqlConnectionContext withUrl(String url);

    /**
     * 指定数据库连接用户名
     *
     * @param username 数据库连接用户名
     * @return 数据库连接工厂构造器
     */
    SqlConnectionContext withUsername(String username);

    /**
     * 指定数据库连接密码
     *
     * @param password 数据库连接密码
     * @return 数据库连接工厂构造器
     */
    SqlConnectionContext withPassword(String password);
}
