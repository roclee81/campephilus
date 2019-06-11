package org.cqu.edu.msc.annihilation.campephilus.module.instrument.parse.entity;

/**
 * 诺和的数据实体类
 * @author cz
 */
public class DataNuoHe {

    /**
     * CSI
     */
    private String CSI;

    /**
     * BS
     */
    private String BS;

    /**
     * SQI
     */
    private String SQI;

    /**
     * EMG
     */
    private String EMG;

    /**
     * 序列号
     */
    private String serialNumber;

    public String getCSI() {
        return CSI;
    }

    public void setCSI(String CSI) {
        this.CSI = CSI;
    }

    public String getBS() {
        return BS;
    }

    public void setBS(String BS) {
        this.BS = BS;
    }

    public String getSQI() {
        return SQI;
    }

    public void setSQI(String SQI) {
        this.SQI = SQI;
    }

    public String getEMG() {
        return EMG;
    }

    public void setEMG(String EMG) {
        this.EMG = EMG;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }


    @Override
    public String toString() {
        return "DataNuoHe{" +
                "CSI='" + CSI + '\'' +
                ", BS='" + BS + '\'' +
                ", SQI='" + SQI + '\'' +
                ", EMG='" + EMG + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }
}
