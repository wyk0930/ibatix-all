package com.ibatix.data.jdbc;


import com.ibatix.data.jdbc.support.BoundSql;
import com.ibatix.data.jdbc.support.GenericTokenParser;
import com.ibatix.data.jdbc.support.ParameterMapping;
import com.ibatix.data.jdbc.support.ParameterMappingTokenHandler;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class DefaultSqlCommandExecutor implements SqlCommandExecutor {


    @Override
    public <S, T> List<T> doQuery(SqlConnection sqlConnection, QueryCommand<S, T> queryCommand) throws Exception {
        // 解析SQL语句
        String sql = queryCommand.getSql();
        BoundSql boundSql = getBoundSql(sql);
        Connection connection = sqlConnection.getConnection();
        // 3.获取预处理对象：preparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(boundSql.getSqlText());

        // 4. 设置参数
        //获取到了参数的全路径
        Class<S> parameterType = queryCommand.getParameterType();

        List<ParameterMapping> parameterMappingList = boundSql.getParameterMappingList();
        for (int i = 0; i < parameterMappingList.size(); i++) {
            ParameterMapping parameterMapping = parameterMappingList.get(i);
            String content = parameterMapping.getContent();

            //反射
            Field declaredField = parameterType.getDeclaredField(content);
            //暴力访问
            declaredField.setAccessible(true);
            Object o = declaredField.get(queryCommand.getArguments()[0]);

            preparedStatement.setObject(i + 1, o);

        }


        // 5. 执行sql
        ResultSet resultSet = preparedStatement.executeQuery();
        Class<T> resultType = queryCommand.getResultType();

        ArrayList<Object> objects = new ArrayList<>();

        // 6. 封装返回结果集
        while (resultSet.next()) {
            Object o = resultType.newInstance();
            //元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {

                // 字段名
                String columnName = metaData.getColumnName(i);
                // 字段的值
                Object value = resultSet.getObject(columnName);

                //使用反射或者内省，根据数据库表和实体的对应关系，完成封装
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(columnName, resultType);
                Method writeMethod = propertyDescriptor.getWriteMethod();
                writeMethod.invoke(o, value);


            }
            objects.add(o);

        }
        return (List<T>) objects;

    }

    /**
     * 完成对SQL进行解析
     *
     * @param sql SQL语句
     * @return SQL解析结果
     */
    private BoundSql getBoundSql(String sql) {
        //标记处理类：配置标记解析器来完成对占位符的解析处理工作
        ParameterMappingTokenHandler parameterMappingTokenHandler = new ParameterMappingTokenHandler();
        GenericTokenParser genericTokenParser = new GenericTokenParser("#{", "}", parameterMappingTokenHandler);
        //解析出来的sql
        String parseSql = genericTokenParser.parse(sql);
        //#{}里面解析出来的参数名称
        List<ParameterMapping> parameterMappings = parameterMappingTokenHandler.getParameterMappings();

        BoundSql boundSql = new BoundSql(parseSql, parameterMappings);
        return boundSql;
    }
}
