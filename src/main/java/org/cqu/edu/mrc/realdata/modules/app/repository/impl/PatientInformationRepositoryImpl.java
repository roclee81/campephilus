package org.cqu.edu.mrc.realdata.modules.app.repository.impl;

import org.cqu.edu.mrc.realdata.common.constant.DataConstants;
import org.cqu.edu.mrc.realdata.modules.app.dataobject.DeviceDO;
import org.cqu.edu.mrc.realdata.modules.app.dataobject.PatientInformationDO;
import org.cqu.edu.mrc.realdata.modules.app.repository.PatientInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/8 22:34
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Component
public class PatientInformationRepositoryImpl implements PatientInformationRepository {

    private final MongoOperations mongoOperations;

    @Autowired
    public PatientInformationRepositoryImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public PatientInformationDO findPatientInformationDOSByPatientIdAndOperationNumber(String patientId, Integer operationNumber, Pageable pageable) {
        Query query = Query.query(new Criteria(DataConstants.PATIENT_ID).is(patientId));
        return null;
    }

    @Override
    public Page<PatientInformationDO> findPatientInformationDOSByPatientId(String patientId, Pageable pageable) {
        Query query = Query.query(new Criteria(DataConstants.PATIENT_ID).is(patientId));
        query.with(pageable);
        return getPatientInformationDOS(query, patientId, pageable);
    }

    @Override
    public void savePatientInformationDO(PatientInformationDO patientInformationDO) {
        mongoOperations.save(patientInformationDO);
    }

    private Page<PatientInformationDO> getPatientInformationDOS(Query query, String patientId, Pageable pageable) {
        // 查询总数
        int count = (int) mongoOperations.count(query, PatientInformationDO.class, patientId);
        List<PatientInformationDO> patientInformationDOList = mongoOperations.find(query, PatientInformationDO.class, patientId);
        return PageableExecutionUtils.getPage(patientInformationDOList, pageable, () -> count);
    }
}
