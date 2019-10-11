package org.cqu.edu.msc.annihilation.campephilus.utils;

import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.CrudException;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.ValidationException;
import java.util.Objects;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/31 16:07
 * @email vinicolor.violet.end@gmail.com
 * Description:
 * 提供Service层的CRUD操作的检查工具类
 * 将会检查CRUD操作是否成功，如果失败将抛出对应的异常
 */
public class ServiceCrudCheckUtils {

    /**
     * 保存数据库对象
     * 保存失败将抛出<code>CrudException</code>异常
     *
     * @param jpaRepository 待保存的对象仓库t
     * @param t             待保存的对象
     */
    public static <T, ID> T saveObjectAndCheckSuccess(JpaRepository<T, ID> jpaRepository, T t) {
        T result = null;
        try {
            result = jpaRepository.save(t);
        } catch (ValidationException e) {
            // 获取到校验错误，即数据字段可能为空，或错误
            CrudException.saveDataFormatException(e, t);
        } catch (Exception e) {
            CrudException.saveUnknownException(e, t);
        }
        CheckUtils.checkSaveSuccess(result, t);
        return result;
    }

    /**
     * 更新数据库对象
     * 更新失败将抛出<code>CrudException</code>异常
     *
     * @param jpaRepository 待保存的对象仓库
     * @param id            数据字段主键
     * @param t             待保存的对象
     */
    public static <T, ID> T updateObjectAndCheckSuccess(JpaRepository<T, ID> jpaRepository, ID id, T t) {
        // 检查是否ID是否为null，同时查询数据库中是否有该数据
        if (Objects.isNull(id) || jpaRepository.findById(id).isEmpty()) {
            CrudException.updateIdException();
        }
        T result = null;
        try {
            result = jpaRepository.save(t);
        } catch (Exception e) {
            CrudException.updateUnknownException(e, t);
        }
        CheckUtils.checkSaveSuccess(result, t);
        return result;
    }

    @SuppressWarnings("unchecked")
    public static void deleteObjectAndCheckSuccess(JpaRepository jpaRepository, Object id, Object object) {
        // 首先需要查询数据是否存在
        CheckUtils.checkDataIsNotExisted(jpaRepository.findById(id).orElse(null));
        try {
            jpaRepository.delete(id);
        } catch (Exception e) {
            CrudException.deleteUnknownException(e, object);
        }
    }

    @SuppressWarnings("unchecked")
    public static boolean deleteObjectAndCheckSuccess(JpaRepository jpaRepository, Object id) {
        // 首先需要查询数据是否存在
        try {
            CheckUtils.checkDataIsNotExisted(jpaRepository.findById(id).orElse(null));
        } catch (Exception e) {
            return false;
        }
        try {
            jpaRepository.deleteById(id);
        } catch (Exception e) {
            CrudException.deleteUnknownException(e, id);
        }
        return true;
    }
}
