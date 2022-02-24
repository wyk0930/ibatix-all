package com.ibatix.core.data.jdbc;

import com.ibatix.core.Request;

public class QueryRequest<S, T> implements Request {
    private String sql;
    private Class<S> parameterType;
    private Class<T> resultType;

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Class<S> getParameterType() {
        return parameterType;
    }

    public void setParameterType(Class<S> parameterType) {
        this.parameterType = parameterType;
    }

    public Class<T> getResultType() {
        return resultType;
    }

    public void setResultType(Class<T> resultType) {
        this.resultType = resultType;
    }
}
