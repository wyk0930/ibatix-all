package com.ibatix.web;

/**
 * 响应内容工具类
 *
 * @param <T> 响应数据实体运行时类型
 * @author master
 */
public final class ResponseData<T> extends BaseResponseHandler<T> {

    private T data;

    /**
     * 构造器
     *
     * @param data   结果数据集
     * @param status 响应状态
     */
    private ResponseData(T data, ResponseStatus status) {
        super(status);
        this.data = data;
    }

    /**
     * 构造器
     *
     * @param data    结果数据集
     * @param code    状态码
     * @param message 消息
     */
    private ResponseData(T data, String code, String message) {
        super(code, message);
        this.data = data;
    }

    /**
     * 构造器
     *
     * @param data    结果数据集
     * @param code    状态码
     * @param message 消息
     */
    private ResponseData(T data, Integer code, String message) {
        super(code, message);
        this.data = data;
    }

    /**
     * 返回失败响应信息
     *
     * @param status 响应状态
     * @param <T>    响应数据实体运行时类型
     * @return 响应信息
     */
    public static <T> ResponseData<T> error(ResponseStatus status) {
        return new ResponseData(null, status);
    }

    /**
     * 返回失败响应信息
     *
     * @param code    状态码
     * @param message 消息
     * @param <T>     响应数据实体运行时类型
     * @return 响应信息
     */
    public static <T> ResponseData<T> error(String code, String message) {
        return new ResponseData(null, code, message);
    }

    /**
     * 返回失败响应信息
     *
     * @param code    状态码
     * @param message 消息
     * @param <T>     响应数据实体运行时类型
     * @return 响应信息
     */
    public static <T> ResponseData<T> error(Integer code, String message) {
        return new ResponseData(null, code, message);
    }

    /**
     * 返回成功响应信息
     *
     * @param data   结果数据集
     * @param status 响应状态
     * @param <T>    响应数据实体运行时类型
     * @return 响应信息
     */
    public static <T> ResponseData<T> success(T data, ResponseStatus status) {
        return new ResponseData(data, status);
    }

    /**
     * 返回成功响应信息
     *
     * @param data    结果数据集
     * @param code    状态码
     * @param message 消息
     * @param <T>     响应数据实体运行时类型
     * @return 响应信息
     */
    public static <T> ResponseData<T> success(T data, String code, String message) {
        return new ResponseData(data, code, message);
    }

    /**
     * 返回成功响应信息
     *
     * @param data    结果数据集
     * @param code    状态码
     * @param message 消息
     * @param <T>     响应数据实体运行时类型
     * @return 响应信息
     */
    public static <T> ResponseData<T> success(T data, Integer code, String message) {
        return new ResponseData(data, code, message);
    }

    /**
     * 获取响应数据
     *
     * @return 响应数据
     */
    public T getData() {
        return data;
    }
}
