package org.cqu.edu.msc.annihilation.campephilus.module.statistical.vo;

import lombok.Data;
import org.aspectj.lang.JoinPoint;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/3 22:19
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
public class MessageVO {

    private Boolean result;

    private JoinPoint joinPoint;

    public MessageVO(Boolean result, JoinPoint joinPoint) {
        this.result = result;
        this.joinPoint = joinPoint;
    }
}
