package org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.time.LocalDateTime;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/13 20:56
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
@MappedSuperclass
public
class BaseInfoSuperclass {

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
}
