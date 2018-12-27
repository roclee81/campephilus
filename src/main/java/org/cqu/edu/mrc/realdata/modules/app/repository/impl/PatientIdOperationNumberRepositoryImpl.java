package org.cqu.edu.mrc.realdata.modules.app.repository.impl;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.PatientIdOperationNumberDO;
import org.cqu.edu.mrc.realdata.modules.app.repository.PatientIdOperationNumberRepository;
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
 * @date 2018/12/27 15:41
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Component
public class PatientIdOperationNumberRepositoryImpl implements PatientIdOperationNumberRepository {

    private final MongoOperations mongoOperations;

    @Autowired
    public PatientIdOperationNumberRepositoryImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public Page<PatientIdOperationNumberDO> findPatientIdOperationNumberDOSByPatientId(Integer patientId, Pageable pageable) {
        Query query = Query.query(Criteria.where("patientId").is(patientId));
        return queryPageable(query, pageable);
    }

    @Override
    public Page<PatientIdOperationNumberDO> findPatientIdOperationNumberDOByOperationNumber(Integer operationNumber, Pageable pageable) {
        Query query = Query.query(Criteria.where("operationNumber").is(operationNumber));
        return queryPageable(query, pageable);
    }

    private Page<PatientIdOperationNumberDO> queryPageable(Query query, Pageable pageable) {
        query.with(pageable);
        // 查询总数
        int count = (int) mongoOperations.count(query, PatientIdOperationNumberDO.class);
        List<PatientIdOperationNumberDO> nodeSensorDOList = mongoOperations.find(query, PatientIdOperationNumberDO.class);
        return PageableExecutionUtils.getPage(nodeSensorDOList, pageable, () -> count);

    }

    @Override
    public void savePatientIdOperationNumberDO(PatientIdOperationNumberDO patientIdOperationNumberDO) {
        mongoOperations.save(patientIdOperationNumberDO);
    }


    @Override
    public Integer countAll() {
        Query query = Query.query(Criteria.where(""));
        return (int) mongoOperations.count(query, PatientIdOperationNumberDO.class);
    }
}
