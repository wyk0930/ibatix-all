package com.ibatix.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * JSON处理工具类
 *
 * @author master
 */
public final class JsonUtils {
    public static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 构造器
     */
    private JsonUtils() {

    }

    /**
     * 将Json字符串数据转换为Java对象
     *
     * @param json       JSON字符串
     * @param targetType 目标类型
     * @param <T>        运行时类型
     * @return JavaBean
     */
    public static <T> T fromJsonString(String json, Class<T> targetType) {
        T target = null;
        try {
            target = objectMapper.readValue(json, targetType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return target;
    }

    /**
     * 将Json二进制数据转换为Java对象
     *
     * @param json       JSON二进制数据
     * @param targetType 目标类型
     * @param <T>        运行时类型
     * @return JavaBean
     */
    public static <T> T fromJsonBytes(byte[] json, Class<T> targetType) {
        T target = null;
        try {
            target = objectMapper.readValue(json, targetType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return target;
    }

    /**
     * 将JavaBean转换为JSON字符串
     *
     * @param arg JavaBean
     * @return JSON字符串
     */
    public static String toJsonAsString(Object arg) {
        String str = null;
        try {
            str = objectMapper.writeValueAsString(arg);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 将JavaBean转换为JSON二进制数据
     *
     * @param arg JavaBean
     * @return JSON二进制数据
     */
    public static byte[] toJsonAsBytes(Object arg) {
        byte[] bytes = new byte[0];
        try {
            bytes = objectMapper.writeValueAsBytes(arg);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}
