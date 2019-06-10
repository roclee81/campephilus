package org.cqu.edu.msc.annihilation.campephilus.module.instrument.parse;

import org.cqu.edu.msc.annihilation.campephilus.module.instrument.parse.parser.ParseNuoHe;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.parse.parser.ParsePuKe;

import java.util.HashMap;

/**
 * 解析仪器数据的类
 * @author cz
 */
public class DeviceDataParser {

    /**
     * 解析仪器数据并返回解析数据
     * @param rawData 原始数据
     * @return 数据实体类
     */
    public static HashMap<String, Object> parseDeviceData(String rawData){
        HashMap<String, Object> dataMap = new HashMap<>();
        String[] result = rawData.split("%");
        // 检验原始数据正确性
        if (rawData.startsWith("%") && rawData.endsWith("%") && result.length == 3){
            dataMap.put(result[1], getDeviceData(result[1], result[2]));
        }
        return dataMap;
    }


    /**
     * 根据仪器号和数据解析得到仪器的数据实体类
     * @param deviceCode 仪器号
     * @param rawData 仪器原始数据
     * @return 仪器实体数据
     */
    private static Object getDeviceData(String deviceCode, String rawData){
        switch (deviceCode){
            // 诺和
            case DeviceCode.NUO_HE:
                return ParseNuoHe.parseData(rawData);

            // 普可
            case DeviceCode.PU_KE:
                return ParsePuKe.parseData(rawData);

            default:
                // 出错则返回一个空的列表
                return new HashMap<String, Object>();
        }
    }
}
