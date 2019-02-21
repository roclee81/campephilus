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
}
