package org.cqu.edu.msc.annihilation.campephilus.module.core.repository.data;

import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.data.BaoLaiTe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * campephilus
 *
 * @author lx
 * @date 2019/11/18
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Repository
public interface BaoLaiTeRepository extends JpaRepository<BaoLaiTe, Integer> {
}
