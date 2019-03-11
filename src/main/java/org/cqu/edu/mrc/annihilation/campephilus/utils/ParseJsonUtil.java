package org.cqu.edu.mrc.annihilation.campephilus.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.cqu.edu.mrc.annihilation.campephilus.constant.DataConstants;
import org.cqu.edu.mrc.annihilation.campephilus.dto.ParseDataDTO;
import org.cqu.edu.mrc.annihilation.campephilus.enums.ResponseEnum;
import org.cqu.edu.mrc.annihilation.campephilus.exception.SaveException;

import java.util.Date;
import java.util.Map;

/**
 * @author lx
 * @version V1.0
 * @date 2019/3/10 9:55
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class ParseJsonUtil {

    @SuppressWarnings("unchecked")
    public static <T> T parseJsonString(ParseDataDTO parseDataDTO, Class<T> classOfT) {
        // JSON合并ParseDataDTO中的macAddress，operationNumber，jsonData字段
        Map<String, Object> map;
        try {
            map = new Gson().fromJson(parseDataDTO.getJsonData(), Map.class);
        } catch (JsonSyntaxException exception) {
            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR, exception.toString(), parseDataDTO.toString());
        }

        map.put(DataConstants.OPERATION_NUMBER, parseDataDTO.getOperationNumber());
        map.put(DataConstants.COLLECTOR_MAC_ADDRESS, parseDataDTO.getCollectorMacAddress());
        map.put(DataConstants.GMT_CREATE, new Date());
        map.put(DataConstants.GMT_MODIFIED, new Date());

        String json = new Gson().toJson(map);

        T object;
        try {
            object = new Gson().fromJson(json, classOfT);
        } catch (JsonSyntaxException exception) {
            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR, exception.toString(), json);
        }
        return object;
    }
}
