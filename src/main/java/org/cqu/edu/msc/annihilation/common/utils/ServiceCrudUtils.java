package org.cqu.edu.msc.annihilation.common.utils;

import org.cqu.edu.msc.annihilation.common.enums.ResponseEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.SaveException;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.ValidationException;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/31 16:07
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class ServiceCrudUtils {

    /**
     * 保存数据库对象
     * 保存失败将抛出<code>SaveException</code>异常
     *
     * @param jpaRepository 待保存的对象仓库
     * @param object        待保存的对象
     */
    public static void saveObjectAndCheckSuccess(JpaRepository jpaRepository, Object object) {
        Object result;
        try {
            result = jpaRepository.save(object);
        } catch (ValidationException e) {
            // 获取到校验错误，即数据字段可能为空，或错误
            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR, e.toString(), object.toString());
        } catch (Exception e) {
            throw new SaveException(ResponseEnum.UNKNOWN_ERROR, e.toString(), object.toString());
        }
        SaveException.checkSaveSuccess(result, object);
    }

    /**
     * 更新数据库对象
     * 更新失败将抛出<code>SaveException</code>异常
     *
     * @param jpaRepository 待保存的对象仓库
     * @param id            数据字段主键
     * @param object        待保存的对象
     */
    @SuppressWarnings("unchecked")
    public static void updateObjectAndCheckSuccess(JpaRepository jpaRepository, Object id, Object object) {
        if (null == id || jpaRepository.findById(id).isEmpty()) {
            throw new SaveException(ResponseEnum.UPDATE_ID_ERROR);
        }
        Object result;
        try {
            result = jpaRepository.save(object);
        } catch (Exception e) {
            throw new SaveException(ResponseEnum.UNKNOWN_ERROR, e.toString(), object.toString());
        }

        SaveException.checkSaveSuccess(result, object);
    }

    @SuppressWarnings("unchecked")
    public static void deleteObjectAndCheckSuccess(JpaRepository jpaRepository, Object id, Object object) {
        // 首先需要查询数据是否存在
        SaveException.checkDataIsNotExist(jpaRepository.findById(id));
        try {
            jpaRepository.delete(id);
        } catch (Exception e) {
            throw new SaveException(ResponseEnum.UNKNOWN_ERROR, e.toString(), object.toString());
        }
    }
}
