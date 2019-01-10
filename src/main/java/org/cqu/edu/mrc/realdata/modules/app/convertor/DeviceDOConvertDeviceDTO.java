package org.cqu.edu.mrc.realdata.modules.app.convertor;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.DeviceDO;
import org.cqu.edu.mrc.realdata.modules.app.dataobject.OperationInformationDO;
import org.cqu.edu.mrc.realdata.modules.app.dto.DeviceDTO;
import org.cqu.edu.mrc.realdata.modules.app.dto.OperationInformationDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/8 14:43
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class DeviceDOConvertDeviceDTO {
    public static List<DeviceDTO> convert(Page<DeviceDO> sourcePage) {

        if (sourcePage.getTotalElements() <= 0) {
            return new ArrayList<>();
        }

        List<DeviceDTO> deviceDTOList = new ArrayList<>();
        sourcePage.stream().forEach((deviceDO) -> {
            DeviceDTO deviceDTO = new DeviceDTO();
            BeanUtils.copyProperties(deviceDO, deviceDTO);
            deviceDTOList.add(deviceDTO);
        });
        return deviceDTOList;
    }

    public static DeviceDTO convert(DeviceDO deviceDO) {
        if (null == deviceDO) {
            return null;
        }

        DeviceDTO deviceDTO = new DeviceDTO();
        BeanUtils.copyProperties(deviceDO, deviceDTO);
        return deviceDTO;
    }
}
