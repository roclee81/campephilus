package org.cqu.edu.msc.annihilation.campephilus.utils;

import org.cqu.edu.msc.annihilation.campephilus.module.core.service.CrudService;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;

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
    public static <T> ResultVO listAllResponseEntity(List<T> searchResult) {
        return searchResult.size() != 0 ? ResultVO.success(searchResult) : ResultVO.notFound();
    }

    /**
     * 包装返回类
     *
     * @param searchResult
     * @param <T>
     * @return
     */
    public static ResultVO listResponseEntity(Object searchResult) {
        return null != searchResult ? ResultVO.success(searchResult) : ResultVO.notFound();
    }

    /**
     * 包装返回类
     *
     * @param crudService
     * @param t
     * @param <T>
     * @return
     */
    public static <T> ResultVO saveResponseEntity(CrudService<T> crudService, T t) {
        crudService.save(t);
        return ResultVO.success(t);
    }

    /**
     * 包装返回类
     *
     * @param crudService
     * @param t
     * @param <T>
     * @return
     */
    public static <T> ResultVO updateResponseEntity(CrudService<T> crudService, T t) {
        crudService.update(t);
        return ResultVO.success(t);
    }

    /**
     * 包装返回类
     *
     * @param crudService
     * @param t
     * @param <T>
     * @return
     */
    public static <T> ResultVO deleteResponseEntity(CrudService<T> crudService, T t) {
        crudService.delete(t);
        return ResultVO.success(t);
    }
}
