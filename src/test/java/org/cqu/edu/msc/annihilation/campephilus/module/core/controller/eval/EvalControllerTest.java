package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.eval;

import com.google.gson.Gson;
import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.EvalEntityEnum;
import org.cqu.edu.msc.annihilation.common.utils.ReflectUtil;
import org.cqu.edu.msc.annihilation.common.utils.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/10/12
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@SpringBootTest
class EvalControllerTest {

    @Autowired
    private EvalController evalController;

    @Test
    void save() {
        String evalPackageName = "org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.";
        for (int i = 0; i < 100; i++) {
            for (EvalEntityEnum eval : EvalEntityEnum.values()) {
                String className = StringUtils.constantNameConvertClassName(eval.name());
                Object object = ReflectUtil.randomFillAllStringFieldExclude(evalPackageName + className);
                String s = new Gson().toJson(object);
                System.out.println(s);
                evalController.save(eval.getCode(), s);
            }
        }
    }
}