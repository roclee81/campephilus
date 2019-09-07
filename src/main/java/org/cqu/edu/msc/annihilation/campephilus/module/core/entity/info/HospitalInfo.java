package org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/18 17:29
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@EqualsAndHashCode(callSuper = true)
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "info_hospital")
public class HospitalInfo extends BaseInfoSuperclass implements Serializable {

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
}
