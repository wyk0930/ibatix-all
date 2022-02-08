package com.ibatix.util;

/**
 * 对象空值判定工具类
 *
 * @author master
 */
public final class NullUtils {

    /**
     * 构造器
     */
    private NullUtils() {

    }

    /**
     * 指定对象不为空
     *
     * @param arg 对象
     * @return 判断结果
     */
    public static boolean isNotNullOrEmpty(Object... arg) {
        return !isNullOrEmpty(arg);
    }

    /**
     * 指定对象为空
     *
     * @param arg 对象
     * @return 判断结果
     */
    public static boolean isNullOrEmpty(Object... arg) {
        return isNull(arg) || arg.length == 0;
    }

    /**
     * 判断指定对象是否为空
     * <ol>
     * <li>true表示对象为空</li>
     * <li>false表示对象不为空</li>
     * </ol>
     *
     * @param arg 任意对象
     * @return 判断结果
     */
    public static boolean isNull(Object arg) {
        return arg == null;
    }

    /**
     * 判断指定对象是否不为空。
     * <ol>
     * <li>true表示对象不为空</li>
     * <li>false表示对象为空</li>
     * </ol>
     *
     * @param arg 任意对象
     * @return 判断结果
     */
    public static boolean isNotNull(Object arg) {
        return !isNull(arg);
    }
}
