package org.cqu.edu.mrc.realdata.common.validator;

import org.apache.commons.lang.StringUtils;
import org.cqu.edu.mrc.realdata.common.exception.OAuthException;

/**
 * @author Vinicolor
 * @date 2018/10/18 9:55
 * <p>
 * Description:
 * 数据校验
 */
public abstract class AbstractAssert {

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new OAuthException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new OAuthException(message);
        }
    }

}
