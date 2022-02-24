package com.ibatix.core.data.jdbc;

import java.sql.Connection;
import java.util.List;

/**
 * 数据库连接对象
 *
 * @author master
 */
public interface SqlConnection {
    //查询所有
    <S, T> List<T> selectList(QueryCommand<S, T> queryCommand, Object... params) throws Exception;

    //根据条件查询单个
    <S, T> T selectOne(QueryCommand<S, T> queryCommand, Object... params) throws Exception;

    //为Dao接口生成代理实现类
//    <T> T getMapper(Class<?> mapperClass);

    Connection getConnection();

}
