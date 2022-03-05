package com.ibatix.data.jdbc;

import com.ibatix.core.CommandExecutor;

import java.util.List;

public interface SqlCommandExecutor extends CommandExecutor {

    <S, T> List<T> doQuery(SqlConnection sqlConnection, QueryCommand<S, T> queryCommand) throws Exception;

}
