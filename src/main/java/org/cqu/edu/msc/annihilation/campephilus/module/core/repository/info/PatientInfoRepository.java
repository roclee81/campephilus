package org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.PatientInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/18 21:25
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Repository
public interface PatientInfoRepository extends JpaRepository<PatientInfo, Integer> {

    PatientInfo findByAdmissionNumber(String admissionNumber);

    PatientInfo deleteByAdmissionNumber(String admissionNumber);

}
