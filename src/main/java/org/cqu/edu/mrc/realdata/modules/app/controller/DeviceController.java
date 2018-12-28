package org.cqu.edu.mrc.realdata.modules.app.controller;

import org.cqu.edu.mrc.realdata.common.enums.MqttEnum;
import org.cqu.edu.mrc.realdata.common.utils.R;
import org.cqu.edu.mrc.realdata.modules.app.dto.MedicalDataForm;
import org.cqu.edu.mrc.realdata.modules.app.dto.ParseDataDTO;
import org.cqu.edu.mrc.realdata.modules.app.service.impl.DataProcessServiceImpl;
import org.cqu.edu.mrc.realdata.modules.sys.form.PasswordForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/28 17:11
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@RestController
@RequestMapping(value = "/data/device")
public class DeviceController {

    private final DataProcessServiceImpl dataProcessService;

    @Autowired
    public DeviceController(DataProcessServiceImpl dataProcessService) {
        this.dataProcessService = dataProcessService;
    }

    @PostMapping("/")
    @Async("asyncServiceExecutor")
    public R saveDeviceDO(@RequestBody MedicalDataForm medicalDataForm) {
        if (null == medicalDataForm || null == medicalDataForm.getCode()) {
            //return MqttEnum.DATA_FORMAT_ERROR.getCode();
            //return;
        }

        ParseDataDTO parseDataDTO = dataProcessService.processMsg(medicalDataForm);

        if (null == parseDataDTO) {
            //return MqttEnum.DATA_FORMAT_ERROR.getCode();
            //return;
        }

        int result = dataProcessService.processCode(parseDataDTO);

        return R.success();

    }

    @GetMapping("/")
    public void getDevice(){

    }


}
