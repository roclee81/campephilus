package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data;

import java.util.List;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/9/9
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface InstrumentDataService {
    /**
     * 通过operationNumber和SerialNumber查询仪器数据
     *
     * @param operationNumber 手术序列号
     * @param deviceCode      设备号
     * @param serialNumber    仪器的序列号
     * @param page            页
     * @param size            每页大小
     * @return 查询的仪器数据
     */
    List<Object> listByOperationNumberAndSerialNumber(
            int operationNumber, String deviceCode, String serialNumber, int page, int size);
}
