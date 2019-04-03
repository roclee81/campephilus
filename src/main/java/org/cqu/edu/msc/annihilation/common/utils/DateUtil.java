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
public class DateUtil {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static String getCurrentDateString() {
        synchronized (SIMPLE_DATE_FORMAT) {
            return SIMPLE_DATE_FORMAT.format(new Date());
        }
    }

    public static String getSpecifiedDateString(Date specifiedDate) {
        synchronized (SIMPLE_DATE_FORMAT) {
            return SIMPLE_DATE_FORMAT.format(specifiedDate);
        }
    }
}
