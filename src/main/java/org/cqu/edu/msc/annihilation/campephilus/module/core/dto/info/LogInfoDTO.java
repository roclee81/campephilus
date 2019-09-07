package org.cqu.edu.msc.annihilation.campephilus.module.core.dto.info;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/12 16:02
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
public class LogInfoDTO implements Serializable {

    private static final long serialVersionUID = 4009046787822594239L;
    /**
     * 标记id，自动增长
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Integer id;

    @NotBlank(message = "error must cannot empty")
    @Column(name = "error")
    private String error;

    private Long longModified;

    private Long longCreate;
}
