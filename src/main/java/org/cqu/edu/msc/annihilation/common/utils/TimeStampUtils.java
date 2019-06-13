package org.cqu.edu.msc.annihilation.common.utils;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Vinicolor
 * @date 2018/8/29
 * <p>
 * Description:
 * 时间戳工具类
 */
public class TimeStampUtils {

    public static Long convertLongTimeStamp(Date date) {
        return date.getTime();
    }

    public static Long getCurrentLongTimeStamp() {
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
}
