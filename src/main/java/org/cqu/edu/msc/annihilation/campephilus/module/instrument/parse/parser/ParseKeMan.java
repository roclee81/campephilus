package org.cqu.edu.msc.annihilation.campephilus.module.instrument.parse.parser;


import org.cqu.edu.msc.annihilation.campephilus.module.instrument.parse.entity.DataKeMan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParseKeMan {

    public HashMap<String, List<Integer>> parseData(String data){
        HashMap<String, List<Integer>> dataMap = new HashMap<>();       // 返回数据的列表

        List<DataKeMan> dataKeManList = new ArrayList<>();    // 存储数据块的列表

        // BBBB091E0D00FE000100010035EEEE00000000
        while (data.startsWith("BBBB")){

            DataKeMan dataKeMan = new DataKeMan();
            dataKeMan.setDataType(data.substring(4, 6));
            int dataLength = Integer.parseInt(data.substring(10, 12) + data.substring(8, 10), 16);  // 0D00 -- 000D
            dataKeMan.setDataLength(dataLength);
            dataKeMan.setDeviceData(data.substring(12, dataLength * 2 + 4));
            data = data.substring(dataLength * 2 + 4);
            dataKeManList.add(dataKeMan);
        }

        for (DataKeMan dataKeMan : dataKeManList){
            //printInfo(dataKeMan.toString());
            dataMap.put(dataKeMan.getDataType(), parseDataBlock(dataKeMan.getDataType(), dataKeMan.getDeviceData()));       // 循环解析并添加数据
        }

        return dataMap;
    }


    private  List<Integer> parseDataBlock(String dataBlockDefine, String data) {

        List<Integer> dataList = new ArrayList<>();     // 定义数据的List

        switch (dataBlockDefine){
            case "0D":

            case "10":

            case "11":

            case "12":

            case "13":
        }


        return dataList;

    }

}
