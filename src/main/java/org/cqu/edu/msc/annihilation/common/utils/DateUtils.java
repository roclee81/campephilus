package org.cqu.edu.msc.annihilation.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/25 22:53
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class DateUtils {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static String getCurrentDateString() {
        return SIMPLE_DATE_FORMAT.format(new Date());
    }

    public static java.sql.Date getCurrentSqlDate() {
        return new java.sql.Date(convertLong(new Date()));
    }

    public static String getSpecifiedDateString(Date specifiedDate) {
        return SIMPLE_DATE_FORMAT.format(specifiedDate);
    }

    public static long convertLong(Date date) {
        return date.getTime();
    }
}
