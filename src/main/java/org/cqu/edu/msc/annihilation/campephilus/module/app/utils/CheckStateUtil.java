package org.cqu.edu.msc.annihilation.campephilus.module.app.utils;

import org.cqu.edu.msc.annihilation.campephilus.module.app.enums.ResponseEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.app.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.app.service.OperationInformationService;

/**
 * @author lx
 * @version V1.0
 * @date 2019/3/10 15:11
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class CheckStateUtil {
    /**
     * 检查该手术进行了没有
     * 同时如果该对象存在，即查询后有结果，则抛出异常
     * 如果该手术不存在或手术状态处于结束，则抛出异常
     *
     * @param result                      查询结果
     * @param operationInformationService 查询对象
     * @param operationNumber             手术顺序号
     */
    public static void checkState(Object result, OperationInformationService operationInformationService, Integer operationNumber) {
        if (null != result) {
            throw new SaveException(ResponseEnum.DATA_EXISTED);
        }

        if (!operationInformationService.checkOperationState(operationNumber)) {
            throw new SaveException(ResponseEnum.OPERATION_NOT_READY);
        }
    }
}
