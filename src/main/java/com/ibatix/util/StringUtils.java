package com.ibatix.util;

/**
 * 字符串工具类
 *
 * @author master
 */
public final class StringUtils {

    /**
     * 构造器
     */
    private StringUtils() {

    }

    /**
     * 判断指定字符串不为空或空白
     * <ol>
     * <li>true表示对象不为空或空白</li>
     * <li>false表示对象为空或空白</li>
     * </ol>
     *
     * @param arg 字符串
     * @return 判断结果
     */
    public static boolean isNotNullOrBlank(String arg) {
        return !isNullOrBlank(arg);
    }

    /**
     * 判断指定字符串为空或空白
     * <ol>
     * <li>true表示对象为空或空白</li>
     * <li>false表示对象不为空或空白</li>
     * </ol>
     *
     * @param arg 字符串
     * @return 判断结果
     */
    public static boolean isNullOrBlank(String arg) {
        return isNull(arg) || arg.trim().length() == 0;
    }

    /**
     * 判断指定字符串不为空
     * <ol>
     * <li>true表示对象不为空</li>
     * <li>false表示对象为空</li>
     * </ol>
     *
     * @param arg 字符串
     * @return 判断结果
     */
    public static boolean isNotNull(String arg) {
        return !isNull(arg);
    }

    /**
     * 判断指定字符串为空
     * <ol>
     * <li>true表示对象为空</li>
     * <li>false表示对象不为空</li>
     * </ol>
     *
     * @param arg 字符串
     * @return 判断结果
     */
    public static boolean isNull(String arg) {
        return NullUtils.isNull(arg);
    }
}
