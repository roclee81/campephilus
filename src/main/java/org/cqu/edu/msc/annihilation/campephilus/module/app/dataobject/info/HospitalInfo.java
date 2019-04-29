package org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.info;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/18 17:29
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@DynamicUpdate
@Entity
@Data
@Table(name = "info_hospital")
public class HospitalInfo {
    /**
     * 全国医院序列号，唯一
     */
    @Id
    @Column(name = "pk_hospital_id")
    private String hospitalId;

    /**
     * 医院名称
     */
    @Column(name = "hospital_name")
    private String hospitalName;

    /**
     * 医院区域
     */
    @Column(name = "hospital_area")
    private String hospitalArea;

    /**
     * 医院的等级3甲等
     */
    @Column(name = "hospital_level")
    private String hospitalLevel;

    /**
     * 数据创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 数据修改时间
     */
    @Column(name = "gmt_modified")
    private Date gmtModified;
}
