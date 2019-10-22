package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.eval.cz;

import com.alibaba.fastjson.JSONObject;

import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.eval.cz.entity.RequestCode;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.application.EvalAnesthesiaDepthMonitor;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.application.EvalAnesthesiaMachine;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.application.EvalBrainOxygenMonitor;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.application.EvalApplicationHemoglobinMonitor;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.application.EvalNormalMonitor;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.application.EvalApplicationRespiratorMachine;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.maintenancerecord.EvalMaintenanceRecord;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.servicesystem.EvalServiceSystem;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz.EvalAnesthesiaDepthMonitorService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz.EvalAnesthesiaMachineService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz.EvalBrainOxygenMonitorService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz.EvalHemoglobinMonitorService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz.EvalMaintenanceRecordService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz.EvalNormalMonitorService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz.EvalRespiratorMachineService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz.EvalServiceSystemService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.eval.cz.entity.CommitEntity;
import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.eval.cz.entity.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * 问卷评价控制器
 * @author cz
 */
@RequestMapping("/questionnaire")
@Slf4j
@CrossOrigin
@RestController
public class EvaluationController {

    /**
     * 维修记录服务
     */
    @Autowired
    private EvalMaintenanceRecordService evalMaintenanceRecordService;

    /**
     * 服务体系
     */
    @Autowired
    private EvalServiceSystemService evalServiceSystemService;

    /**
     * 脑氧饱和度临床评价
     */
    @Autowired
    private EvalBrainOxygenMonitorService evalBrainOxygenMonitorService;

    /**
     * 麻醉深度服务
     */
    @Autowired
    private EvalAnesthesiaDepthMonitorService evalAnesthesiaDepthMonitorService;

    /**
     * 麻醉机服务
     */
    @Autowired
    private EvalAnesthesiaMachineService evalAnesthesiaMachineService;

    /**
     * 血红蛋白服务
     */
    @Autowired
    private EvalHemoglobinMonitorService evalHemoglobinMonitorService;

    /**
     * 监护仪服务
     */
    @Autowired
    private EvalNormalMonitorService evalNormalMonitorService;

    /**
     * 呼吸机服务
     */
    @Autowired
    private EvalRespiratorMachineService evalRespiratorMachineService;


    /**
     * 提交评价表接口
     *
     * @param commitEntity 评价表实体
     * @return 是否成功
     */
    @PostMapping(value = "/maintenance_record")
    public ResponseEntity<String> commitMaintenanceRecord(CommitEntity commitEntity) {

        if (commitEntity == null) {
            return ResponseEntity.error("无效请求");
        }

        if (commitEntity.getData() == null) {
            return ResponseEntity.error("无效数据");
        }

        log.info("收到请求:" + commitEntity.toString());

        if(commitEntity.getCode() == RequestCode.MAINTENANCE_RECORD) {
            EvalMaintenanceRecord maintenanceRecord = JSONObject.parseObject(commitEntity.getData(), EvalMaintenanceRecord.class);
            log.info("插入数据:" + maintenanceRecord.toString());
            return evalMaintenanceRecordService.saveMaintenanceRecord(maintenanceRecord);
        } else if (commitEntity.getCode() == RequestCode.SERVICE_SYSTEM) {
            EvalServiceSystem evalServiceSystem = JSONObject.parseObject(commitEntity.getData(), EvalServiceSystem.class);
            log.info("插入数据:" + evalServiceSystem.toString());
            return evalServiceSystemService.saveServiceSystemEvaluation(evalServiceSystem);

        } else if (commitEntity.getCode() == RequestCode.ANESTHESIA_DEPTH_MONITOR) {

            EvalAnesthesiaDepthMonitor evalAnesthesiaDepthMonitor = JSONObject.parseObject(commitEntity.getData(), EvalAnesthesiaDepthMonitor.class);
            log.info("插入数据:" + evalAnesthesiaDepthMonitor.toString());
            return evalAnesthesiaDepthMonitorService.saveAnesthesiaDepthMonitorEvaluation(evalAnesthesiaDepthMonitor);

        } else if (commitEntity.getCode() == RequestCode.HEMOGLOBIN_MONITOR) {

            EvalApplicationHemoglobinMonitor evalApplicationHemoglobinMonitor = JSONObject.parseObject(commitEntity.getData(), EvalApplicationHemoglobinMonitor.class);
            log.info("插入数据:" + evalApplicationHemoglobinMonitor.toString());
            return evalHemoglobinMonitorService.saveHemoglobinMonitorEvaluation(evalApplicationHemoglobinMonitor);

        } else if (commitEntity.getCode() == RequestCode.BRAIN_OXYGEN_MONITOR) {
            EvalBrainOxygenMonitor evalBrainOxygenMonitor = JSONObject.parseObject(commitEntity.getData(), EvalBrainOxygenMonitor.class);
            log.info("插入数据:" + evalBrainOxygenMonitor.toString());
            return evalBrainOxygenMonitorService.saveBrainOxygenMonitorEvaluation(evalBrainOxygenMonitor);

        } else if (commitEntity.getCode() == RequestCode.NORMAL_MONITOR) {

            EvalNormalMonitor evalNormalMonitor = JSONObject.parseObject(commitEntity.getData(), EvalNormalMonitor.class);
            log.info("插入数据:" + evalNormalMonitor.toString());
            return evalNormalMonitorService.saveNormalMonitorEvaluation(evalNormalMonitor);

        } else if (commitEntity.getCode() == RequestCode.ANESTHESIA_MACHINE) {

            EvalAnesthesiaMachine evalAnesthesiaMachine = JSONObject.parseObject(commitEntity.getData(), EvalAnesthesiaMachine.class);
            log.info("插入数据:" + evalAnesthesiaMachine.toString());
            return evalAnesthesiaMachineService.saveAnesthesiaMachineEvaluation(evalAnesthesiaMachine);

        } else if (commitEntity.getCode() == RequestCode.RESPIRATOR_MACHINE) {

            EvalApplicationRespiratorMachine evalApplicationRespiratorMachine = JSONObject.parseObject(commitEntity.getData(), EvalApplicationRespiratorMachine.class);
            log.info("插入数据:" + evalApplicationRespiratorMachine.toString());
            return evalRespiratorMachineService.saveRespiratorMachineEvaluation(evalApplicationRespiratorMachine);
        } else {

            log.error("出错:" + commitEntity.toString());
            return ResponseEntity.error("请求码有误");
        }

    }


}


