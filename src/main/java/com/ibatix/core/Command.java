package com.ibatix.core;

/**
 * 命令执行接口
 *
 * @author master
 */
public interface Command<T> {

    /**
     * 命令执行实现
     */
    State execute(T arg);

    CommandExecutor getExecutor();
}