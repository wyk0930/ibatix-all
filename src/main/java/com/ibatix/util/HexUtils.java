package com.ibatix.util;

/**
 * 十六进制数转换工具类
 *
 * @author master
 */
public class HexUtils {

    /**
     * 十六进制数集合
     */
    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
            'e', 'f'};

    /**
     * 十六进制数集合
     */
    private static final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
            'E', 'F'};

    /**
     * 将byte[]数据转换为十六进制字符串
     *
     * @param data 源数据
     * @return 十六进制字符串
     */
    public static String encodeHexString(final byte[] data) {
        return new String(encodeHex(data));
    }

    /**
     * 将byte[]数据转换为char[]数组
     *
     * @param data 源数据
     * @return char[]数组
     */
    public static char[] encodeHex(final byte[] data) {
        return encodeHex(data, true);
    }

    /**
     * @param data        源数据
     * @param toLowerCase 是否使用小写
     * @return char[]数组
     */
    public static char[] encodeHex(final byte[] data, final boolean toLowerCase) {
        return encodeHex(data, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER);
    }

    /**
     * @param data     源数据
     * @param toDigits 十六进制数字集合
     * @return char[]数组
     */
    private static char[] encodeHex(final byte[] data, final char[] toDigits) {
        final int l = data.length;
        final char[] out = new char[l << 1];
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = toDigits[(0xF0 & data[i]) >>> 4];
            out[j++] = toDigits[0x0F & data[i]];
        }
        return out;
    }
}
