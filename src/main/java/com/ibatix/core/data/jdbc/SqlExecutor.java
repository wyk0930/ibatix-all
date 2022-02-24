package com.ibatix.core.data.jdbc;

import com.ibatix.core.CommandExecutor;

import java.util.List;

public interface SqlExecutor extends CommandExecutor {

    <S, T> List<T> doQuery(SqlConnection sqlConnection, QueryRequest<S, T> queryRequest, Object... params) throws Exception;

}
