package com.ibatix.core;

/**
 * 用于业务状态持久化。
 * 该接口的实现枚举类可以以数值类型正常保存在数据库中。
 *
 * @author master
 */
public interface BaseEnum {
    Integer getCode();
}
