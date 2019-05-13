package org.cqu.edu.msc.annihilation.campephilus.module.core.domain.data;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/11 17:26
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(schema = "data_norwamd_9002s")
public class Norwamd_9002sDO {

    /**
     * 自动增长
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_norwamd_9002s_id")
    private Integer norwamd9002sId;

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
