package org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/13 20:56
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
@MappedSuperclass
class BaseInfoSuperclass {
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
