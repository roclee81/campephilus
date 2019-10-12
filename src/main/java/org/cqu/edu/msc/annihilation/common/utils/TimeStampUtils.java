package org.cqu.edu.msc.annihilation.common.utils;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

/**
 * @author Vinicolor
 * @date 2018/8/29
 * <p>
 * Description:
 * 时间戳工具类
 */
public class TimeStampUtils {

    private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 将LocalDateTime转为自定义的时间格式的字符串
     * 默认转换为yyyy-MM-dd HH:mm:ss
     *
     * @param localDateTime 待转换的数据
     * @param pattern       自定义转换的格式
     * @return 输出示例2019-10-12 16:16:16
     */
    public static String getDateTimeAsString(LocalDateTime localDateTime, String pattern) {
        if (Objects.isNull(pattern)) {
            return DF.format(localDateTime);
        } else {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
            return dateTimeFormatter.format(localDateTime);
        }

    }

    public static String getCurrentAsString() {
        return getDateTimeAsString(getDateTimeOfTimestamp(getCurrentLongMillisecondTimeStamp()), null);
    }

    /**
     * 将long类型的timestamp转为LocalDateTime
     * 能够自动检测传入的时间戳的位数，如果传入秒单位，将会损失毫秒
     *
     * @param timestamp 传入的时间戳
     * @return 实例化的LocalDateTime对象
     */
    public static LocalDateTime getDateTimeOfTimestamp(long timestamp) {
        // 判断是否传入的是以秒为单位，如果是的，将会0补齐
        if (checkTimestampSecondDigit(timestamp)) {
            timestamp *= 1000;
        }
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    /**
     * 判断是否传入的是以秒为单位
     *
     * @param timestamp 传入的时间戳
     * @return 如果是以秒为单位将返回true
     */
    private static boolean checkTimestampSecondDigit(long timestamp) {
        return String.valueOf(timestamp).length() == 10;
    }

    /**
     * 将LocalDateTime转为long类型的timestamp
     *
     * @param localDateTime 传入的localDateTime
     * @return 转换的timestamp
     */
    public static long getTimestampOfDateTime(LocalDateTime localDateTime) {
        if (null == localDateTime) {
            return getCurrentLongSecondTimeStamp();
        }
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return instant.toEpochMilli() / 1000;
    }

    /**
     * 将某时间字符串转为自定义时间格式的LocalDateTime
     *
     * @param time
     * @param format
     * @return
     */
    public static LocalDateTime parseStringToDateTime(String time, String format) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(time, df);
    }

    public static long convertLongTimeStamp(Date date) {
        return date.getTime();
    }

    private static long getCurrentLongSecondTimeStamp() {
        return System.currentTimeMillis() / 1000;
    }

    private static long getCurrentLongMillisecondTimeStamp() {
        return System.currentTimeMillis();
    }

    public static Timestamp getCurrentTimeStamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 得到当前的时间戳
     *
     * @return 当前时间戳
     */
    private static Integer getCurrentTimeStampValue() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    /**
     * 得到与当前时间前多少分钟的时间戳
     *
     * @param minute 当前时间前多少分钟
     * @return 当前时间前多少分钟的时间戳
     */
    public static Integer getMinuteBeforeTimeStampValue(int minute) {
        return getCurrentTimeStampValue() - 60 * minute;
    }

    /**
     * 得到与当前时间前一天的时间戳
     *
     * @param days 当前时间前多少天
     * @return 当前时间前一天的时间戳
     */
    public static Integer getDayBeforeTimeStampValue(int days) {
        return getCurrentTimeStampValue() - 86400 * days;
    }

    public static Long getTimeStampOfTimeStampObject(Timestamp markTime) {
        return markTime.getTime() / 1000;
    }

    /**
     * 得到当天的零时的LocalDateTime
     * 例如当前时间为11:10，得到的为0:00的时间戳
     * java自带获得当前毫秒时间戳的方法是System.currentTimeMillis()，零点是24小时轮回的零界点。
     * 所以我们把当前时间戳取24小时毫秒数取余，然后用当前毫秒时间戳减这个余就行。
     *
     * @return 对应的LocalDateTime
     */
    public static LocalDateTime getCurrentDayZeroLocalDateTime() {
        long currentTimestamps = System.currentTimeMillis();
        long oneDayTimestamps = 60 * 60 * 24 * 1000;
        return getDateTimeOfTimestamp(currentTimestamps - (currentTimestamps + 60 * 60 * 8 * 1000) % oneDayTimestamps);
    }
}
