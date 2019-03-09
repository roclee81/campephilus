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
public class VersionInformationDO extends CommonDO {

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

}
