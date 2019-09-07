package org.cqu.edu.msc.annihilation.campephilus.utils;

import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.BaseInfoSuperclass;
import org.cqu.edu.msc.annihilation.common.utils.TimeStampUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author lx
 * @version V1.0
 * @date 2019/7/26 13:50
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class ConvertUtils {

    public static <T extends BaseInfoSuperclass> List<T> convertObjectTimeStamp(List<T> list) {
        return list.parallelStream()
                .filter(Objects::nonNull)
                .peek(t -> {
                    t.setLongCreate(TimeStampUtils.getTimestampOfDateTime(t.getGmtCreate()));
                    t.setLongModified(TimeStampUtils.getTimestampOfDateTime(t.getGmtModified()));
                })
                .collect(Collectors.toList())
                ;
    }
}
