package com.ibatix.data.jdbc.support;

import com.ibatix.core.Command;
import com.ibatix.core.Stats;
import com.ibatix.data.jdbc.SqlCommandExecutor;

public abstract class AbstractSqlCommand implements Command {
    private SqlCommandExecutor executor;

    protected AbstractSqlCommand(SqlCommandExecutor executor) {
        this.executor = executor;
    }

    public abstract Stats execute();

    protected SqlCommandExecutor getExecutor() {
        return this.executor;
    }
}
