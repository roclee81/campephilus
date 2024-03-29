package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data;

import com.google.gson.JsonSyntaxException;
import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.DeviceCodeEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.cqu.edu.msc.annihilation.common.dto.ResultDTO;
import org.cqu.edu.msc.annihilation.common.utils.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/9/25
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Component
public class DataHandlerContext implements InitializingBean, ApplicationContextAware {

    private static final String DEVICE_REPOSITORY_PACKAGE_NAME = "org.cqu.edu.msc.annihilation.campephilus.module.core.repository.data.";

    private static final String DEVICE_ENTITY_PACKAGE_NAME = "org.cqu.edu.msc.annihilation.campephilus.module.core.entity.data.";

    private static final String REPOSITORY = "Repository";

    private ApplicationContext applicationContext;

    /**
     * 存储code，repository映射的map
     */
    private Map<Integer, JpaRepository<Object, Integer>> dataRepositoryMap;

    /**
     * 存放实体code，entityClass映射的map
     */
    private Map<Integer, Class<?>> dataEntityClassMap;

    public DataHandlerContext() {
        dataRepositoryMap = new ConcurrentHashMap<>(DeviceCodeEnum.values().length);
        dataEntityClassMap = new ConcurrentHashMap<>(DeviceCodeEnum.values().length);
    }

    /**
     * 保存医疗仪器输出
     *
     * @param dataType 数据类型，对应不同的医疗仪器
     * @param data     解析完成的数据
     * @return ResultDTO
     */
    public ResultDTO dataSaveService(Integer dataType, String data) {
        // 匹配是否存在code
        if (DeviceCodeEnum.matchDeviceCodeEnum(dataType) == null) {
            return ResultDTO.unknownDataType();
        }
        Object entity;
        try {
            entity = ParseJsonUtil.getTObject(dataEntityClassMap.get(dataType), data);
        } catch (JsonSyntaxException e) {
            return ResultDTO.dataFormatError(e, data);
        }
        return ServiceCrudCheckUtils.saveObjectAndCheck(dataRepositoryMap.get(dataType), entity);
    }

    /**
     * 根据DeviceCodeEnum命名扫描并组合所有包名.类名
     * 同时反射生成类
     * 再通过ApplicationContext得到单例
     * 类维护两个MAP
     * dataRepositoryMap存放repository
     * dataEntityMap存放entity
     */
    @SuppressWarnings("unchecked")
    private void scannerDataStructureMap() {
        for (DeviceCodeEnum deviceCodeEnum : DeviceCodeEnum.values()) {
            String entityName = StringUtils.constantNameConvertClassName(deviceCodeEnum.name());
            // 组合成EntityClass的包路径
            String entityClassName = DEVICE_ENTITY_PACKAGE_NAME + entityName;
            // 组合成EntityRepositoryClass的包路径
            String repositoryClassName = DEVICE_REPOSITORY_PACKAGE_NAME + entityName + REPOSITORY;
            Class<?> repositoryClass;
            Class<?> entityClass;
            try {
                entityClass = Class.forName(entityClassName);
                repositoryClass = Class.forName(repositoryClassName);
            } catch (ClassNotFoundException e) {
                // TODO 没有处理
                continue;
            }
            JpaRepository<Object, Integer> repository = (JpaRepository<Object, Integer>) applicationContext.getBean(repositoryClass);
            dataRepositoryMap.put(deviceCodeEnum.getCode(), repository);
            dataEntityClassMap.put(deviceCodeEnum.getCode(), entityClass);
        }
    }

    @Override
    public void afterPropertiesSet() {
        scannerDataStructureMap();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (this.applicationContext == null) {
            this.applicationContext = applicationContext;
        }
    }
}