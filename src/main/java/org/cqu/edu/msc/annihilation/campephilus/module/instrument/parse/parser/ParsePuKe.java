package org.cqu.edu.msc.annihilation.campephilus.module.instrument.parse.parser;

import org.cqu.edu.msc.annihilation.campephilus.module.instrument.parse.entity.DataPuKe;

/**
 * 解析普可仪器的数据类
 * @author cz
 */
public class ParsePuKe {

    /**
     * 普可的数据解析
     * @param deviceData 原始数据
     * @return 返回普可数据实体
     *
     * 数据格式: FF 01 04 05 62 00 64
     * 长度固定，格式固定
     */
    public static DataPuKe parseData(String deviceData){
        DataPuKe dataPuKe = new DataPuKe();

        if (verifyData(deviceData)){
            String[] result = deviceData.split(" ");
            int Ai = Integer.parseInt(result[3], 16);
            int BSR = Integer.parseInt(result[4], 16);
            int EMG = Integer.parseInt(result[5], 16);
            int SQI = Integer.parseInt(result[6], 16);

            dataPuKe.setAi("" + Ai);
            dataPuKe.setBSR("" + BSR);
            dataPuKe.setEMG("" + EMG);
            dataPuKe.setSQI("" + SQI);
        }

        return dataPuKe;
    }

    /**
     * 普可的数据格式检验
     * @param data 数据
     * @return 返回是否是合格数据
     */
    private static boolean verifyData(String data){
        // TODO: 可能长度不是7 需要验证一下
        return data.startsWith("FF") && data.split(" ").length == 7;
    }
}
