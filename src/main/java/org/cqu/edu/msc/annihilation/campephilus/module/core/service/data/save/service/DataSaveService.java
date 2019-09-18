package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.save.service;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/9/9
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@FunctionalInterface
public interface DataSaveService {

    /**
     * 数据保存接口
     *
     * @param t 范型数据
     * @return 返回operationNumber
     */
    int save(Object t);
}