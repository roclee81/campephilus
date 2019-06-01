package org.cqu.edu.msc.annihilation.campephilus.common.utils;

import org.cqu.edu.msc.annihilation.campephilus.module.core.service.CrudService;
import org.springframework.http.ResponseEntity;

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
    public static <T> ResponseEntity listAllResponseEntity(List<T> searchResult) {
        return searchResult.size() != 0 ? ResultUtils.success(searchResult) : ResultUtils.notFound();
    }

    /**
     * 包装返回类
     *
     * @param crudService
     * @param t
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity saveResponseEntity(CrudService<T> crudService, T t) {
        crudService.save(t);
        return ResultUtils.success(t);
    }

    /**
     * 包装返回类
     *
     * @param crudService
     * @param t
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity updateResponseEntity(CrudService<T> crudService, T t) {
        crudService.update(t);
        return ResultUtils.success(t);
    }

    /**
     * 包装返回类
     *
     * @param crudService
     * @param t
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity deleteResponseEntity(CrudService<T> crudService, T t) {
        crudService.delete(t);
        return ResultUtils.success(t);
    }
}
