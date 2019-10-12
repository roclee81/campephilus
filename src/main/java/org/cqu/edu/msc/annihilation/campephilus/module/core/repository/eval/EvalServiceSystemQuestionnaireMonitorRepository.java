package org.cqu.edu.msc.annihilation.campephilus.module.core.repository.eval;

import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.EvalServiceSystemQuestionnaireMonitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/10/11
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Repository
public interface EvalServiceSystemQuestionnaireMonitorRepository extends JpaRepository<EvalServiceSystemQuestionnaireMonitor, Integer> {
}