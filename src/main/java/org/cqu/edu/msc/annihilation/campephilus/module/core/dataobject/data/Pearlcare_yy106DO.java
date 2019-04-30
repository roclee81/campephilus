package org.cqu.edu.msc.annihilation.campephilus.module.core.dataobject.data;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/11 17:37
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@DynamicUpdate
@Entity
@Data
@Table(schema = "data_pearlcare_yy106")
public class Pearlcare_yy106DO {
    /**
     * 自动增长
     */
    @Id
    @GeneratedValue
    @Column(name = "pk_pearlcare_yy106_id")
    private Integer pearlcareYY106Id;

    /**
     *
     */
    @Column(name = "BS")
    private Integer BS;

    /**
     *
     */
    @Column(name = "EMG")
    private Integer EMG;

    /**
     *
     */
    @Column(name = "SQI")
    private Integer SQI;

    /**
     *
     */
    @Column(name = "CSI")
    private Integer CSI;

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

    /**
     * 手术顺序号
     */
    @Column(name = "operation_id")
    private Integer operationId;
}
