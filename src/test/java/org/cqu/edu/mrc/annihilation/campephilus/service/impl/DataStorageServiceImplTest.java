package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import org.cqu.edu.mrc.annihilation.campephilus.dto.ResultDataDTO;
import org.cqu.edu.mrc.annihilation.campephilus.form.MedicalDataForm;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/25 13:17
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DataStorageServiceImplTest {

    @Autowired
    DataStorageServiceImpl dataStorageService;

    @Test
    public void parseJson() {
    }

    @Test
    public void processCode() {
    }

    @Test
    public void processMedicalData1() {
        // 准备要开始手术了(手术开始准备,请求operationNumber)
        MedicalDataForm medicalDataForm1 = new MedicalDataForm();
        medicalDataForm1.setCode(151);
        medicalDataForm1.setMac("00-0f-e2-2e-94-a9");
        medicalDataForm1.setOperationNumber(-1);
        medicalDataForm1.setData("{\"operationInfo\":{\"patientId\":\"patientId\",\"operationHospitalCode\":\"0147\",\"operationStartTime\":\"1546501804000\"},\"deviceInfo\":[{\"deviceType\":1,\"serialNumber\":\"SN123123\",\"serviceLife\":2},{\"deviceType\":2,\"serialNumber\":\"SN1231233\",\"serviceLife\":3}]}");
        ResultDataDTO resultDataDTO1 = dataStorageService.processMedicalData(medicalDataForm1);
        Assert.assertEquals((int) resultDataDTO1.getCode(), 152);
    }

    @Test
    public void processMedicalData2() {
        // 准备要开始手术了(手术开始准备,请求operationNumber)
        MedicalDataForm medicalDataForm2 = new MedicalDataForm();
        medicalDataForm2.setCode(151);
        medicalDataForm2.setMac("00-0f-e2-2e-94-a9");
        medicalDataForm2.setData("{\"patientId\":\"1022\",\"operationHospitalCode\":\"0147\",\"operationStartTime\":\"1546493024000\",\"deviceInformation\":{\"test\":\"i123\"}}");
        ResultDataDTO resultDataDTO2 = dataStorageService.processMedicalData(medicalDataForm2);
        Assert.assertEquals((int) resultDataDTO2.getCode(), -2);
    }

    @Test
    public void processMedicalData3() {
        // 准备要开始手术了(手术开始准备,请求operationNumber)
        MedicalDataForm medicalDataForm3 = new MedicalDataForm();
        medicalDataForm3.setCode(151);
        medicalDataForm3.setOperationNumber(-2);
        medicalDataForm3.setData("{\"patientId\":\"1022\",\"operationHospitalCode\":\"0147\",\"operationStartTime\":\"1546493024000\",\"deviceInformation\":{\"test\":\"i123\"}}");
        ResultDataDTO resultDataDTO3 = dataStorageService.processMedicalData(medicalDataForm3);
        Assert.assertEquals((int) resultDataDTO3.getCode(), -2);
    }

    @Test
    public void processMedicalData4() {
        // 准备发送手术设备数据
        MedicalDataForm medicalDataForm4 = new MedicalDataForm();
        medicalDataForm4.setCode(153);
        medicalDataForm4.setOperationNumber(dataStorageService.getCurrentOperationNumber());
        medicalDataForm4.setMac("00-0f-e2-2e-94-a9");
        ResultDataDTO resultDataDTO4 = dataStorageService.processMedicalData(medicalDataForm4);
        Assert.assertEquals((int) resultDataDTO4.getCode(), 154);
    }

    @Test
    public void processMedicalData5() {
        // 发送手术设备数据
        MedicalDataForm medicalDataForm5 = new MedicalDataForm();
        medicalDataForm5.setCode(155);
        medicalDataForm5.setOperationNumber(dataStorageService.getCurrentOperationNumber());
        medicalDataForm5.setMac("00-0f-e2-2e-94-a9");
        medicalDataForm5.setData("{\"deviceInformation\":{}}");
        ResultDataDTO resultDataDTO5 = dataStorageService.processMedicalData(medicalDataForm5);
        Assert.assertEquals((int) resultDataDTO5.getCode(), 156);
    }

    @Test
    public void processMedicalData6() {
        // 上传病人数据
        MedicalDataForm medicalDataForm6 = new MedicalDataForm();
        medicalDataForm6.setCode(161);
        medicalDataForm6.setOperationNumber(dataStorageService.getCurrentOperationNumber());
        medicalDataForm6.setMac("00-0f-e2-2e-94-a9");
        medicalDataForm6.setData("{\"patientId\": \"0xx11111\", \"patientData\": {}, \"preoperativeData\": {}}");
        ResultDataDTO resultDataDTO6 = dataStorageService.processMedicalData(medicalDataForm6);
        Assert.assertEquals((int) resultDataDTO6.getCode(), 162);
    }

    @Test
    public void processMedicalData7() {
        // 更新病人数据，即术后病人数据
        MedicalDataForm medicalDataForm7 = new MedicalDataForm();
        medicalDataForm7.setCode(183);
        medicalDataForm7.setOperationNumber(dataStorageService.getCurrentOperationNumber());
        medicalDataForm7.setMac("00-0f-e2-2e-94-a9");
        medicalDataForm7.setData("{\"patientId\": \"0xx11111\", \"postoperativeData\": {}}");
        ResultDataDTO resultDataDTO7 = dataStorageService.processMedicalData(medicalDataForm7);
        Assert.assertEquals((int) resultDataDTO7.getCode(), 184);
    }

    @Test
    public void processMedicalData8() {
        // 发送仪器数据
        MedicalDataForm medicalDataForm7 = new MedicalDataForm();
        medicalDataForm7.setCode(167);
        medicalDataForm7.setOperationNumber(dataStorageService.getCurrentOperationNumber());
        medicalDataForm7.setMac("00-0f-e2-2e-94-a9");
        medicalDataForm7.setData("{\"deviceId\":\"i123\",\"deviceDataNumber\":\"1\",\"deviceData\":{}}");
        ResultDataDTO resultDataDTO7 = dataStorageService.processMedicalData(medicalDataForm7);
        Assert.assertEquals((int) resultDataDTO7.getCode(), 168);
    }

    @Test
    public void processMedicalData9() {
        // 手术中的标记信息
        MedicalDataForm medicalDataForm8 = new MedicalDataForm();
        medicalDataForm8.setCode(173);
        medicalDataForm8.setOperationNumber(dataStorageService.getCurrentOperationNumber());
        medicalDataForm8.setMac("00-0f-e2-2e-94-a9");
        medicalDataForm8.setData("{\"markNumber\":1,\"markType\":1,\"markMessage\":{}}");
        ResultDataDTO resultDataDTO8 = dataStorageService.processMedicalData(medicalDataForm8);
        Assert.assertEquals((int) resultDataDTO8.getCode(), -2);
    }

    @Test
    public void processMedicalData10() {
        // 是手术结束的信息
        MedicalDataForm medicalDataForm9 = new MedicalDataForm();
        medicalDataForm9.setCode(179);
        medicalDataForm9.setOperationNumber(dataStorageService.getCurrentOperationNumber());
        medicalDataForm9.setMac("00-0f-e2-2e-94-a9");
        medicalDataForm9.setData("{\"operationEndTime\":\"1546492789000\"}");
        ResultDataDTO resultDataDTO9 = dataStorageService.processMedicalData(medicalDataForm9);
        Assert.assertEquals((int) resultDataDTO9.getCode(), 180);
    }
}