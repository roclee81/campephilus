package org.cqu.edu.mrc.realdata.modules.app.service.impl;

import com.google.gson.Gson;
import org.cqu.edu.mrc.realdata.common.constant.DataConstants;
import org.cqu.edu.mrc.realdata.modules.app.dataobject.DeviceDO;
import org.cqu.edu.mrc.realdata.modules.app.dto.MedicalDataDTO;
import org.cqu.edu.mrc.realdata.modules.app.dto.ParseDataDTO;
import org.cqu.edu.mrc.realdata.modules.app.repository.DeviceRepository;
import org.cqu.edu.mrc.realdata.modules.app.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Map;


/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/20 16:46
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public Page<DeviceDO> getDeviceDOSByDeviceIdAndOperationNumber(String deviceId, Integer operationNumber, Pageable pageable) {
        return deviceRepository.findDeviceDOSByDeviceIdAndOperationNumber(deviceId, operationNumber, pageable);
    }

    @Override
    public Page<DeviceDO> getDeviceDOSByDeviceId(String deviceId, Pageable pageable) {
        return deviceRepository.findDeviceDOSByDeviceId(deviceId, pageable);
    }

    @Override
    public Page<DeviceDO> getDeviceDOSByOperationNumber(Integer operationNumber, Pageable pageable) {
        return deviceRepository.findDeviceDOSByOperationNumber(operationNumber, pageable);
    }

    @Override
    public void saveDeviceDO(DeviceDO deviceDO, String deviceId) {
        deviceRepository.save(deviceDO, deviceId);
    }

    @Override
    public boolean saveDeviceDO(ParseDataDTO parseDataDTO) {
        if (null == parseDataDTO) {

            Map deviceData;
            Integer operationNumber;
            String macAddress;
            Integer deviceDataNumber;
            try {
                deviceData = parseDataDTO.getData();
                operationNumber = parseDataDTO.getOperationNumber();
                macAddress = parseDataDTO.getMacAddress();
                deviceDataNumber = deviceData.get("")
            } catch (NullPointerException exception) {
                return false;
            }


            DeviceDO deviceDO = new DeviceDO(operationNumber,);
            deviceDO.setUpdateTime(new Date());

            //
            if (null == parseDataDTO.getOperationNumber()) {
                return false;
            }
            deviceDO.setOperationNumber(parseDataDTO.getOperationNumber());

            // 检查是否有deviceId,没有直接返回
            String deviceId;
            if (deviceData.containsKey(DataConstants.DEVICE_ID)) {
                deviceId = (String) deviceData.get(DataConstants.DEVICE_ID);
            } else {
                return false;
            }

            Map data;
            if (deviceData.containsKey(DataConstants.))

                this.saveDeviceDO(deviceDO, deviceId);
        }


        return true;
    }
}
