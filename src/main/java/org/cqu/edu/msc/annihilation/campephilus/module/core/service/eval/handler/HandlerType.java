package org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.handler;

import java.lang.annotation.*;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2019/9/24
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface HandlerType {

    String value();
}
