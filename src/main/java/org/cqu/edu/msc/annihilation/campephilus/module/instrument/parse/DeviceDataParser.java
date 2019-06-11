package org.cqu.edu.msc.annihilation.campephilus.module.instrument.parse;

import org.cqu.edu.msc.annihilation.campephilus.module.instrument.parse.entity.DataBaoLaiTe;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.parse.entity.DataKeMan;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.parse.entity.DataMaiRui;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.parse.entity.DataWeiHaoKang;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.parse.parser.ParseNuoHe;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.parse.parser.ParsePuKe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 解析仪器数据的类
 * @author cz
 */
public class DeviceDataParser {

    /**
     * 解析仪器数据并返回解析数据
     * @param rawData 原始数据
     *                dataFormat: #deviceCode#deviceData#serialNumber#
     * @return 数据实体类
     */
    public static HashMap<String, Object> parseDeviceData(String rawData){
        HashMap<String, Object> dataMap = new HashMap<>();
        // result[0] = ""   result[1] = "deviceCode"    result[2] = "deviceData"    result[3] = "serialNumber"
        String[] result = rawData.split("#");
        String deviceCode = result[1];
        String deviceData = result[2];
        String serialNumber = result[3];
        // Check the validation of data
        if (rawData.startsWith("#") && rawData.endsWith("#") && result.length == 4){
            dataMap.put(result[1], getDeviceData(deviceCode, deviceData, serialNumber));
        }
        return dataMap;
    }


    /**
     * 根据仪器号和数据解析得到仪器的数据实体类
     * @param deviceCode 仪器号
     * @param rawData 仪器原始数据
     * @param serialNumber 仪器序列号
     * @return 仪器实体数据
     */
    private static Object getDeviceData(String deviceCode, String rawData, String serialNumber){
        switch (deviceCode){
            // 诺和
            case DeviceCode.NUO_HE:
                return ParseNuoHe.parseData(rawData, serialNumber);


            // 普可
            case DeviceCode.PU_KE:
                return ParsePuKe.parseData(rawData, serialNumber);

            // 宝莱特
            case DeviceCode.BAO_LAI_TE:
                return baoLaiTe(rawData);

            // 威浩康
            case DeviceCode.WEI_HAO_KANG:
                return weiHaoKang(rawData);

            // 科曼
            case DeviceCode.KE_MAN:
                return keMan(rawData);

            // 迈瑞
            case DeviceCode.MAI_RUI:
                return maiRui(rawData);

            default:
                // 出错则返回一个空的列表
                return new HashMap<String, Object>();
        }
    }

    /**
     * 宝莱特数据解析
     * @param deviceData 原始数据
     * @return 解析后的数据
     */
    private static DataBaoLaiTe baoLaiTe(String deviceData){
        DataBaoLaiTe dataBaoLaiTe = new DataBaoLaiTe();
        List<Integer> dataList = new ArrayList<>();

        return dataBaoLaiTe;
    }

    /**
     * 威浩康数据解析
     * @param deviceData 原始数据
     * @return 解析后数据列表
     */
    private static DataWeiHaoKang weiHaoKang(String deviceData){
        DataWeiHaoKang dataWeiHaoKang = new DataWeiHaoKang();
        List<Integer> dataList = new ArrayList<>();

        return dataWeiHaoKang;
    }

    /**
     * 科曼数据解析
     * @param deviceData 原始数据
     * @return 解析后数据列表
     */
    private static DataKeMan keMan(String deviceData){
        DataKeMan dataKeMan = new DataKeMan();
        List<Integer> dataList = new ArrayList<>();


        return dataKeMan;
    }

    /**
     * 迈瑞数据解析
     * @param deviceData 原始数据
     * @return 解析后数据列表
     */
    private static DataMaiRui maiRui(String deviceData){
        DataMaiRui dataMaiRui = new DataMaiRui();
        List<Integer> dataList = new ArrayList<>();

        return dataMaiRui;
    }


}
