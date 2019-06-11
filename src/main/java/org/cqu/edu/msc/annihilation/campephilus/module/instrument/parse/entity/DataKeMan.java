package org.cqu.edu.msc.annihilation.campephilus.module.instrument.parse.entity;

public class DataKeMan {

    private String dataType;
    private int dataLength;
    private String deviceData;

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
        return "DataKeMan{" +
                "dataType='" + dataType + '\'' +
                ", dataLength=" + dataLength +
                ", deviceData='" + deviceData + '\'' +
                '}';
    }
}

