package org.cqu.edu.msc.annihilation.common.utils;

import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

/**
 * @author Vinicolor
 * @date 2018/8/29
 * <p>
 * Description:
 * 时间戳工具类
 * 类中命名规则：
 * Date代表年月日
 * Time年月日时分秒
 */
public class TimeStampUtils {

    private static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * 将某时间字符串转为自定义时间格式的LocalDateTime
     * 由于返回LocalDateTime，所以将会采用yyyy-MM-dd HH:mm:ss格式解析
     *
     * @param str 待解析的字符串
     *            字符串格式2019-08-01 11:11:11
     * @return LocalDateTime
     * @throws DateTimeException if an error occurs during formatting
     */
    public static LocalDateTime parseStringToLocalDateTime(String str) throws DateTimeException {
        return LocalDateTime.parse(str, DEFAULT_FORMATTER);
    }

    /**
     * 解析字符串返回LocalDate
     * 由于返回LocalDate，所以将会采用yyyy-MM-dd格式解析
     *
     * @param str 待解析的字符串
     *            字符串格式2019-08-01
     * @return LocalDate
     * @throws DateTimeException if an error occurs during formatting
     */
    public static LocalDate parseStringToLocalDate(String str) throws DateTimeException {
        return LocalDate.parse(str, DATE_FORMATTER);
    }

    /**
     * 将LocalDateTime转为自定义的时间格式的字符串
     * 默认转换为yyyy-MM-dd HH:mm:ss
     *
     * @param localDateTime 待转换的数据
     * @param pattern       自定义转换的格式
     * @return 输出示例2019-10-12 16:16:16
     * @throws DateTimeException if an error occurs during formatting
     */
    public static String parseLocalDateTimeToString(LocalDateTime localDateTime, String pattern) throws DateTimeException {
        if (Objects.isNull(pattern)) {
            return DEFAULT_FORMATTER.format(localDateTime);
        } else {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
            return dateTimeFormatter.format(localDateTime);
        }
    }

    /**
     * 得到当前的时间的字符串
     * 例如 2019-10-12 16:16:16
     *
     * @return 当前时间的字符串
     */
    public static String getCurrentTimeAsString() {
        return parseLocalDateTimeToString(parseTimeStampToLocalDateTime(getCurrentMillisecondTimeStamp()), null);
    }

    /**
     * 将long类型的timestamp转为LocalDateTime
     * 能够自动检测传入的时间戳的位数，如果传入秒单位，将会损失毫秒
     *
     * @param timestamp 传入的时间戳
     * @return 实例化的LocalDateTime对象
     */
    public static LocalDateTime parseTimeStampToLocalDateTime(long timestamp) {
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
    public static long parseLocalDateTimeToTimeStamp(LocalDateTime localDateTime) {
        if (null == localDateTime) {
            return getCurrentSecondTimeStamp();
        }
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return instant.toEpochMilli() / 1000;
    }


    public static long parseDateToTimeStamp(Date date) {
        return date.getTime();
    }

    private static long getCurrentSecondTimeStamp() {
        return System.currentTimeMillis() / 1000;
    }

    private static long getCurrentMillisecondTimeStamp() {
        return System.currentTimeMillis();
    }

    public static Timestamp getCurrentTimeStamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 得到与当前时间前多少分钟的时间戳
     *
     * @param minute 当前时间前多少分钟
     * @return 当前时间前多少分钟的时间戳
     */
    public static long getMinuteBeforeTimeStampValue(int minute) {
        return getCurrentTimeStampValue() - 60 * minute;
    }

    /**
     * 得到与当前时间前一天的时间戳
     *
     * @param days 当前时间前多少天
     * @return 当前时间前一天的时间戳
     */
    public static long getDayBeforeTimeStampValue(int days) {
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
        return parseTimeStampToLocalDateTime(currentTimestamps - (currentTimestamps + 60 * 60 * 8 * 1000) % oneDayTimestamps);
    }


    public static LocalDateTime getDateTimeOfTimeStampBeforeMonth(int month) {
        return parseTimeStampToLocalDateTime(getMonthBeforeTimeStampValue(month));
    }

    public static LocalDateTime getLocalDateTime4TimeStampBeforeMinute(int minutes) {
        return parseTimeStampToLocalDateTime(getMinuteBeforeTimeStampValue(minutes));
    }


    public static long getCurrentLongTimeStamp() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * 得到当前的时间戳
     *
     * @return 当前时间戳
     */
    private static long getCurrentTimeStampValue() {
        return System.currentTimeMillis();
    }

    public static Long getMinuteAfterTimeStampValue(int minute) {
        return getCurrentTimeStampValue() + 60 * minute * 1000L;
    }

    public static LocalDateTime getLocalDateTimeMinuteAfterTimeStampValue(int minute) {
        return parseTimeStampToLocalDateTime(getMinuteAfterTimeStampValue(minute));
    }

    public static long getSpecificLongFromCurrentTime(int months, int days, int hours, int minutes, boolean before) {
        return before ? getCurrentLongTimeStamp() - 2592000L * months - 86400 * days - 3600 * hours - 60 * minutes :
                getCurrentLongTimeStamp() + 2592000L * months + 86400 * days + 3600 * hours + 60 * minutes;
    }

    /**
     * 得到当前时间的之后或者之前指定的时间
     *
     * @param months  month
     * @param days    day
     * @param hours   hour
     * @param minutes minute
     * @param before  true代表之前，false代表之后
     * @return 返回指定的LocalDateTime
     */
    public static LocalDateTime getSpecificLocalDateTimeFromCurrentTime(int months, int days, int hours, int minutes, boolean before) {
        return parseTimeStampToLocalDateTime(getSpecificLongFromCurrentTime(months, days, hours, minutes, before));
    }

    public static Long getMonthBeforeTimeStampValue(int month) {
        return getCurrentLongTimeStamp() - 2592000L * month;
    }
}
