package org.cqu.edu.mrc.realdata.common.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Vinicolor
 * @date 2018/8/29
 * <p>
 * Description:
 * 时间戳工具类
 */
public class TimeStampUtil {

    /**
     * 得到当前的时间戳
     *
     * @return 当前时间戳
     */
    public static Integer getCurrentTimeStamp() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    /**
     * 得到与当前时间前一天的时间戳
     *
     * @return 当前时间前一天的时间戳
     */
    public static Integer getDayBeforeTimeStamp() {
        return getCurrentTimeStamp() - 86400;
    }

    /**
     * @return
     */
    public static Date getDayBeforeDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();
    }

    /**
     * @return
     */
    public static Date getDayAfterDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, +1);
        return calendar.getTime();
    }

    /**
     * @return
     */
    public static Date getWeekBeforeDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        return calendar.getTime();
    }

    /**
     * 通过 year month date 得到Date实体，注意这里是返回的月份已经对月份减去了1，可以直接输入需要的月份
     *
     * @param year
     * @param month
     * @param date
     * @return
     */
    public static Date getDate(Integer year, Integer month, Integer date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, date, 0, 0, 0);
        return calendar.getTime();
    }

    /**
     * 得到当前的时间
     *
     * @return
     */
    public static Date getDate() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    /**
     * 通过 year month date hourOfDay minute second得到Date实体，注意这里是返回的月份已经对月份减去了1，可以直接输入需要的月份
     *
     * @param year
     * @param month
     * @param date
     * @param hourOfDay
     * @param minute
     * @param second
     * @return
     */
    public static Date getDate(Integer year, Integer month, Integer date, Integer hourOfDay, Integer minute, Integer second) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, date, hourOfDay, minute, second);
        return calendar.getTime();
    }
}
