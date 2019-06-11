package org.cqu.edu.msc.annihilation.campephilus.module.instrument.parse.entity;

public class DataBaoLaiTe {

    private String moduleDefine;
    private String moduleId;
    private int dataLength;
    private String deviceData;

    public void setModuleDefine(String moduleDefine) {
        this.moduleDefine = moduleDefine;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
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

    public String getModuleDefine() {
        return moduleDefine;
    }

    public String getModuleId() {
        return moduleId;
    }

    public int getDataLength() {
        return dataLength;
    }

    @Override
    public String toString() {
        return "DataBaoLT{" +
                "moduleDefine='" + moduleDefine + '\'' +
                ", moduleId='" + moduleId + '\'' +
                ", dataLength=" + dataLength +
                ", deviceData='" + deviceData + '\'' +
                '}';
    }
}
