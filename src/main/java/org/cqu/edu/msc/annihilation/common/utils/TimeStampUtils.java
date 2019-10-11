package org.cqu.edu.msc.annihilation.common.utils;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author Vinicolor
 * @date 2018/8/29
 * <p>
 * Description:
 * 时间戳工具类
 */
public class TimeStampUtils {


    public static String commonDataFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").toString();

    /**
     * 将LocalDateTime转为自定义的时间格式的字符串
     *
     * @param localDateTime
     * @param format
     * @return
     */
    public static String getDateTimeAsString(LocalDateTime localDateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return localDateTime.format(formatter);
    }

    public static String getCurrentAsString() {
        return getDateTimeAsString(getDateTimeOfTimestamp(getCurrentLongTimeStamp()), commonDataFormat);
    }

    /**
     * 将long类型的timestamp转为LocalDateTime
     *
     * @param timestamp
     * @return
     */
    public static LocalDateTime getDateTimeOfTimestamp(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    /**
     * 将LocalDateTime转为long类型的timestamp
     *
     * @param localDateTime
     * @return
     */
    public static long getTimestampOfDateTime(LocalDateTime localDateTime) {
        if (null == localDateTime) {
            return getCurrentLongTimeStamp();
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

    public static long getCurrentLongTimeStamp() {
        return System.currentTimeMillis() / 1000;
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
