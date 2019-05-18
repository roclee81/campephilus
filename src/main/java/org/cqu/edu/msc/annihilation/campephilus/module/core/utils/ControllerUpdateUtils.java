package org.cqu.edu.msc.annihilation.campephilus.module.core.utils;

import org.cqu.edu.msc.annihilation.campephilus.module.core.service.CRUDService;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/18 21:14
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class ControllerUpdateUtils {
    /**
     * 包装返回类
     *
     * @param CRUDService
     * @param t
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<ResultVO> updateResultVOResponseEntity(CRUDService<T> CRUDService, T t) {
        CRUDService.update(t);
        return new ResponseEntity<>(ResultVO.success(t), HttpStatus.OK);
    }
}
