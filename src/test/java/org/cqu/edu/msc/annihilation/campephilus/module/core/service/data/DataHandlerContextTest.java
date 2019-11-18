package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data;

import com.google.gson.Gson;
import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.DeviceCodeEnum;
import org.cqu.edu.msc.annihilation.common.utils.ReflectUtil;
import org.cqu.edu.msc.annihilation.common.utils.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/10/12
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@SpringBootTest
class DataHandlerContextTest {

    @Autowired
    private DataHandlerContext context;

    private static final String DEVICE_ENTITY_PACKAGE_NAME = "org.cqu.edu.msc.annihilation.campephilus.module.core.entity.data.";

    @Test
    void dataSaveService() {
        for (DeviceCodeEnum deviceCodeEnum : DeviceCodeEnum.values()) {
            String dataName = StringUtils.constantNameConvertClassName(deviceCodeEnum.name());
            String dataClassName = DEVICE_ENTITY_PACKAGE_NAME + dataName;
            Class<?> c;
            try {
                c = Class.forName(dataClassName);
            } catch (ClassNotFoundException e) {
                continue;
            }
            Object object = ReflectUtil.randomFillAllStringFieldExclude(c);
            String data = new Gson().toJson(object);
            Object result = context.dataSaveService(deviceCodeEnum.getCode(), data);
            Assert.notNull(result, "Null : " + data);
        }
    }
}