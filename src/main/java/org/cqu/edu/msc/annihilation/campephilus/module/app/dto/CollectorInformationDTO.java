package org.cqu.edu.msc.annihilation.campephilus.module.app.dto;

import lombok.Data;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.CollectorInformationDO;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/21 20:45
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
public class CollectorInformationDTO {

    /**
     * 采集器总数据量
     */
    private Integer collectorTotalNumber;

    /**
     * 离线采集器数量
     */
    private Integer offlineCollectorNumber;

    /**
     * 正在运行的采集器数量
     */
    private Integer runningCollectorNumber;

    /**
     * 采集器信息的集合
     */
    private List<CollectorInformationDO> collectorInformationDOList;
}
