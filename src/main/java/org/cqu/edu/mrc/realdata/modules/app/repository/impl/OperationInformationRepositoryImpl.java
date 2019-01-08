package org.cqu.edu.mrc.realdata.modules.app.repository.impl;

import org.cqu.edu.mrc.realdata.common.constant.DataConstants;
import org.cqu.edu.mrc.realdata.modules.app.dataobject.OperationInformationDO;
import org.cqu.edu.mrc.realdata.modules.app.repository.OperationInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
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
public class OperationInformationRepositoryImpl implements OperationInformationRepository {

    private final MongoOperations mongoOperations;

    @Autowired
    public OperationInformationRepositoryImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public Page<OperationInformationDO> findOperationInformationDOSByPatientId(String patientId, Pageable pageable) {
        Query query = Query.query(Criteria.where(DataConstants.PATIENT_ID).is(patientId));
        return queryPageable(query, pageable);
    }

    @Override
    public OperationInformationDO findOperationInformationDOByOperationNumber(Integer operationNumber) {
        Query query = Query.query(Criteria.where(DataConstants.OPERATION_NUMBER).is(operationNumber));
        List<OperationInformationDO> operationInformationDOList = mongoOperations.find(query, OperationInformationDO.class);
        return operationInformationDOList.size() == 1 ? operationInformationDOList.get(0) : null;
    }

    @Override
    public Page<OperationInformationDO> findOperationInformationDOSByOperationHospitalCode(String operationHospitalCode, Pageable pageable) {
        Query query = Query.query(Criteria.where(DataConstants.OPERATION_HOSPITAL_CODE).is(operationHospitalCode));
        return queryPageable(query, pageable);
    }

    @Override
    public Page<OperationInformationDO> findOperationInformationDOSByOperationStartTimeBetween(Date operationStartTimeBefore, Date operationStartTimeAfter, Pageable pageable) {
        Query query = Query.query(Criteria.where(DataConstants.OPERATION_START_TIME).gt(operationStartTimeBefore).lt(operationStartTimeAfter));
        return queryPageable(query, pageable);
    }

    @Override
    public Page<OperationInformationDO> findOperationInformationDOSByOperationTimeBetween(Long operationTimeBefore, Long operationTimeAfter, Pageable pageable) {
        Query query = Query.query(Criteria.where(DataConstants.OPERATION_TIME).gt(operationTimeBefore).lt(operationTimeAfter));
        return queryPageable(query, pageable);
    }

    @Override
    public void saveOperationInformationDO(OperationInformationDO operationInformationDO) {
        mongoOperations.save(operationInformationDO);
    }

    @Override
    public Page<OperationInformationDO> findOperationInformationDOS(Pageable pageable) {
        Query query = Query.query(Criteria.where(""));
        return queryPageable(query, pageable);
    }

    @Override
    public Integer countOperationInformationDOS() {
        Query query = Query.query(Criteria.where(""));
        return (int) mongoOperations.count(query, OperationInformationDO.class);
    }

    private Page<OperationInformationDO> queryPageable(Query query, Pageable pageable) {
        query.with(pageable);
        // 查询总数
        int count = (int) mongoOperations.count(query, OperationInformationDO.class);
        List<OperationInformationDO> nodeSensorDOList = mongoOperations.find(query, OperationInformationDO.class);
        return PageableExecutionUtils.getPage(nodeSensorDOList, pageable, () -> count);
    }
}
