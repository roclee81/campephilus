package org.cqu.edu.msc.annihilation.campephilus.module.core.repository.eval.cz;


import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.application.EvalApplicationRespiratorMachine;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 呼吸机DAO层
 * @author cz
 */
public interface EvaluationRespiratorMachineRepository extends JpaRepository<EvalApplicationRespiratorMachine, Integer> {
}
