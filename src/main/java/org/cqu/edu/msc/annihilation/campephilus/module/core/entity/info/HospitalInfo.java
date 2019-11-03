package org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.cqu.edu.msc.annihilation.common.converter.LocalDateTimeConverter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/18 17:29
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "info_hospital")
public class HospitalInfo implements Serializable {

    private static final long serialVersionUID = 1754584679477101566L;

    /**
     * 全国医院序列号，唯一
     */
    @Id
    @Column(name = "pk_hospital_code")
    private String hospitalCode;

    /**
     * 医院名称
     */
    @NotBlank(message = "hospitalName must cannot empty")
    @Column(name = "hospital_name")
    private String hospitalName;

    /**
     * 医院区域
     */
    @NotBlank(message = "hospitalArea must cannot empty")
    @Column(name = "hospital_area")
    private String hospitalArea;

    /**
     * 医院的等级3甲等
     */
    @NotBlank(message = "hospitalLevel must cannot empty")
    @Column(name = "hospital_level")
    private String hospitalLevel;

    /**
     * 数据创建时间
     */
    @JsonSerialize(using = LocalDateTimeConverter.class)
    @Column(name = "gmt_create")
    private LocalDateTime gmtCreate;

    /**
     * 数据修改时间
     */
    @JsonSerialize(using = LocalDateTimeConverter.class)
    @Column(name = "gmt_modified")
    private LocalDateTime gmtModified;
}
