package org.cqu.edu.msc.annihilation.campephilus.module.core.repository.eval;

import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.EvalAnesthesiaMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * campephilus
 *
 * @author lx
 * @date 2019/9/30
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Repository
public interface EvalAnesthesiaMachineRepository extends JpaRepository<EvalAnesthesiaMachine, Integer> {

}
