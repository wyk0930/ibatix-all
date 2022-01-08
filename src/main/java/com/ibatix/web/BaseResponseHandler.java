package com.ibatix.web;


import java.io.Serializable;

/**
 * 响应内容工具类
 *
 * @param <T> 响应数据实体运行时类型
 * @author master
 */
public abstract class BaseResponseHandler<T> implements Serializable {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 构造器
     */
    private BaseResponseHandler() {

    }

    /**
     * 构造器
     *
     * @param status 响应状态
     */
    protected BaseResponseHandler(ResponseStatus status) {
        this(status.getCode(), status.getMessage());
    }

    /**
     * 构造器
     *
     * @param code    状态码
     * @param message 消息
     */
    protected BaseResponseHandler(String code, String message) {
        this(Integer.valueOf(code), message);
    }

    /**
     * 构造器
     *
     * @param code    状态码
     * @param message 消息
     */
    protected BaseResponseHandler(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

    /**
     * 获取编码
     *
     * @return 编码
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 获取消息
     *
     * @return 消息
     */
    public String getMessage() {
        return message;
    }
}
