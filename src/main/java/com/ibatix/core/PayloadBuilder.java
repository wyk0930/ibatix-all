package com.ibatix.core;

/**
 * 参数主体数据构建器
 *
 * @param <T> 运行时类型，必股友为Payload接口实现类
 * @author master
 */
public interface PayloadBuilder<T extends Payload> {

    /**
     * 创建参数主体数据
     *
     * @return 参数
     */
    T build();
}
