package com.ibatix.core.exception;


import com.ibatix.core.support.VendorCode;
import com.ibatix.util.MessageUtils;

/**
 * 自定义基础异常类
 *
 * @author master
 */
public class BaseException extends RuntimeException {
    /**
     * 构造器
     */
    public BaseException() {
        super();
    }

    /**
     * 构造器
     *
     * @param message 异常信息
     */
    protected BaseException(String message) {
        super(message);
    }

    /**
     * 构造器
     *
     * @param message 异常信息
     * @param cause   异常原因
     */
    protected BaseException(String message, Throwable cause) {
        super(message, cause);
    }


    /**
     * 构造器
     *
     * @param cause 异常原因
     */
    protected BaseException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造器
     *
     * @param vendorCode 厂商代码
     * @param args       消息模版参数
     */
    public BaseException(VendorCode vendorCode, String... args) {
        super(MessageUtils.format(vendorCode.getTemplate(), args));
    }

    /**
     * 构造器
     *
     * @param vendorCode 厂商代码
     * @param cause      异常原因
     * @param args       消息模版参数
     */
    public BaseException(VendorCode vendorCode, Throwable cause, String... args) {
        super(MessageUtils.format(vendorCode.getTemplate(), args), cause);
    }
}
