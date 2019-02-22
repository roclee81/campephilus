package org.cqu.edu.mrc.annihilation.campephilus.dataobject;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/22 12:14
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Document(value = "version_information")
@Data
public class VersionInformationDO {

    /**
     * 编号 MongoDB自动生成
     */
    private String id;

    /**
     * APP端最新版本号
     */
    @Field(value = "application_version")
    private String applicationVersion;

    /**
     * 硬件端的版本号
     */
    @Field(value = "hardwareVersion")
    private String hardwareVersion;

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
