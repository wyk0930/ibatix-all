package com.ibatix.sample;

import com.ibatix.core.BaseEnum;

/**
 * 关系标注状态
 *
 * @author master
 */
public enum RelationState implements BaseEnum {
    INVALID(-1, "无效"),
    INACTIVE(0, "非活动"),
    ACTIVE(1, "活动");

    private RelationState(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;

    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
