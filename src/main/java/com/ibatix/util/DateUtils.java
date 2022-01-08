package com.ibatix.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日期工具类。用于完成各种日期格式/类型转换
 *
 * @author master
 */
public final class DateUtils {

    /**
     * 构造器
     */
    private DateUtils() {

    }

    /**
     * 将日期转换为指定格式
     *
     * @param date    指定日期
     * @param pattern 日期格式
     * @return 格式化结果
     */
    public static String toChar(Date date, String pattern) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(dtf);
    }

    /**
     * 字符串转换为时区时间
     * 字符串格式：2021-01-01T12:00:00+08:00
     *
     * @param dataString 日期字符串
     * @return 格式化结果
     */
    public static ZonedDateTime toZonedDateTime(String dataString) {
        ZonedDateTime zonedDateTime = ZonedDateTime.from(DateTimeFormatter
                .ISO_OFFSET_DATE_TIME
                .withZone(ZoneId.systemDefault())
                .parse(dataString));
        return zonedDateTime;
    }


    /**
     * 字符串转本地日期
     *
     * @param dataString 日期字符
     * @param pattern    日期格式
     * @return 格式化结果
     */
    public static LocalDate toLocalDate(String dataString, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(dataString, formatter);
    }

    /**
     * 将日期转换为本地日期时间
     *
     * @param dataString 日期时间字符串
     * @param pattern    日期时间格式
     * @return 格式化结果
     */
    public static LocalDateTime toLocalDateTime(String dataString, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(dataString, formatter);
    }
    
    /**
     * 将日期字符串转换成Date类型
     *
     * @param dataString 日期字符串
     * @param pattern    日期格式
     * @return 格式化结果
     */
    public static Date toDate(String dataString, String pattern) {
        LocalDateTime localDateTime = toLocalDateTime(dataString, pattern);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
