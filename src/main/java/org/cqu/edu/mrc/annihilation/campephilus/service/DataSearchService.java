package org.cqu.edu.mrc.annihilation.campephilus.service;

import org.cqu.edu.mrc.annihilation.campephilus.dto.*;
import org.cqu.edu.mrc.annihilation.campephilus.dto.CurrentStatisticsRequestDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/28 20:12
 * @email vinicolor.violet.end@gmail.com
 * Description:
 * 数据搜索服务
 * 处理所有数据查询的请求
 */
public interface DataSearchService {
    /**
     * 通过operationNumber、deviceId得到DeviceDTO
     * 不提供通过operationNumber查询该手术中用到的所有设备信息
     * 因为无法通过传入Pageable实现分页，如果通过operationNumber查询
     * 将会使执行时间非常长
     *
     * @param operationNumber 手术顺序号
     * @param deviceId        设备ID
     * @param pageable        分页信息
     * @return DeviceDTO列表，如果没有查询到内容，将会返回一个空的ArrayList，
     * 如果只有一个数据，也将加入到列表中
     */
    List<DeviceDTO> listDeviceData(int operationNumber, String deviceId, Pageable pageable);

    /**
     * 通过operationNumber、patientId得到PatientInformationDTO
     * 目前不支持传入collectorMacAddress来查询
     *
     * @param operationNumber 手术顺序号
     * @param patientId       病人ID
     * @param pageable        分页信息
     * @return PatientInformationDTO列表，如果没有查询到内容，将会返回一个空的ArrayList，
     * 如果只有一个数据，也将加入到列表中
     */
    List<PatientInformationDTO> listPatientData(int operationNumber, String patientId, Pageable pageable);

    /**
     * 通过operationNumber、collectorMacAddress得到OperationInformationDTO
     * 目前不支持传入collectorMacAddress来查询
     *
     * @param operationNumber     手术顺序号
     * @param collectorMacAddress 采集器MAC地址
     * @param pageable            分页信息
     * @return OperationInformationDTO列表，如果没有查询到内容，将会返回一个空的ArrayList，
     * 如果只有一个数据，也将加入到列表中
     */
    List<OperationInformationDTO> listOperationData(int operationNumber, String collectorMacAddress, Pageable pageable);

    /**
     * 按照Pageable得到CollectorInformationDTO
     *
     * @param pageable 分页信息
     * @return CollectorInformationDTO
     */
    CollectorInformationDTO listCollectorData(Pageable pageable);

    /**
     * 按照Pageable得到FeedbackInformationDTO
     *
     * @param pageable 分页信息
     * @return FeedbackInformationDTO
     */
    List<FeedbackInformationDTO> listFeedbackData(Pageable pageable);

    /**
     * 得到最新的版本信息
     *
     * @return VersionInformationDTO
     */
    VersionInformationDTO getVersionData();

    /**
     * 得到当天的统计信息
     *
     * @return 当天的统计信息，如果没有，则返回null
     */
    StatisticalRequestDTO listStatisticalData();

    /**
     * 得到当前的统计请求的信息
     * 如果发现没有CurrentStatisticsRequestDTO信息，将创建
     * @return 返回当前保存的CurrentStatisticsRequestDTO信息
     */
    CurrentStatisticsRequestDTO getCurrentStatisticsRequestDTO();
}
