package com.ibatix.core.exception;

import com.ibatix.core.support.VendorCode;

/**
 * 未知异常
 *
 * @author master
 */
public class UnknownException extends BaseException {
    public UnknownException() {
        super(VendorCode.ERR_9999);
    }

    private UnknownException(String message) {
        super(message);
    }

    private UnknownException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownException(Throwable cause) {
        super(VendorCode.ERR_9999,cause);
    }

    private UnknownException(VendorCode vendorCode, String... args) {
        super(vendorCode, args);
    }

    private UnknownException(VendorCode vendorCode, Throwable cause, String... args) {
        super(vendorCode, cause, args);
    }
}
