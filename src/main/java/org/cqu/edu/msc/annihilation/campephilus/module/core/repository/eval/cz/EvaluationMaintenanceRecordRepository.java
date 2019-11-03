package org.cqu.edu.msc.annihilation.campephilus.module.core.repository.eval.cz;


import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.maintenancerecord.EvalMaintenanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 维修记录表DAO层
 * @author cz
 */
public interface EvaluationMaintenanceRecordRepository extends JpaRepository<EvalMaintenanceRecord, Integer> {
}
