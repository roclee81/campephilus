package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/9/10
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@FunctionalInterface
public interface DataListByOperationNumberAndSerialNumberService {

    /**
     * 通过operationNumber和serialNumber查询指定手术的仪器输出数据
     *
     * @param page            page
     * @param size            size
     * @param operationNumber 手术顺序号
     * @param serialNumber    仪器序列号
     * @return List DTO对象
     */
    Object listByOperationNumberAndSerialNumber(
            int page, int size, int operationNumber, String serialNumber);
}