//package com.example.demo.parse.parser;
//
//import com.example.demo.parse.DataCons;
//import com.example.demo.parse.entity.DataBaoLaiTe;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
///**
// * 解析宝莱特Q6的类
// * @author cz
// */
//public class ParseBaoLaiTe {
//
//
//
//    /**
//     * 宝莱特数据解析
//     * @param deviceData 仪器原始数据
//     * @return 宝莱特数据实体
//     */
//    public static DataBaoLaiTe parseData(String deviceData){
//
//        DataBaoLaiTe dataBaoLaiTe = new DataBaoLaiTe();
//
//        HashMap<String, List<Integer>> dataMap = new HashMap<>();       // 返回的HashMap
//
//        // FFD1000000F100 0A09 0C E001057908602F2F7F400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000E4320003047F3FE4330003047F3FE616006B095E075E075E0720062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006E617006B095E075E075E0720062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006E3040067FF0A0004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400E102011B00FF000000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000E20B00037F0702E503000A10010000803F763F763F0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
//
//        // 正常的数据报文
//        if (deviceData.startsWith("FFD1")){
//
//            int dataLengthAll = getLength(deviceData.substring(14, 18));                // 获取数据的总长度
//            String realData = deviceData.substring(20, dataLengthAll * 2 + 18);         // 获取去除了后面0和前面前缀的数据块
//            List<String> dataBlockList = new ArrayList<>();
//
//            List<DataBaoLaiTe> baoLTList = new ArrayList<>();                           // 存放各个数据块
//
//            // E001 0579 08602F2F7F400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000
//            // E432 0003 047F3F
//            // E433 0003 047F3F
//            // E616 006B 095E075E075E0720062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006
//            // E617 006B 095E075E075E0720062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006200620062006
//            // E304 0067 FF0A0004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400040004000400
//            // E102 011B 00FF000000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000400000
//            // E20B 0003 7F0702
//            // E503 000A 10010000803F763F763F
//            // 0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
//
//            while (realData.startsWith("E")){
//                int dataLength = getLength(realData.substring(4, 8));           // 4-8位为数据长度位
//                String dataBlock = realData.substring(dataLength * 2 + 8);      // 获取一个数据块
//                dataBlockList.add(dataBlock);                                   // 把数据块存入列表中 每个记录代表一条小类的数据
//            }
//
//            // 遍历解析列表中所有数据
//            for (String blockData : dataBlockList){
//
//                int dataBlockLength = getLength(blockData.substring(4, 8));          // 4-8位为数据长度位 获取每个小数据块的长度
//
//                if (verifyData(realData, dataBlockLength)){
//                    String blockDefine = blockData.substring(0, 2);         // 标识每个数据块的定义 如E0 E1等
//                    parseDataBlock(blockDefine, blockData);
//                }
//            }
//
//            if (verifyData(realData)){
//
//            }
//
//
//
//            DataBaoLaiTe dataBaoLT = new DataBaoLaiTe();
//            dataBaoLT.setModuleDefine(realData.substring(0, 2));
//            dataBaoLT.setModuleId(realData.substring(2, 4));
//
//            int dataLength = getLength(realData.substring(4, 8));          // 4-8位为数据长度位
//            dataBaoLT.setDataLength(dataLength);
//            dataBaoLT.setDeviceData(realData.substring(8, dataLength * 2 + 8));
//
//            baoLTList.add(dataBaoLT);
//            realData = realData.substring(dataLength * 2 + 8);
//
//
//            // 此时已经获取到各个数据块的数据,现在分别处理各个数据块的数据
//            for (DataBaoLaiTe dataBaoLaiTe1 : baoLTList){
//                dataMap.put(dataBaoLT.getModuleDefine(), parseDataBlock(dataBaoLT.getModuleDefine(), dataBaoLT.getModuleDefine()));
//            }
//            // 心率异常信息
//        }else if (deviceData.startsWith("FFD3")){
//
//        }
//        return dataBaoLaiTe;
//    }
//
//
//    // 分别解析数据块,并获取各个数据块对应的数值，返回值是List
//    private static void parseDataBlock(String dataBlockDefine, String data){
//
//        List<Integer> dataList = new ArrayList<>();     // 定义数据的List
//
//        switch (dataBlockDefine){
//            case "E0":          // ECG数据块
//                // Byte8为心率值 如 7F 低7位  范围0-300  0111 1111
//                String heartRateString = data.substring(8, 10);
//                int heartRate = Integer.parseInt(heartRateString, 16);
//
//            case "E1":          // 血氧数据块
//                // Bit6,5,4,3,2,1,0 血氧值 0~100, 127 无效   FF
//                // E102 011B 00FF0000004000004000004
//                // 解析血氧值
//                char[] bloodOxygenChars = data.substring(2, 4).toCharArray();
//                String[] result = new String[2];
//                result[0] = getCharBinaryString(bloodOxygenChars[0]).substring(1);
//                result[1] = getCharBinaryString(bloodOxygenChars[1]);
//                int bloodOxygenValue = Integer.parseInt(result[0] + result[1], 2);
//                if (bloodOxygenValue == 127){
//                    dataList.add(-100);                 // 无效值
//                }else {
//                    dataList.add(bloodOxygenValue);     // 将血氧值添加进dataList
//                }
//
//
//            case "E2":          // Pulse数据块
//                // E20B 0003 7F0702
//                // 脉搏用两个字节表示  7F07
//                // Byte4 Bit 6~0 脉率值低 7 位   Bit7 0
//                // Byte5 Bit 1~0 脉率值高 2 位   Bit 2 0： 有效 1： 无效 脉率无效位   Bit 7~3 00000
//                char[] pulseChars = data.substring(0, 5).toCharArray();     // 得到脉搏的字符数据,即 7 F 0 7
//                // 7   F            0   7
//                // 01111111         00000111
//                String[] pulseString = new String[4];
//                pulseString[0] = getCharBinaryString(pulseChars[0]);
//                pulseString[1] = getCharBinaryString(pulseChars[1]).substring(1);
//                pulseString[2] = getCharBinaryString(pulseChars[2]).substring(0, 2);
//                pulseString[3] = getCharBinaryString(pulseChars[3]);
//                int pulseValue = Integer.parseInt(pulseString[3] + pulseString[0] + pulseString[1], 2);
//                boolean isPulseValid = pulseString[3].substring(1, 2).equals("1");
//                if (isPulseValid){
//                    dataList.add(pulseValue);   // 有效值
//                }else {
//                    dataList.add(-5);     // 无效值
//                }
//
//
//            case "E3":          // RESP数据量
//
//
//            case "E4":          // 体温数据块
//
//
//            case "E5":          // NIBP数据块
//
//
//            case "E6":          // 有创血压数据块
//
//
//            case "E7":          // CO2数据块
//
//
//            case "E8":          // O2数据块
//
//
//            case "E9":          // N2O数据块
//
//
//            case "EA":          // AA数据块
//
//
//            case "EB":          // ICG数据块
//
//
//            case "FE":          // 报警状态数据
//
//
//            default:
//        }
//
//        return dataList;
//
//    }
//
//
//
//    // 根据数据的长度字符串获取参数的长度
//    private static int getLength(String lengthData){
//        StringBuilder builder = new StringBuilder();
//        char[] array = lengthData.toCharArray();
//        String[] resultBinary = new String[4];
//        for (int i = 0; i < array.length; i++){
//            resultBinary[i] = getCharBinaryString(array[i]);
//        }
//        builder.append("00").append(resultBinary[0].substring(1)).append(resultBinary[1]).append(resultBinary[2].substring(1)).append(resultBinary[3]);
//        return Integer.parseInt(builder.toString(), 2);
//    }
//
//
//    // 根据字符获取其对应的二进制字符串
//    private static String getCharBinaryString(char a){
//        switch (a){
//            case '0': return "0000";
//            case '1': return "0001";
//            case '2': return "0010";
//            case '3': return "0011";
//            case '4': return "0100";
//            case '5': return "0101";
//            case '6': return "0110";
//            case '7': return "0111";
//            case '8': return "1000";
//            case '9': return "1001";
//            case 'A': return "1010";
//            case 'B': return "1011";
//            case 'C': return "1100";
//            case 'D': return "1101";
//            case 'E': return "1110";
//            case 'F': return "1111";
//            default: return "0000";
//        }
//    }
//
//
//}
//