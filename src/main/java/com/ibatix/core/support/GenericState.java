package com.ibatix.core.support;

import com.ibatix.core.BaseEnum;

/**
 * 通用状态
 *
 * @author master
 */
public enum GenericState implements BaseEnum {
    ACTIVE(1, "活动"),
    INACTIVE(0, "非活动"),
    INVALID(-1, "无效");

    GenericState(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private Integer code;
    private String desc;

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
