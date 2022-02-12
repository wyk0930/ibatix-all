package com.ibatix.core;

/**
 * 命令执行接口
 *
 * @author master
 */
public interface Command<A, R> {

    /**
     * 命令执行实现
     */
    R execute(A... arg);
}