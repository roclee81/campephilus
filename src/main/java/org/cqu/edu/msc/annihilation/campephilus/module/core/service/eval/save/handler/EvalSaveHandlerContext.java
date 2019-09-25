package org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.save.handler;

import org.springframework.beans.factory.InitializingBean;
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
public class EvalSaveHandlerContext implements InitializingBean {

    private Map<String, HandlerType> handlerTypeMapMap;
    private Map<String, EvalSaveService> evalSaveHandlerMap;
    private Map<Integer, EvalSaveService> evalSaveServiceMap;

    public EvalSaveHandlerContext(Map<String, HandlerType> handlerTypeMapMap,
                                  Map<String, EvalSaveService> evalSaveHandlerMap) {
        this.handlerTypeMapMap = handlerTypeMapMap;
        this.evalSaveHandlerMap = evalSaveHandlerMap;
        this.evalSaveServiceMap = new HashMap<>();
    }

    public EvalSaveService getSaveInstance(Integer type) {
        EvalSaveService clazz = evalSaveServiceMap.getOrDefault(type, null);
        if (clazz == null) {
            throw new IllegalArgumentException("not found handler for type: " + type);
        }
        return clazz;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for (Map.Entry<String, HandlerType> e : handlerTypeMapMap.entrySet()) {
            evalSaveServiceMap.put(e.getValue().getType(), evalSaveHandlerMap.get(e.getKey()));
        }
    }
}