package org.cqu.edu.msc.annihilation.campephilus.module.core.utils;

import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.ResponseEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.SaveException;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.ValidationException;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/17 15:31
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class ServiceSaveUtils {

    /**
     * 保存数据库对象
     * 保存成功将返回空
     * 保存是被将抛出<code>SaveException</code>异常
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

}
