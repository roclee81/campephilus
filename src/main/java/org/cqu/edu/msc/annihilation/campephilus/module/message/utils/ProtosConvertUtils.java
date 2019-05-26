package org.cqu.edu.msc.annihilation.campephilus.module.message.utils;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.*;
import org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.*;
import org.cqu.edu.msc.annihilation.common.utils.DateUtils;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/26 20:03
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class ProtosConvertUtils {

    public static AfterOperationInfoProtos.AfterOperationInfo convert(AfterOperationInfo afterOperationInfo) {
        return AfterOperationInfoProtos.AfterOperationInfo.newBuilder()
                .setAfterOperationId(afterOperationInfo.getAfterOperationId())
                .setAdmissionNumber(afterOperationInfo.getAdmissionNumber())
                .setFeedbackContent(afterOperationInfo.getFeedbackContent())
                .build();
    }

    public static BeforeOperationInfoProtos.BeforeOperationInfo convert(BeforeOperationInfo beforeOperationInfo) {
        return BeforeOperationInfoProtos.BeforeOperationInfo.newBuilder()
                .setAdmissionNumber(beforeOperationInfo.getAdmissionNumber())
                .setAnesthesiaMode(beforeOperationInfo.getAnesthesiaMode())
                .setASALevel(beforeOperationInfo.getASALevel())
                .setBeforeOperationId(beforeOperationInfo.getBeforeOperationId())
                .setIsStrong(beforeOperationInfo.getIsStrong())
                .setIsUrgent(beforeOperationInfo.getIsUrgent())
                .setMedicalHistory(beforeOperationInfo.getMedicalHistory())
                .setSpecialCase(beforeOperationInfo.getSpecialCase())
                .build();
    }

    public static OperationInfoProtos.OperationInfo convert(OperationInfo operationInfo) {
        return OperationInfoProtos.OperationInfo.newBuilder()
                .setOperationDevice(operationInfo.getOperationDevice())
                .setOperationEndTime(DateUtils.convertLong(operationInfo.getOperationEndTime()))
                .setOperationNumber(operationInfo.getOperationNumber())
                .setOperationStartTime(DateUtils.convertLong(operationInfo.getOperationStartTime()))
                .setOperationName(operationInfo.getOperationName())
                .setOperationState(operationInfo.getOperationState())
                .build();
    }

    public static OperationMarkInfoProtos.OperationMarkInfo convert(OperationMarkInfo operationMarkInfo) {
        return OperationMarkInfoProtos.OperationMarkInfo.newBuilder()
                .setDose(operationMarkInfo.getDose())
                .setEvent(operationMarkInfo.getEvent())
                .setEventType(operationMarkInfo.getEventType())
                .setMarkId(operationMarkInfo.getMarkId())
                .setMarkTime(DateUtils.convertLong(operationMarkInfo.getMarkTime()))
                .setMarkType(operationMarkInfo.getMarkType())
                .setOperationId(operationMarkInfo.getOperationId())
                .setWay(operationMarkInfo.getWay())
                .setSpecialSituation(operationMarkInfo.getSpecialSituation())
                .build();
    }

    public static PatientInfoProtos.PatientInfo convert(PatientInfo patientInfo) {
        return PatientInfoProtos.PatientInfo.newBuilder()
                .setAdmissionNumber(patientInfo.getAdmissionNumber())
                .setAge(patientInfo.getAge())
                .setHeight(patientInfo.getHeight())
                .setWeight(patientInfo.getWeight())
                .setId(patientInfo.getId())
                .setPatientId(patientInfo.getPatientId())
                .setOperationNumber(patientInfo.getOperationNumber())
                .setSex(patientInfo.getSex())
                .build();
    }
}
