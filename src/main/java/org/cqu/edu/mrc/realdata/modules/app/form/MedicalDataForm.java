package org.cqu.edu.mrc.realdata.modules.app.form;

import lombok.Data;
import org.cqu.edu.mrc.realdata.common.validator.group.AddGroup;
import org.cqu.edu.mrc.realdata.common.validator.group.UpdateGroup;

import javax.validation.constraints.NotBlank;
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
public class MedicalDataForm {

    /**
     * 数据传输操作码
     */
    private Integer code;

    /**
     * 包含信息的Msg
     */
    private Map msg;

    public MedicalDataForm(Integer code, Map msg) {
        this.code = code;
        this.msg = msg;
    }
}
