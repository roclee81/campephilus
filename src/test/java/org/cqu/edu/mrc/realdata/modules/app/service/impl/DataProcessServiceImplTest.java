package org.cqu.edu.mrc.realdata.modules.app.service.impl;

import org.cqu.edu.mrc.realdata.modules.app.dto.ResultDataDTO;
import org.cqu.edu.mrc.realdata.modules.app.form.MedicalDataForm;
import org.junit.Assert;
import org.junit.Before;
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
public class DataProcessServiceImplTest {

    @Autowired
    DataProcessServiceImpl dataProcessService;

    private int operationNumber;

    @Test
    public void parseJson() {
    }

    @Test
    public void processCode() {
    }

    @Before
    public void processMedicalData1() {
        // 准备要开始手术了(手术开始准备,请求operationNumber)
        MedicalDataForm medicalDataForm1 = new MedicalDataForm();
        medicalDataForm1.setCode(151);
        medicalDataForm1.setMac("00-0f-e2-2e-94-a9");
        medicalDataForm1.setOperationNumber(-1);
        medicalDataForm1.setData("{\"patientId\":\"1022\",\"hospitalCode\":\"0147\",\"operationStartTime\":\"1546493024000\"}");
        ResultDataDTO resultDataDTO1 = dataProcessService.processMedicalData(medicalDataForm1);
        Assert.assertEquals((int) resultDataDTO1.getCode(), 152);
    }

    @Test
    public void processMedicalData2() {
        // 准备要开始手术了(手术开始准备,请求operationNumber)
        MedicalDataForm medicalDataForm2 = new MedicalDataForm();
        medicalDataForm2.setCode(151);
        medicalDataForm2.setMac("00-0f-e2-2e-94-a9");
        medicalDataForm2.setData("{\"patientId\":\"patientId\",\"operationStartTime\":\"1546491807000\"}");
        ResultDataDTO resultDataDTO2 = dataProcessService.processMedicalData(medicalDataForm2);
        Assert.assertEquals((int) resultDataDTO2.getCode(), -2);
    }

    @Test
    public void processMedicalData3() {
        // 准备要开始手术了(手术开始准备,请求operationNumber)
        MedicalDataForm medicalDataForm3 = new MedicalDataForm();
        medicalDataForm3.setCode(151);
        medicalDataForm3.setOperationNumber(-2);
        medicalDataForm3.setData("{\"patientId\":\"patientId\",\"operationStartTime\":\"1546491807000\"}");
        ResultDataDTO resultDataDTO3 = dataProcessService.processMedicalData(medicalDataForm3);
        Assert.assertEquals((int) resultDataDTO3.getCode(), -2);
    }

    @Test
    public void processMedicalData4() {
        // 准备发送手术设备数据
        MedicalDataForm medicalDataForm4 = new MedicalDataForm();
        medicalDataForm4.setCode(153);
        medicalDataForm4.setOperationNumber(2);
        medicalDataForm4.setMac("00-0f-e2-2e-94-a9");
        ResultDataDTO resultDataDTO4 = dataProcessService.processMedicalData(medicalDataForm4);
        Assert.assertEquals((int) resultDataDTO4.getCode(), 154);
    }

    @Test
    public void processMedicalData5() {
        // 发送手术设备数据
        MedicalDataForm medicalDataForm5 = new MedicalDataForm();
        medicalDataForm5.setCode(155);
        medicalDataForm5.setOperationNumber(2);
        medicalDataForm5.setMac("00-0f-e2-2e-94-a9");
        medicalDataForm5.setData("{\"deviceInformation\":{}}");
        ResultDataDTO resultDataDTO5 = dataProcessService.processMedicalData(medicalDataForm5);
        Assert.assertEquals((int) resultDataDTO5.getCode(), 156);
    }

    @Test
    public void processMedicalData6() {
        // 上传病人数据
        MedicalDataForm medicalDataForm6 = new MedicalDataForm();
        medicalDataForm6.setCode(161);
        medicalDataForm6.setOperationNumber(2);
        medicalDataForm6.setMac("00-0f-e2-2e-94-a9");
        medicalDataForm6.setData("{\"patientId\":\"value\",\"patientData\":{}}");
        ResultDataDTO resultDataDTO6 = dataProcessService.processMedicalData(medicalDataForm6);
        Assert.assertEquals((int) resultDataDTO6.getCode(), 162);
    }

    @Test
    public void processMedicalData7() {
        // 发送仪器数据
        MedicalDataForm medicalDataForm7 = new MedicalDataForm();
        medicalDataForm7.setCode(167);
        medicalDataForm7.setOperationNumber(2);
        medicalDataForm7.setMac("00-0f-e2-2e-94-a9");
        medicalDataForm7.setData("{\"deviceId\":\"i123\",\"deviceDataNumber\":\"1\",\"deviceData\":{}}");
        ResultDataDTO resultDataDTO7 = dataProcessService.processMedicalData(medicalDataForm7);
        Assert.assertEquals((int) resultDataDTO7.getCode(), 168);
    }

    @Test
    public void processMedicalData8() {
        // 手术中的标记信息
        MedicalDataForm medicalDataForm8 = new MedicalDataForm();
        medicalDataForm8.setCode(173);
        medicalDataForm8.setOperationNumber(2);
        medicalDataForm8.setMac("00-0f-e2-2e-94-a9");
        medicalDataForm8.setData("{\"markNumber\":1,\"markType\":1,\"markMessage\":{}}");
        ResultDataDTO resultDataDTO8 = dataProcessService.processMedicalData(medicalDataForm8);
        Assert.assertEquals((int) resultDataDTO8.getCode(), 174);
    }

    @Test
    public void processMedicalData9() {
        // 是手术结束的信息
        MedicalDataForm medicalDataForm9 = new MedicalDataForm();
        medicalDataForm9.setCode(179);
        medicalDataForm9.setOperationNumber(1);
        medicalDataForm9.setMac("00-0f-e2-2e-94-a9");
        medicalDataForm9.setData("{\"operationEndTime\":\"1546492789000\"}");
        ResultDataDTO resultDataDTO9 = dataProcessService.processMedicalData(medicalDataForm9);
        Assert.assertEquals((int) resultDataDTO9.getCode(), 180);
    }

    @Test
    public void processMedicalData() {
    }
}