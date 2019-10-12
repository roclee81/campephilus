package org.cqu.edu.msc.annihilation.campephilus.module.sys.log.service;

import org.cqu.edu.msc.annihilation.campephilus.module.sys.log.entity.SystemLog;

import java.util.List;

/**
 * campephilus
 *
 * @author lx
 * @date 2019/10/11
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface SystemLogService {

    /**
     * SystemLog保存
     */
    void save(SystemLog systemLog);

    /**
     * 得到当天的日志
     *
     * @param page 页
     * @param size 每页条数
     * @return List<SystemLog>
     */
    List<SystemLog> listCurrentDay(int page, int size);

    /**
     * 得到当天的日志
     * 同时满足日志的级别
     *
     * @param page     页
     * @param size     每页条数
     * @param logLevel 日志级别
     * @return List<SystemLog>
     */
    List<SystemLog> listCurrentDayAndLogLevel(int page, int size, int logLevel);

    /**
     * 得到所有的日志
     *
     * @param page 页
     * @param size 每页条数
     * @return List<SystemLog>
     */
    List<SystemLog> list(int page, int size);
}
