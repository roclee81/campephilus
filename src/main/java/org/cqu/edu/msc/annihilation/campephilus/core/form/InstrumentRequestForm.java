package org.cqu.edu.msc.annihilation.campephilus.core.form;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/24 16:33
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
@Valid
public class InstrumentRequestForm {

    /**
     * 数据传输操作码
     */
    @Min(value = 0, message = "The code must be greater than the protocol minimum")
    @Max(value = 200, message = "The code must be less than the protocol maximum")
    @NotNull(message = "The code cannot be empty")
    private Integer code;

    /**
     * 采集器的MAC地址
     */
    @NotNull(message = "The mac cannot be empty")
    private String mac;

    /**
     * 手术顺序号
     */
    @Min(value = -1, message = "The operationNumber must be greater than the protocol minimum")
    @NotNull(message = "The operationNumber cannot be empty")
    private Integer operationNumber;

    /**
     * 包含信息的Data
     */
    @NotNull(message = "The data cannot be empty")
    private String data;
}
