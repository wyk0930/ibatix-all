package com.ibatix.core;

public abstract class AbstractCommand<T extends Payload> implements Command {

    private CommandExecutor executor;

    protected AbstractCommand(CommandExecutor executor) {
        this.executor = executor;
    }

    @Override
    public Stats execute() {
        Stats stats = null;
        T runtimeArgs = null;

        try {
            runtimeArgs = before(null);
            stats = exec(runtimeArgs);

            after(stats);
        } catch (Exception e) {
            afterThrowing(runtimeArgs, stats, e);
        } finally {
            afterReturning(stats);
        }
        return stats;
    }

    protected abstract Stats exec(T arg);

    protected <T> T before(T arg) {
        return arg;
    }

    protected void after(Stats stats) {

    }

    protected <T> void afterThrowing(T arg, Stats stats, Exception e) {

    }

    protected void afterReturning(Stats stats) {

    }
}
