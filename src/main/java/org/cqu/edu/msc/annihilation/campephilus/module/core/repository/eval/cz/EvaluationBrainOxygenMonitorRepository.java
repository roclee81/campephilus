package org.cqu.edu.msc.annihilation.campephilus.module.core.repository.eval.cz;


import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.application.EvalBrainOxygenMonitor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 脑氧饱和度监护仪DAO
 * @author cz
 */
public interface EvaluationBrainOxygenMonitorRepository extends JpaRepository<EvalBrainOxygenMonitor, Integer> {
}
