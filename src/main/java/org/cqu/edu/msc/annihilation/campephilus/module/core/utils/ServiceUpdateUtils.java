package org.cqu.edu.msc.annihilation.campephilus.module.core.utils;

import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.ResponseEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.SaveException;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/17 15:52
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class ServiceUpdateUtils {

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

}
