package org.cqu.edu.mrc.realdata.modules.app.form;

import lombok.Data;
import org.cqu.edu.mrc.realdata.common.validator.group.AddGroup;
import org.cqu.edu.mrc.realdata.common.validator.group.UpdateGroup;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Map;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/24 16:33
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
@Valid
public class MedicalDataForm {

    /**
     * 数据传输操作码
     */
    @Min(value = 150, message = "The code must be greater than the protocol minimum")
    @Max(value = 200, message = "The code must be less than the protocol maximum")
    @NotNull(message = "The code cannot be empty")
    private Integer code;

    /**
     * 包含信息的Msg
     */
    @NotNull(message = "The msg cannot be empty")
    private String msg;

    public MedicalDataForm(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
