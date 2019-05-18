package org.cqu.edu.msc.annihilation.campephilus.module.core.utils;

import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/18 14:23
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class ControllerListUtils {

    /**
     * 包装返回类
     *
     * @param searchResult
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<ResultVO> getResultVOResponseEntity(List<T> searchResult) {
        if (searchResult.size() != 0) {
            return new ResponseEntity<>(ResultVO.success(searchResult), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ResultVO.dataNotExist(), HttpStatus.NOT_FOUND);
        }
    }
}