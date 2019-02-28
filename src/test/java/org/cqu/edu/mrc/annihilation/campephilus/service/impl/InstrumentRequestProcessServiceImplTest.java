package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import org.cqu.edu.mrc.annihilation.campephilus.dto.ResultDataDTO;
import org.cqu.edu.mrc.annihilation.campephilus.form.InstrumentRequestForm;
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
public class InstrumentRequestProcessServiceImplTest {

    @Autowired
    InstrumentRequestProcessServiceImpl dataStorageService;

    @Test
    public void parseJson() {
    }

    @Test
    public void processCode() {
    }

    @Test
    public void processMedicalData1() {
        // 准备要开始手术了(手术开始准备,请求operationNumber)
        InstrumentRequestForm instrumentRequestForm1 = new InstrumentRequestForm();
        instrumentRequestForm1.setCode(151);
        instrumentRequestForm1.setMac("00-0f-e2-2e-94-a9");
        instrumentRequestForm1.setOperationNumber(-1);
        instrumentRequestForm1.setData("{\"operationInfo\":{\"patientId\":\"patientId\",\"operationHospitalCode\":\"0147\",\"operationStartTime\":\"1546501804000\"},\"deviceInfo\":[{\"deviceType\":1,\"serialNumber\":\"SN123123\",\"serviceLife\":2},{\"deviceType\":2,\"serialNumber\":\"SN1231233\",\"serviceLife\":3}]}");
        ResultDataDTO resultDataDTO1 = dataStorageService.processInstrumentData(instrumentRequestForm1);
        Assert.assertEquals((int) resultDataDTO1.getCode(), 152);
    }

    @Test
    public void processMedicalData2() {
        // 准备要开始手术了(手术开始准备,请求operationNumber)
        InstrumentRequestForm instrumentRequestForm2 = new InstrumentRequestForm();
        instrumentRequestForm2.setCode(151);
        instrumentRequestForm2.setMac("00-0f-e2-2e-94-a9");
        instrumentRequestForm2.setData("{\"patientId\":\"1022\",\"operationCode\":\"0147\",\"operationStartTime\":\"1546493024000\",\"deviceInformation\":{\"test\":\"i123\"}}");
        ResultDataDTO resultDataDTO2 = dataStorageService.processInstrumentData(instrumentRequestForm2);
        //Assert.assertEquals((int) resultDataDTO2.getCode(), -2);
    }

    @Test
    public void processMedicalData3() {
        // 准备要开始手术了(手术开始准备,请求operationNumber)
        InstrumentRequestForm instrumentRequestForm3 = new InstrumentRequestForm();
        instrumentRequestForm3.setCode(151);
        instrumentRequestForm3.setOperationNumber(-2);
        instrumentRequestForm3.setData("{\"patientId\":\"1022\",\"operationHospitalCode\":\"0147\",\"operationStartTime\":\"1546493024000\",\"deviceInformation\":{\"test\":\"i123\"}}");
        ResultDataDTO resultDataDTO3 = dataStorageService.processInstrumentData(instrumentRequestForm3);
        //Assert.assertEquals((int) resultDataDTO3.getCode(), -2);
    }

    @Test
    public void processMedicalData4() {
        // 准备发送手术设备数据
        InstrumentRequestForm instrumentRequestForm4 = new InstrumentRequestForm();
        instrumentRequestForm4.setCode(153);
        instrumentRequestForm4.setOperationNumber(dataStorageService.getCurrentOperationNumber());
        instrumentRequestForm4.setMac("00-0f-e2-2e-94-a9");
        ResultDataDTO resultDataDTO4 = dataStorageService.processInstrumentData(instrumentRequestForm4);
        Assert.assertEquals((int) resultDataDTO4.getCode(), 154);
    }

    @Test
    public void processMedicalData5() {
        // 发送手术设备数据
        InstrumentRequestForm instrumentRequestForm5 = new InstrumentRequestForm();
        instrumentRequestForm5.setCode(155);
        instrumentRequestForm5.setOperationNumber(dataStorageService.getCurrentOperationNumber());
        instrumentRequestForm5.setMac("00-0f-e2-2e-94-a9");
        instrumentRequestForm5.setData("{\"deviceInformation\":{}}");
        ResultDataDTO resultDataDTO5 = dataStorageService.processInstrumentData(instrumentRequestForm5);
        Assert.assertEquals((int) resultDataDTO5.getCode(), 156);
    }

    @Test
    public void processMedicalData6() {
        // 上传病人数据
        InstrumentRequestForm instrumentRequestForm6 = new InstrumentRequestForm();
        instrumentRequestForm6.setCode(161);
        instrumentRequestForm6.setOperationNumber(dataStorageService.getCurrentOperationNumber());
        instrumentRequestForm6.setMac("00-0f-e2-2e-94-a9");
        instrumentRequestForm6.setData("{\"patientId\": \"0xx11111\", \"patientData\": {}, \"preoperativeData\": {}}");
        ResultDataDTO resultDataDTO6 = dataStorageService.processInstrumentData(instrumentRequestForm6);
        Assert.assertEquals((int) resultDataDTO6.getCode(), 162);
    }

    @Test
    public void processMedicalData7() {
        // 更新病人数据，即术后病人数据
        InstrumentRequestForm instrumentRequestForm7 = new InstrumentRequestForm();
        instrumentRequestForm7.setCode(183);
        instrumentRequestForm7.setOperationNumber(dataStorageService.getCurrentOperationNumber());
        instrumentRequestForm7.setMac("00-0f-e2-2e-94-a9");
        instrumentRequestForm7.setData("{\"patientId\": \"0xx11111\", \"postoperativeData\": {}}");
        ResultDataDTO resultDataDTO7 = dataStorageService.processInstrumentData(instrumentRequestForm7);
        Assert.assertEquals((int) resultDataDTO7.getCode(), 184);
    }

    @Test
    public void processMedicalData8() {
        // 发送仪器数据
        InstrumentRequestForm instrumentRequestForm7 = new InstrumentRequestForm();
        instrumentRequestForm7.setCode(167);
        instrumentRequestForm7.setOperationNumber(dataStorageService.getCurrentOperationNumber());
        instrumentRequestForm7.setMac("00-0f-e2-2e-94-a9");
        instrumentRequestForm7.setData("{\"deviceId\":\"i123\",\"deviceDataNumber\":\"1\",\"deviceData\":{}}");
        ResultDataDTO resultDataDTO7 = dataStorageService.processInstrumentData(instrumentRequestForm7);
        Assert.assertEquals((int) resultDataDTO7.getCode(), 168);
    }

    @Test
    public void processMedicalData9() {
        // 手术中的标记信息
        InstrumentRequestForm instrumentRequestForm8 = new InstrumentRequestForm();
        instrumentRequestForm8.setCode(173);
        instrumentRequestForm8.setOperationNumber(dataStorageService.getCurrentOperationNumber());
        instrumentRequestForm8.setMac("00-0f-e2-2e-94-a9");
        instrumentRequestForm8.setData("{\"markNumber\":1,\"markType\":1,\"markMessage\":{}}");
        ResultDataDTO resultDataDTO8 = dataStorageService.processInstrumentData(instrumentRequestForm8);
        //Assert.assertEquals((int) resultDataDTO8.getCode(), -2);
    }

    @Test
    public void processMedicalData10() {
        // 是手术结束的信息
        InstrumentRequestForm instrumentRequestForm9 = new InstrumentRequestForm();
        instrumentRequestForm9.setCode(179);
        instrumentRequestForm9.setOperationNumber(dataStorageService.getCurrentOperationNumber());
        instrumentRequestForm9.setMac("00-0f-e2-2e-94-a9");
        instrumentRequestForm9.setData("{\"operationEndTime\":\"1546492789000\"}");
        ResultDataDTO resultDataDTO9 = dataStorageService.processInstrumentData(instrumentRequestForm9);
        Assert.assertEquals((int) resultDataDTO9.getCode(), 180);
    }
}