package org.cqu.edu.mrc.annihilation.campephilus.form;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/22 15:14
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
@Valid
public class InformationForm {

    /**
     * APP端最新版本号
     */
    @NotNull(message = "The applicationVersion cannot be empty")
    private String applicationVersion;

    /**
     * 硬件端的版本号
     */
    @NotNull(message = "The collectorVersion cannot be empty")
    private String collectorVersion;
}