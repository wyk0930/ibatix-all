package com.ibatix.core;

public abstract class AbstractCommand<T extends Payload> implements Command<T> {

    private CommandExecutor executor;

    protected AbstractCommand(CommandExecutor executor) {
        this.executor = executor;
    }

    @Override
    public State execute(T arg) {
        State state = null;
        T runtimeArgs = null;

        try {
            runtimeArgs = before(arg);
            state = exec(runtimeArgs);

            after(state);
        } catch (Exception e) {
            afterThrowing(runtimeArgs, state, e);
        } finally {
            afterReturning(state);
        }
        return state;
    }

    protected abstract State exec(T arg);

    @Override
    public CommandExecutor getExecutor() {
        return null;
    }


    protected <T> T before(T arg) {
        return arg;
    }

    protected void after(State state) {

    }

    protected <T> void afterThrowing(T arg, State state, Exception e) {

    }

    protected void afterReturning(State state) {

    }
}
