//package org.cqu.edu.msc.annihilation.campephilus.module.core.dto.info;
//
//import lombok.Data;
//import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.EvaluationInfo;
//import org.cqu.edu.msc.annihilation.common.utils.BeanUtils;
//
//import javax.persistence.Column;
//import java.io.Serializable;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * campephilus
// *
// * @author lx
// * @date 2019/9/17
// * @email vinicolor.violet.end@gmail.com
// * Description:
// */
//@Data
//public class EvaluationInfoDTO implements Serializable {
//
//    private static final long serialVersionUID = -4684055751622655287L;
//
//    /**
//     * 手术顺序号
//     */
//    private Integer operationNumber;
//
//    /**
//     * 仪器代号
//     */
//    private String deviceCode;
//
//    /**
//     * 仪器序列号
//     */
//    private String serialNumber;
//
//    /**
//     * 使用科室
//     */
//    private String deviceDepartment;
//
//    /**
//     * 使用评价等级
//     */
//    private String experienceLevel;
//
//    /**
//     * 可靠性等级
//     */
//    @Column(name = "reliability_level")
//    private String reliabilityLevel;
//
//    /**
//     * 是否有错误信息
//     */
//    private Boolean hasError;
//
//    /**
//     * 错误原因
//     */
//    @Column(name = "known_error")
//    private String knownError;
//
//    /**
//     * 其他错误
//     */
//    private String otherError;
//
//    /**
//     * 备注
//     */
//    private String remark;
//
//    /**
//     * 记录人签名
//     */
//    private String recordName;
//
//    private Long longModified;
//
//    private Long longCreate;
//
//    private EvaluationInfoDTO(){
//
//    }
//
//    public static EvaluationInfoDTO structureEvaluationInfoDTO(EvaluationInfo evaluationInfo) {
//        EvaluationInfoDTO evaluationInfoDTO = new EvaluationInfoDTO();
//        BeanUtils.copyPropertiesTargetNotNull(evaluationInfo, evaluationInfoDTO);
//        evaluationInfoDTO.setLongCreate(evaluationInfo.getLongCreate());
//        evaluationInfoDTO.setLongModified(evaluationInfo.getLongModified());
//        return evaluationInfoDTO;
//    }
//
//    public static List<EvaluationInfoDTO> structureEvaluationInfoDTOs(List<EvaluationInfo> evaluationInfoList) {
//        return evaluationInfoList.parallelStream().map(EvaluationInfoDTO::structureEvaluationInfoDTO)
//                .collect(Collectors.toList());
//    }
//}
