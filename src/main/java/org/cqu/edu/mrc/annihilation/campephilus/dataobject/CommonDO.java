package org.cqu.edu.mrc.annihilation.campephilus.dataobject;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * @author lx
 * @version V1.0
 * @date 2019/3/9 20:12
 * @email vinicolor.violet.end@gmail.com
 * Description:
 * 公有属性
 */
@Data
class CommonDO {

    /**
     * 编号 MongoDB自动生成
     */
    private String id;

    /**
     * 手术的顺序号，唯一
     */
    @Field(value = "operation_number")
    private Integer operationNumber;

    /**
     * 采集器的MAC地址
     */
    @Field(value = "collector_mac_address")
    private String collectorMacAddress;

    /**
     * 数据创建时间
     */
    @Field(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 数据修改时间
     */
    @Field(value = "gmt_modified")
    private Date gmtModified;

}
