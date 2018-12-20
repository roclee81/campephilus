package org.cqu.edu.mrc.realdata.modules.app.dataobject;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/19 22:42
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Document
@Data
public class PatientIdOperationNumberDO {
    
    /**
     * Mongo自动生成,唯一
     */
    private String id;
    /**
     * 病人Id
     */
    private Integer patientId;
    /**
     * 手术顺序号
     */
    private Integer operationNumber;
}
