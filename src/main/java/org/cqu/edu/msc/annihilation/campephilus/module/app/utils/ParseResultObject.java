package org.cqu.edu.msc.annihilation.campephilus.module.app.utils;

import lombok.Data;

/**
 * @author lx
 * @version V1.0
 * @date 2019/3/11 16:19
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
public class ParseResultObject {
    /**
     * 解析后的结果
     * 不能为空
     * true解析成功
     * false解析失败
     */
    private boolean returnResult;

    /**
     * 解析后返回的消息体，可以为空
     * 如果没有消息将返回null
     */
    private Object returnData;
}
