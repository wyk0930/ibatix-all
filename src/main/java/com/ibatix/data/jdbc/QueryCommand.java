package com.ibatix.data.jdbc;

import com.ibatix.core.State;
import com.ibatix.core.context.ContextHolder;
import com.ibatix.data.jdbc.support.AbstractSqlCommand;

public class QueryCommand<S, T> extends AbstractSqlCommand {
    private String sql;
    private Class<S> parameterType;
    private Class<T> resultType;
    private Object[] arguments;

    protected QueryCommand() {
        super(ContextHolder.get("sqlCommandExecutor", SqlCommandExecutor.class));
    }

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

    public Object[] getArguments() {
        return arguments;
    }

    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }

    @Override
    public State execute() {
        State state = null;
        try {
            state = (State) getExecutor().doQuery(null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return state;
    }

}
