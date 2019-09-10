package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/9/10
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@FunctionalInterface
public interface DataGetNewestOperationNumberAndSerialNumberService {

    /**
     * 得到最新的一条数据
     *
     * @param operationNumber 手术顺序号
     * @param serialNumber    仪器序列号
     * @return DTO对象
     */
    Object getNewestOperationNumberAndSerialNumber(int operationNumber, String serialNumber);
}