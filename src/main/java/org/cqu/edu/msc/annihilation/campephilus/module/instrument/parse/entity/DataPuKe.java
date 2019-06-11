package org.cqu.edu.msc.annihilation.campephilus.module.instrument.parse.entity;

/**
 * 浙江普可的数据实体类
 * @author cz
 */
public class DataPuKe {

    /**
     * AI
     */
    private String Ai;

    /**
     * BSR
     */
    private String BSR;

    /**
     * EMG
     */
    private String EMG;

    /**
     * SQI
     */
    private String SQI;

    /**
     * 序列号
     */
    private String serialNumber;

    public String getAi() {
        return Ai;
    }

    public void setAi(String ai) {
        Ai = ai;
    }

    public String getBSR() {
        return BSR;
    }

    public void setBSR(String BSR) {
        this.BSR = BSR;
    }

    public String getEMG() {
        return EMG;
    }

    public void setEMG(String EMG) {
        this.EMG = EMG;
    }

    public String getSQI() {
        return SQI;
    }

    public void setSQI(String SQI) {
        this.SQI = SQI;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "普可:" +
                "Ai='" + Ai + '\'' +
                ", BSR='" + BSR + '\'' +
                ", EMG='" + EMG + '\'' +
                ", SQI='" + SQI + '\'' +
                '.';
    }
}
