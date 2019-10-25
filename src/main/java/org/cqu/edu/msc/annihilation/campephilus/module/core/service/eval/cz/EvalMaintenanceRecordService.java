package org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz;


import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.maintenancerecord.EvalMaintenanceRecord;
import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.eval.cz.entity.ResponseEntity;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;

/**
 * 维修记录表服务接口
 * @author cz
 */
public interface EvalMaintenanceRecordService {

    /**
     * 插入维修记录
     * @param maintenanceRecord 维修记录
     * @return 插入是否成功
     */
    ResultVO saveMaintenanceRecord(EvalMaintenanceRecord maintenanceRecord);


}
