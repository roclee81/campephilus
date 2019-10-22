package org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz.impl;


import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.maintenancerecord.EvalMaintenanceRecord;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.eval.cz.EvaluationMaintenanceRecordRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz.EvalMaintenanceRecordService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.eval.cz.entity.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 维修记录表服务实现类
 * @author cz
 */
@Service("maintenanceRecordService")
public class EvalMaintenanceRecordServiceImpl implements EvalMaintenanceRecordService {


    @Autowired
    private EvaluationMaintenanceRecordRepository evaluationMaintenanceRecordRepository;


    /**
     * 插入维修记录
     * @param maintenanceRecord 维修记录
     * @return 是否插入成功
     */
    @Override
    public ResponseEntity<String> saveMaintenanceRecord(EvalMaintenanceRecord maintenanceRecord)  {


        EvalMaintenanceRecord maintenanceRecord1 =  evaluationMaintenanceRecordRepository.save(maintenanceRecord);
        if (maintenanceRecord1 != null) {
            return ResponseEntity.success("OK");
        }

        return ResponseEntity.error("Error");
    }

}
