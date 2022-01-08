package com.ibatix.util;

import java.util.UUID;

/**
 * 唯一键生成工具类。
 *
 * @author master
 */
public final class UniqueKeyUtils {

    /**
     * 构造器
     */
    private UniqueKeyUtils() {
    }

    /**
     * 生成一个UUID字符串
     *
     * @return UUID字符串
     */
    public static String nextUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }
}
