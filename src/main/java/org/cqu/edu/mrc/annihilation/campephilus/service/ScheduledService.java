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
    void checkCollectorState();

    /**
     * 处理每分钟请求，即将每分钟的请求数量存储，保存成在一分钟的请求量，以及无效请求
     */
    void handleRequestsMinuteSecond();

    /**
     * 处理每小时请求，即将每小时的请求数量存储，保存成在一个小时的请求量，以及无效请求
     */
    void handleRequestsPerHour();

    /**
     * 处理每天请求，即将小时的请求数量存储，保存成在一天的请求量，以及无效请求
     */
    void handleRequestsPerDay();
}
