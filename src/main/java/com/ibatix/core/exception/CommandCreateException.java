package com.ibatix.core.exception;


import com.ibatix.core.support.VendorCode;
import com.ibatix.util.MessageUtils;

/**
 * 自定义基础异常类
 *
 * @author master
 */
public class CommandCreateException extends BaseException {
    /**
     * 构造器
     */
    public CommandCreateException() {
        super();
    }
    
    /**
     * 构造器
     *
     * @param vendorCode 厂商代码
     * @param args       消息模版参数
     */
    public CommandCreateException(VendorCode vendorCode, String... args) {
        super(MessageUtils.format(vendorCode.getTemplate(), args));
    }

    /**
     * 构造器
     *
     * @param vendorCode 厂商代码
     * @param cause      异常原因
     * @param args       消息模版参数
     */
    public CommandCreateException(VendorCode vendorCode, Throwable cause, String... args) {
        super(MessageUtils.format(vendorCode.getTemplate(), args), cause);
    }
}
