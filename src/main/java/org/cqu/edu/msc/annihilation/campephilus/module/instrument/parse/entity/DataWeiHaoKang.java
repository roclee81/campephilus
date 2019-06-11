package org.cqu.edu.msc.annihilation.campephilus.module.instrument.parse.entity;



public class DataWeiHaoKang {

    private String dataType;        // 数据类型
    private int dataLength;         // 数据长度
    private String deviceData;      // 数据块


    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public int getDataLength() {
        return dataLength;
    }

    public void setDataLength(int dataLength) {
        this.dataLength = dataLength;
    }

    public String getDeviceData() {
        return deviceData;
    }

    public void setDeviceData(String deviceData) {
        this.deviceData = deviceData;
    }


    @Override
    public String toString() {
        return "DataWeiHaoKang{" +
                "dataType='" + dataType + '\'' +
                ", dataLength=" + dataLength +
                ", deviceData='" + deviceData + '\'' +
                '}';
    }
}

