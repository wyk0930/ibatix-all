package com.ibatix.util;

import com.ibatix.core.support.DigestAlgorithm;
import com.ibatix.core.support.VendorCode;
import com.ibatix.core.exception.BaseException;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 消息摘要工具类
 *
 * @author master
 */
public final class DigestUtils {

    /**
     * 构造器
     */
    private DigestUtils() {

    }

    /**
     * 计算MD5消息摘要
     *
     * @param file 文件
     * @return MD5码
     */
    public static String md5sum(File file) {
        return digest(file, DigestAlgorithm.MD5);
    }

    /**
     * 计算MD5消息摘要
     *
     * @param in 文件输入流
     * @return MD5码
     */
    public static String md5sum(InputStream in) {
        return digest(in, DigestAlgorithm.MD5);
    }

    /**
     * 计算SHA256消息摘要
     *
     * @param file 文件
     * @return SHA256码
     */
    public static String sha256sum(File file) {
        return digest(file, DigestAlgorithm.SHA256);
    }

    /**
     * 计算SHA256消息摘要
     *
     * @param in 文件输入流
     * @return SHA256码
     */
    public static String sha256sum(InputStream in) {
        return digest(in, DigestAlgorithm.SHA256);
    }

    /**
     * 根据指定算法计算文件哈希值
     *
     * @param file      文件
     * @param algorithm 单向加密算法
     * @return 哈希值
     */
    public static String digest(File file, DigestAlgorithm algorithm) {
        FileInputStream in = null;
        String hex = null;
        try {
            in = new FileInputStream(file);
            hex = digest(in, algorithm);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return hex;
    }

    /**
     * 根据指定算法计算文件哈希值
     *
     * @param in        文件输入流
     * @param algorithm 单向加密算法
     * @return 哈希值
     */
    public static String digest(InputStream in, DigestAlgorithm algorithm) {
        MessageDigest digest = getDigest(algorithm);
        //分多次将一个文件读入，对于大型文件而言，比较推荐这种方式，占用内存比较少。
        byte[] buffer = new byte[1024];
        int length = -1;
        try {
            while ((length = in.read(buffer, 0, 1024)) != -1) {
                digest.update(buffer, 0, length);
            }
//            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] data = digest.digest();
        return HexUtils.encodeHexString(data);
    }

    /**
     * 根据指定算法计算文件哈希值
     *
     * @param buffer    文件缓存
     * @param algorithm 单向加密算法
     * @return 哈希值
     */
    public static String digest(byte[] buffer, DigestAlgorithm algorithm) {
        MessageDigest digest = getDigest(algorithm);
        digest.update(buffer, 0, buffer.length);
        byte[] data = digest.digest();
        return HexUtils.encodeHexString(data);
    }

    /**
     * 根据指定算法获取消息摘要计算器
     *
     * @param algorithm 算法
     * @return 消息摘要计算器
     */
    public static MessageDigest getDigest(DigestAlgorithm algorithm) {
        MessageDigest instance = null;
        try {
            instance = MessageDigest.getInstance(algorithm.getValue());
        } catch (NoSuchAlgorithmException e) {
            throw new BaseException(VendorCode.ERR_0000, e, algorithm.name());
        }
        return instance;
    }
}
