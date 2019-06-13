package org.cqu.edu.msc.annihilation.campephilus.module.core.domain.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/1 21:31
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
@MappedSuperclass
public class BaseDataSuperclass {

    /**
     * 自动增长
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Integer id;

    @Transient
    private Long longModified;

    @Transient
    private Long longCreate;

    /**
     * 数据创建时间
     */
    @JsonIgnore
    @Column(name = "gmt_create")
    private LocalDateTime gmtCreate;

    /**
     * 数据修改时间
     */
    @JsonIgnore
    @Column(name = "gmt_modified")
    private LocalDateTime gmtModified;

    /**
     * 序列号
     */
    @Column(name = "device_serial_number")
    private String serialNumber;

    /**
     * 手术顺序号
     */
    @NotNull(message = "operationNumber must cannot empty")
    @Column(name = "operation_number")
    private Integer operationNumber;
}
