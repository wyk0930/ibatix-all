package com.ibatix.core.data.jdbc.support;

import com.ibatix.core.data.jdbc.DefaultSqlCommandExecutor;
import com.ibatix.core.data.jdbc.QueryRequest;
import com.ibatix.core.data.jdbc.SqlConfiguration;
import com.ibatix.core.data.jdbc.SqlConnection;

import java.sql.Connection;
import java.util.List;

public class DefaultSqlConnection implements SqlConnection {
    private SqlConfiguration config;

    public DefaultSqlConnection(SqlConfiguration config) {
        this.config = config;
    }

    @Override
    public <S, T> List<T> selectList(QueryRequest<S, T> queryRequest, Object... params) throws Exception {

        //将要去完成对simpleExecutor里的query方法的调用
        DefaultSqlCommandExecutor simpleExecutor = new DefaultSqlCommandExecutor();
        List<T> list = simpleExecutor.doQuery(this, queryRequest, params);

        return list;
    }

    @Override
    public <S, T> T selectOne(QueryRequest<S, T> queryRequest, Object... params) throws Exception {
        List<T> objects = null; //selectList(statementid, params);
        if (objects.size() == 1) {
            return objects.get(0);
        } else {
            throw new RuntimeException("查询结果为空或者返回结果过多");
        }


    }

//    @Override
//    public <T> T getMapper(Class<?> mapperClass) {
//        // 使用JDK动态代理来为Dao接口生成代理对象，并返回
//
//        Object proxyInstance = Proxy.newProxyInstance(DefaultSqlConnection.class.getClassLoader(), new Class[]{mapperClass}, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                // 底层都还是去执行JDBC代码 //根据不同情况，来调用selctList或者selectOne
//                // 准备参数 1：statmentid :sql语句的唯一标识：namespace.id= 接口全限定名.方法名
//                // 方法名：findAll
//                String methodName = method.getName();
//                String className = method.getDeclaringClass().getName();
//
//                String statementId = className + "." + methodName;
//
//                // 准备参数2：params:args
//                // 获取被调用方法的返回值类型
//                Type genericReturnType = method.getGenericReturnType();
//                // 判断是否进行了 泛型类型参数化
//                if (genericReturnType instanceof ParameterizedType) {
//                    List<Object> objects = selectList(statementId, args);
//                    return objects;
//                }
//
//                return selectOne(statementId, args);
//
//            }
//        });
//
//        return (T) proxyInstance;
//    }

    @Override
    public Connection getConnection() {
        return null;
    }

}
