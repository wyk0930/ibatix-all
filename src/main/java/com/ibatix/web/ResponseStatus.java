package com.ibatix.web;

import com.ibatix.core.support.BaseEnum;

/**
 * 响应状态信息
 *
 * @author WangYukun
 */
public enum ResponseStatus implements BaseEnum {
    SUCCESS(0, "响应成功"),
    ERROR(-1, "未知错误");

    ResponseStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;

    @Override
    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return msg;
    }
}
