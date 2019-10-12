package org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval;

import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.EvalEntityEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.cqu.edu.msc.annihilation.common.utils.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/9/25
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Component
public class EvalHandlerContext implements InitializingBean, ApplicationContextAware {

    private static final String EVAL_REPOSITORY_PACKAGE_NAME = "org.cqu.edu.msc.annihilation.campephilus.module.core.repository.eval.";

    private static final String EVAL_ENTITY_PACKAGE_NAME = "org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.";

    private static final String REPOSITORY = "Repository";

    private ApplicationContext applicationContext;

    /**
     * 存储code，repository映射的map
     */
    private Map<Integer, JpaRepository<Object, Integer>> evalRepositoryMap;

    /**
     * 存放实体code，entityClass映射的map
     */
    private Map<Integer, Class<?>> evalEntityMap;

    public EvalHandlerContext() {
        evalRepositoryMap = new HashMap<>(EvalEntityEnum.values().length);
        evalEntityMap = new HashMap<>(EvalEntityEnum.values().length);
    }

    public Object evalSaveService(Integer type, String data) {
        // 匹配是否存在code
        if (EvalEntityEnum.matchEvalEntityEnum(type) == null) {
            return null;
        }
        // TODO 返回错误判断
        Object entity = ParseJsonUtil.getTObject(evalEntityMap.get(type), data);
        return ServiceCrudCheckUtils.saveObjectAndCheckSuccess(evalRepositoryMap.get(type), entity);
    }

    /**
     * 根据EvalEntityEnum命名扫描并组合所有包名.类名
     * 同时反射生成类
     * 再通过ApplicationContext得到单例
     * 类维护两个MAP
     * evalRepositoryMap存放repository
     * evalEntityMap存放entity
     */
    @SuppressWarnings("unchecked")
    private void scannerEvalStructureMap() {
        for (EvalEntityEnum entityEnum : EvalEntityEnum.values()) {
            String entityName = StringUtils.constantNameConvertClassName(entityEnum.name());
            // 组合成EntityClass的包路径
            String entityClassName = EVAL_ENTITY_PACKAGE_NAME + entityName;
            // 组合成EntityRepositoryClass的包路径
            String repositoryClassName = EVAL_REPOSITORY_PACKAGE_NAME + entityName + REPOSITORY;
            Class<?> repositoryClass = null;
            Class entityClass = null;
            try {
                entityClass = Class.forName(entityClassName);
                repositoryClass = Class.forName(repositoryClassName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            JpaRepository<Object, Integer> repository = (JpaRepository<Object, Integer>) applicationContext.getBean(repositoryClass);
            evalRepositoryMap.put(entityEnum.getCode(), repository);
            evalEntityMap.put(entityEnum.getCode(), entityClass);
        }
    }

    @Override
    public void afterPropertiesSet() {
        scannerEvalStructureMap();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (this.applicationContext == null) {
            this.applicationContext = applicationContext;
        }
    }
}