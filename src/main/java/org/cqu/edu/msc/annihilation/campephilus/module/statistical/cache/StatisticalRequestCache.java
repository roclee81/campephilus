package org.cqu.edu.msc.annihilation.campephilus.module.statistical.cache;

/**
 * @author lx
 * @version V1.0
 * @date 2019/3/2 0:29
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class StatisticalRequestCache {

    /**
     * 每秒数据上传的请求数量
     */
    public static int secondRequest = 0;

    /**
     * 每秒数据上传的请求有效数量
     */
    public static int secondValidRequest = 0;

    /**
     * 每小时数据上传的请求数量
     */
    public static int hourRequest = 0;

    /**
     * 每小时数据上传的请求有效数量
     */
    public static int hourRequestValid = 0;
}
