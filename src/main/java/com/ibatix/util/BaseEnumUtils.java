package com.ibatix.util;

import com.ibatix.core.support.BaseEnum;

/**
 * 枚举工具类
 *
 * @author master
 */
public class BaseEnumUtils {
    private BaseEnumUtils() {

    }

    /**
     * 根据自定义枚举编号创建枚举
     *
     * @param enumClass 枚举类
     * @param code      枚举编码
     * @param <E>       运行时枚举类型
     * @return 枚举
     */
    public static <E extends Enum<?> & BaseEnum> E valueOf(Class<E> enumClass, int code) {
        E[] enumConstants = enumClass.getEnumConstants();
        for (E e : enumConstants) {
            if (e.getCode() == code) return e;
        }
        throw new RuntimeException("不存在的枚举值");
    }
}
