package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/9/10
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@FunctionalInterface
public interface DataListService {
    /**
     * 查询该仪器的所有信息
     *
     * @param page page
     * @param size size
     * @return List DTO对象
     */
    Object list(int page, int size);
}