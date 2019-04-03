package org.cqu.edu.msc.annihilation.campephilus.core.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/22 14:24
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
public class VersionInformationDTO {

    /**
     * APP端最新版本号
     */
    @Field(value = "application_version")
    private String applicationVersion;

    /**
     * 硬件端的版本号
     */
    @Field(value = "collector_version")
    private String collectorVersion;

    /**
     * 数据创建时间
     */
    @Field(value = "gmt_create")
    private Date gmtCreate;
}
