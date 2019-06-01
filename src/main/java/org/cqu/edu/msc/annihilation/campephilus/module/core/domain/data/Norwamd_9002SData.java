package org.cqu.edu.msc.annihilation.campephilus.module.core.domain.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/11 17:26
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@EqualsAndHashCode(callSuper = true)
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "data_norwamd_9002s")
public class Norwamd_9002SData extends BaseSuperclass {

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
}
