package org.cqu.edu.msc.annihilation.campephilus.module.message.utils;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.*;
import org.cqu.edu.msc.annihilation.campephilus.module.message.protobuf.pojo.MessageProtocolBuffers;
import org.springframework.beans.BeanUtils;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/26 20:03
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class ProtoConvertUtils {

    public static byte[] convert(AfterOperationInfo source) {
        MessageProtocolBuffers.AfterOperationInfo.Builder target = MessageProtocolBuffers.AfterOperationInfo.newBuilder();
        BeanUtils.copyProperties(source, target);
        return target.build().toByteArray();
    }

    public static byte[] convert(BeforeOperationInfo source) {
        MessageProtocolBuffers.BeforeOperationInfo.Builder target = MessageProtocolBuffers.BeforeOperationInfo.newBuilder();
        BeanUtils.copyProperties(source, target);
        return target.build().toByteArray();
    }

    public static byte[] convert(OperationInfo source) {
        MessageProtocolBuffers.OperationInfo.Builder target = MessageProtocolBuffers.OperationInfo.newBuilder();
        BeanUtils.copyProperties(source, target);
        return target.build().toByteArray();
    }

    public static byte[] convert(OperationMarkInfo source) {
        MessageProtocolBuffers.OperationMarkInfo.Builder target = MessageProtocolBuffers.OperationMarkInfo.newBuilder();
        BeanUtils.copyProperties(source, target);
        return target.build().toByteArray();
    }

    public static byte[] convert(PatientInfo source) {
        MessageProtocolBuffers.PatientInfo.Builder target = MessageProtocolBuffers.PatientInfo.newBuilder();
        BeanUtils.copyProperties(source, target);
        return target.build().toByteArray();
    }
}
