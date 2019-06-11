package org.cqu.edu.msc.annihilation.campephilus.module.instrument.parse.parser;

import org.cqu.edu.msc.annihilation.campephilus.module.instrument.parse.entity.DataNuoHe;

/**
 * 解析诺和数据的类
 * @author cz
 */
public class ParseNuoHe {

    /**
     * 解析数据
     * @param deviceData 仪器原始数据
     * @return 诺和的数据实体
     *
     * 数据格式:FF 01 7D 58 EC 2C 78 02 0B 00 00 02 00 00 FF FF FF 00 00 FF C8 CA 3C 19 E60065000000000000000000000000000000000000000000000000000
     * 00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
     * 000000000000009D25FE
     *
     * 特征:长度固定 4个参数的位置也是固定
     */
    public static DataNuoHe parseData(String deviceData, String serialNumber){
        DataNuoHe dataNuoHe = new DataNuoHe();

        if (verifyData(deviceData)){
            // CSI:偏移量15字节  BS:偏移量16字节  SQI:偏移量17字节   EMG:偏移量20字节
            int CSI = Integer.parseInt(deviceData.substring(28,30), 16);
            int BS = Integer.parseInt(deviceData.substring(30,32), 16);
            int SQI = Integer.parseInt(deviceData.substring(32,34), 16);
            int EMG = Integer.parseInt(deviceData.substring(38,40), 16);

            if (CSI == 255){
                dataNuoHe.setCSI(DataCons.INVALID_DATA);
            }else{
                dataNuoHe.setCSI("" + CSI);
            }

            if (BS == 255){
                dataNuoHe.setBS(DataCons.INVALID_DATA);
            }else {
                dataNuoHe.setBS("" + BS);
            }

            if (SQI == 255){
                dataNuoHe.setSQI(DataCons.INVALID_DATA);
            }else {
                dataNuoHe.setSQI("" + SQI);
            }

            if (EMG == 255){
                dataNuoHe.setEMG(DataCons.INVALID_DATA);
            }else {
                dataNuoHe.setEMG("" + EMG);
            }

            // 设置序列号
            dataNuoHe.setSerialNumber(serialNumber);
        }
        return dataNuoHe;
    }

    /**
     * 诺和的数据格式检验
     * @param data 数据
     * @return 返回是否是合格数据
     */
    private static boolean verifyData(String data){
        return data.startsWith("FF") && data.endsWith("FE");
    }

}
