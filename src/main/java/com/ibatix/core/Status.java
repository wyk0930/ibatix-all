package com.ibatix.core;

import com.ibatix.core.support.BaseEnum;

/**
 * 文件状态
 *
 * @author master
 */
public enum Status implements BaseEnum {
    INVALID(-1, "无效"),
    INACTIVE(0, "非活动"),
    ACTIVE(1, "活动"),
    HISTORIC(2, "历史版本");

    Status(Integer code, String desc) {
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
