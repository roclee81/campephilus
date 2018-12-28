package org.cqu.edu.mrc.realdata.modules.app.dataobject;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/19 22:42
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Document(value = "patient_id_operation_number")
@Data
public class PatientIdOperationNumberDO {

    /**
     * Mongo自动生成,唯一
     */
    private String id;

    /**
     * 病人Id
     */
    private String patientId;

    /**
     * 数据创建时间
     */
    private Date gmtCreate;

    /**
     * 数据修改时间
     */
    private Date gmtModified;

    /**
     * 手术顺序号
     */
    private Integer operationNumber;

    public PatientIdOperationNumberDO() {
    }

    public PatientIdOperationNumberDO(String patientId, Date gmtCreate, Integer operationNumber) {
        this.patientId = patientId;
        this.gmtCreate = gmtCreate;
        this.operationNumber = operationNumber;
    }
}
