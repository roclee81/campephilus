package org.cqu.edu.mrc.realdata.modules.app.dataobject;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;
import java.util.Map;


/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/11 17:17
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
public class PatientDO {

    /**
     * 自动生成的唯一ID
     */
    @Id
    private String id;

    /**
     * 病人的唯一ID
     */
    private String patientId;

    /**
     * 上传的数据采集设备的MAC地址
     */
    private String macAddress;

    /**
     * 手术唯一标识码
     */
    private String opn;

    /**
     * 数据上传的数据
     */
    private Date createTime;

    /**
     * 数据修改的时间
     */
    private Date updateTime;

    /**
     * 手术状态信息：手术进行阶段、医院代码、手术状态、手术类型
     */
    private Map msg;

    /**
     * 病人基础数据
     */
    private Map patientData;
}
