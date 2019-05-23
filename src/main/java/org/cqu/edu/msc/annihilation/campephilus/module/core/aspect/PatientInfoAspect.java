package org.cqu.edu.msc.annihilation.campephilus.module.core.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.PatientInfo;
import org.springframework.stereotype.Component;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/23 22:37
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Component
@Aspect
public class PatientInfoAspect {

    private final String savePatientInfoFromDataDTOPoint = "execution(public * org.cqu.edu.msc.annihilation.campephilus.module.core.service.PatientInfoService.savePatientInfoFromDataDTO(..))";

    @AfterReturning(value = savePatientInfoFromDataDTOPoint, returning = "returnResult")
    public void savePatientInfoFromDataDTOPoint(PatientInfo returnResult) {
//        log.info(returnResult.toString());
//            streamClient.output().send()
    }
}
