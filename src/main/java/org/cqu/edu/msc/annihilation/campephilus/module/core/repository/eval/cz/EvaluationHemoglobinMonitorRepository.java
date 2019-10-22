package org.cqu.edu.msc.annihilation.campephilus.module.core.repository.eval.cz;


import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.application.EvalApplicationHemoglobinMonitor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 血红蛋白监测仪DAO
 * @author cz
 */
public interface EvaluationHemoglobinMonitorRepository extends JpaRepository<EvalApplicationHemoglobinMonitor, Integer> {
}
