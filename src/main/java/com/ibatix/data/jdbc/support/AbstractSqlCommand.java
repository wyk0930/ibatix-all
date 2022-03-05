package com.ibatix.data.jdbc.support;

import com.ibatix.core.Command;
import com.ibatix.core.State;
import com.ibatix.data.jdbc.SqlCommandExecutor;

public abstract class AbstractSqlCommand implements Command {
    private SqlCommandExecutor executor;

    protected AbstractSqlCommand(SqlCommandExecutor executor) {
        this.executor = executor;
    }

    public abstract State execute();

    protected SqlCommandExecutor getExecutor() {
        return this.executor;
    }
}
