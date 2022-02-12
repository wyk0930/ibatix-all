package com.ibatix.util;

import com.ibatix.core.support.VendorCode;
import com.ibatix.core.exception.BaseException;

import java.text.MessageFormat;

/**
 * 消息格式化工具
 *
 * @author master
 */
public final class MessageUtils {

    /**
     * 构造器
     */
    private MessageUtils() {

    }

    /**
     * 格式化指定消息
     *
     * @param pattern 消息模版
     * @param args    消息参数
     * @return 格式化结果
     */
    public static String format(String pattern, String... args) {
        if (StringUtils.isNullOrBlank(pattern)) {
            throw new BaseException(VendorCode.EER_0001);
        }
        return MessageFormat.format(pattern, args);
    }
}
