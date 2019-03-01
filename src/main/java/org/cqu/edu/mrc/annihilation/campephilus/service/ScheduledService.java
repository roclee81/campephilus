package org.cqu.edu.mrc.annihilation.campephilus.service;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/21 16:39
 * @email vinicolor.violet.end@gmail.com
 * Description:定时任务的服务
 * 主要用于：
 * 1.定时查询采集器状态是否符合
 */
public interface ScheduledService {

    /**
     * 检测采集器状态，每分钟检测一次
     * 通过采集器的最后上传时间进行检测，
     * 如果超过10分钟没有上传数据而且状态为在线的采集器，则将该采集器的状态改为离线
     */
    void checkCollectorStatePreMinute();

    /**
     * 统计每秒钟的请求数量以及无效请求
     * 将每秒的数据叠加到<code>hourRequest</code>和<code>hourRequestValid</code>里面
     */
    void handleRequestPreSecond();

    //TODO 不知道该方式合适与否

    /**
     * 处理每小时请求，即将每小时的请求数量存储，保存成在一个小时的请求量，以及无效请求
     * 每一小时存储一次，直接存储到数据中
     * 首先判断是否在数据库中存在，通过保存的存储时间判断，如果存在将数据取出，同时添加数据后再保存
     * 如果不存在，在此情况下默认为到第二天了，新建数据再存储
     * 在*：59：59触发，与handleRequestsPerDay方法分隔开，具体时间如下：
     * 2019-02-28 21:59:59
     * 2019-02-28 22:59:59
     * 2019-02-28 23:59:59
     * 2019-03-01 00:59:59
     * 2019-03-01 01:59:59
     * 2019-03-01 02:59:59
     */
    void handleRequestPerHour();

    /**
     * 处理每天请求，即将小时的请求数量存储，保存成在一天的请求量，以及无效请求
     */
    void handleRequestPerDay();
}
