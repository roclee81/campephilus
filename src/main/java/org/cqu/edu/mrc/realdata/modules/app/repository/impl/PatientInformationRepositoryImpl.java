package org.cqu.edu.mrc.realdata.modules.app.repository.impl;

import org.cqu.edu.mrc.realdata.common.constant.DataConstants;
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
    public PatientInformationDO findPatientInformationDOByOperationNumber(Integer operationNumber) {
        Query query = Query.query(new Criteria(DataConstants.OPERATION_NUMBER).is(operationNumber));
        List<PatientInformationDO> patientInformationDOList = mongoOperations.find(query, PatientInformationDO.class);
        return patientInformationDOList.size() == 1 ? patientInformationDOList.get(0) : null;
    }

    @Override
    public PatientInformationDO findPatientInformationDOByPatientIdAndOperationNumber(String patientId, Integer operationNumber) {
        Query query = Query.query(new Criteria(DataConstants.OPERATION_NUMBER).is(operationNumber).and(DataConstants.PATIENT_ID).is(patientId));
        List<PatientInformationDO> patientInformationDOList = mongoOperations.find(query, PatientInformationDO.class);
        return patientInformationDOList.size() == 1 ? patientInformationDOList.get(0) : null;
    }

    @Override
    public Page<PatientInformationDO> findPatientInformationDOSByPatientId(String patientId, Pageable pageable) {
        Query query = Query.query(new Criteria(DataConstants.PATIENT_ID).is(patientId));
        query.with(pageable);
        return getPatientInformationDOS(query, pageable);
    }

    @Override
    public void savePatientInformationDO(PatientInformationDO patientInformationDO) {
        mongoOperations.save(patientInformationDO);
    }

    private Page<PatientInformationDO> getPatientInformationDOS(Query query, Pageable pageable) {
        // 查询总数
        int count = (int) mongoOperations.count(query, PatientInformationDO.class);
        List<PatientInformationDO> patientInformationDOList = mongoOperations.find(query, PatientInformationDO.class);
        return PageableExecutionUtils.getPage(patientInformationDOList, pageable, () -> count);
    }
}
