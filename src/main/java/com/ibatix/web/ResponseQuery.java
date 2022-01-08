package com.ibatix.web;

import com.ibatix.core.data.Page;

import java.util.List;

/**
 * 响应内容工具类
 *
 * @param <T> 响应数据实体运行时类型
 * @author master
 */
public final class ResponseQuery<T> extends BaseResponseHandler<T> {

    /**
     * 响应数据
     */
    private List<T> data;

    /**
     * 页码
     */
    private Integer pageNo = -1;

    /**
     * 页面容量
     */
    private Integer pageSize = -1;

    /**
     * 查询总数
     */
    private Integer total = -1;

    /**
     * 构造器
     *
     * @param status 响应状态
     */
    private ResponseQuery(Page<T> page, ResponseStatus status) {
        this(page, status.getCode(), status.getMessage());
    }

    /**
     * 构造器
     *
     * @param page    结果数据集
     * @param code    状态码
     * @param message 消息
     */
    private ResponseQuery(Page<T> page, Integer code, String message) {
        super(code, message);
        data = page.getContent();
        pageNo = page.getPageNo();
        pageSize = page.getPageSize();
        total = page.getTotal();
    }

    /**
     * 构造器
     *
     * @param page    结果数据集
     * @param code    状态码
     * @param message 消息
     */
    private ResponseQuery(Page<T> page, String code, String message) {
        super(code, message);
        data = page.getContent();
        pageNo = page.getPageNo();
        pageSize = page.getPageSize();
        total = page.getTotal();
    }

    /**
     * 返回失败响应信息
     *
     * @param status 响应状态
     * @param <T>    响应数据实体运行时类型
     * @return 响应信息
     */
    public static <T> ResponseQuery<T> error(ResponseStatus status) {
        return new ResponseQuery(null, status);
    }

    /**
     * 返回失败响应信息
     *
     * @param code    状态码
     * @param message 消息
     * @param <T>     响应数据实体运行时类型
     * @return 响应信息
     */
    public static <T> ResponseQuery<T> error(String code, String message) {
        return new ResponseQuery(null, code, message);
    }

    /**
     * 返回失败响应信息
     *
     * @param code    状态码
     * @param message 消息
     * @param <T>     响应数据实体运行时类型
     * @return 响应信息
     */
    public static <T> ResponseQuery<T> error(Integer code, String message) {
        return new ResponseQuery(null, code, message);
    }

    /**
     * 返回成功响应信息
     *
     * @param page   分页信息
     * @param status 响应状态
     * @param <T>    响应数据实体运行时类型
     * @return 响应信息
     */
    public static <T> ResponseQuery<T> success(Page<T> page, ResponseStatus status) {
        return success(page, status.getCode(), status.getMessage());
    }

    /**
     * 返回成功响应信息
     *
     * @param page    分页信息
     * @param code    状态码
     * @param message 消息
     * @param <T>     响应数据实体运行时类型
     * @return 响应信息
     */
    public static <T> ResponseQuery<T> success(Page<T> page, String code, String message) {
        return success(page, Integer.valueOf(code), message);
    }

    /**
     * 返回成功响应信息
     *
     * @param page    分页信息
     * @param code    状态码
     * @param message 消息
     * @param <T>     响应数据实体运行时类型
     * @return 响应信息
     */
    public static <T> ResponseQuery<T> success(Page<T> page, Integer code, String message) {
        ResponseQuery response = new ResponseQuery(page, code, message);
        return response;
    }

    /**
     * 获取页面编号
     *
     * @return 页面编号
     */
    public Integer getPageNo() {
        return pageNo;
    }

    /**
     * 获取页面容量
     *
     * @return 页面容量
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 获取查询记录总数
     *
     * @return 记录总数
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * 获取响应数据
     *
     * @return 响应数据
     */
    public List<T> getData() {
        return data;
    }
}
