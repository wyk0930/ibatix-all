package com.ibatix.data.jdbc;

/**
 * 关系型数据库连接生产工厂
 *
 * @author master
 */
public interface SqlConnectionFactory {

    /**
     * 打开一个数据库连接
     * @return 数据库连接对象
     */
    SqlConnection openConnection();
}
