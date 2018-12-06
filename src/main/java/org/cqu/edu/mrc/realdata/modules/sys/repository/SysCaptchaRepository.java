package org.cqu.edu.mrc.realdata.modules.sys.repository;


import org.cqu.edu.mrc.realdata.modules.sys.dataobject.SysCaptchaDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Vinicolor
 * @date 2018/10/15
 * <p>
 * Description:
 */
public interface SysCaptchaRepository extends JpaRepository<SysCaptchaDO, String> {

}
