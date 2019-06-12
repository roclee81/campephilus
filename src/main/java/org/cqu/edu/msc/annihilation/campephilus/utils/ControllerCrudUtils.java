package org.cqu.edu.msc.annihilation.campephilus.utils;

import org.cqu.edu.msc.annihilation.campephilus.module.core.service.CrudService;
import org.cqu.edu.msc.annihilation.common.utils.ResultVOUtils;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/1 0:51
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class ControllerCrudUtils {

    /**
     * 包装返回类
     *
     * @param searchResult
     * @param <T>
     * @return
     */
    public static <T> ResultVOUtils listAllResponseEntity(List<T> searchResult) {
        return searchResult.size() != 0 ? ResultVOUtils.success(searchResult) : ResultVOUtils.notFound();
    }

    /**
     * 包装返回类
     *
     * @param searchResult
     * @param <T>
     * @return
     */
    public static ResultVOUtils listResponseEntity(Object searchResult) {
        return null != searchResult ? ResultVOUtils.success(searchResult) : ResultVOUtils.notFound();
    }

    /**
     * 包装返回类
     *
     * @param crudService
     * @param t
     * @param <T>
     * @return
     */
    public static <T> ResultVOUtils saveResponseEntity(CrudService<T> crudService, T t) {
        crudService.save(t);
        return ResultVOUtils.success(t);
    }

    /**
     * 包装返回类
     *
     * @param crudService
     * @param t
     * @param <T>
     * @return
     */
    public static <T> ResultVOUtils updateResponseEntity(CrudService<T> crudService, T t) {
        crudService.update(t);
        return ResultVOUtils.success(t);
    }

    /**
     * 包装返回类
     *
     * @param crudService
     * @param t
     * @param <T>
     * @return
     */
    public static <T> ResultVOUtils deleteResponseEntity(CrudService<T> crudService, T t) {
        crudService.delete(t);
        return ResultVOUtils.success(t);
    }
}