package org.cqu.edu.msc.annihilation.campephilus.module.instrument.parse.parser;

import org.cqu.edu.msc.annihilation.campephilus.module.instrument.parse.entity.DataWeiHaoKang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParseWeiHaoKang {

    public HashMap<String, List<Integer>> parseData(String data){
        HashMap<String, List<Integer>> dataMap = new HashMap<>();       // 返回数据的列表

        List<DataWeiHaoKang> dataWeiHaoKangList = new ArrayList<>();    // 存储数据块的列表

        // AA 01 17 686468FFFEFE36363636FF12275FFFFFFF000101030000CC AA0402FF00CC AA0A08 0000000064000000CC   23
        while (data.startsWith("AA")){
            DataWeiHaoKang dataWeiHaoKang = new DataWeiHaoKang();
            dataWeiHaoKang.setDataType(data.substring(2, 4));
            int dataLength = Integer.parseInt(data.substring(4, 6), 16);
            dataWeiHaoKang.setDataLength(dataLength);
            dataWeiHaoKang.setDeviceData(data.substring(6, dataLength * 2 + 8));
            data = data.substring(dataLength * 2 + 8);
            dataWeiHaoKangList.add(dataWeiHaoKang);
        }

        for (DataWeiHaoKang dataWeiHaoKang : dataWeiHaoKangList){
            dataMap.put(dataWeiHaoKang.getDataType(), parseDataBlock(dataWeiHaoKang.getDataType(), dataWeiHaoKang.getDeviceData()));    // 循环解析添加数据
        }

        return dataMap;
    }


    private  List<Integer> parseDataBlock(String dataBlockDefine, String data) {

        List<Integer> dataList = new ArrayList<>();     // 定义数据的List

        switch (dataBlockDefine){
            case "01":

            case "06":

            case "08":

            case "0A":

            case "10":
        }


        return dataList;

    }

}

