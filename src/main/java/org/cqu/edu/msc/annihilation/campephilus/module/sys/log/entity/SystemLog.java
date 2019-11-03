package org.cqu.edu.msc.annihilation.campephilus.module.sys.log.entity;

import lombok.Data;
import org.cqu.edu.msc.annihilation.campephilus.module.sys.log.enums.SystemLogEnum;
import org.cqu.edu.msc.annihilation.common.utils.TimeStampUtils;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * campephilus
 *
 * @author lx
 * @date 2019/10/11
 * @email vinicolor.violet.end@gmail.com
 * Description:
 * 存储日志信息到数据库
 */
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "system_log")
public class SystemLog implements Serializable {

    private static final long serialVersionUID = 1633536198072422737L;
    /**
     * 标记id，自动增长
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Integer id;

    /**
     * 日志级别
     */
    private Integer logLevel;

    /**
     * 日志信息
     */
    private String message;

    /**
     * 数据创建时间，用于显示时间
     * 存储格式采用String，存储内容为2019/09/05/10:11
     */
    @Column(name = "record_date")
    private String recordDate;

    /**
     * 数据创建时间
     */
    @Column(name = "gmt_create")
    private LocalDateTime gmtCreate;

    /**
     * 数据修改时间
     */
    @Column(name = "gmt_modified")
    private LocalDateTime gmtModified;

    public SystemLog(Integer logLevel, String message, String recordDate) {
        this.logLevel = logLevel;
        this.message = message;
        this.recordDate = recordDate;
    }

    public static SystemLog structureSystemErrorLog(String message) {
        return new SystemLog(SystemLogEnum.ERROR.getCode(), message,
                TimeStampUtils.getCurrentTimeAsString());
    }

    public static SystemLog structureSystemInfoLog(String message) {
        return new SystemLog(SystemLogEnum.INFO.getCode(), message,
                TimeStampUtils.getCurrentTimeAsString());
    }
}
