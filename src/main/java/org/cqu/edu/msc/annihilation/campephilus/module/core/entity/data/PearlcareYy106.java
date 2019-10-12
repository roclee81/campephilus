package org.cqu.edu.msc.annihilation.campephilus.module.core.entity.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/11 17:37
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@EqualsAndHashCode(callSuper = true)
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "data_pearlcare_yy106")
public class PearlcareYy106 extends BaseDataSuperclass implements Serializable {

    private static final long serialVersionUID = -6622470603257802385L;
    /**
     *
     */
    @Column(name = "AI")
    private Integer AI;

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
    @Column(name = "BSR")
    private Integer BSR;
}
