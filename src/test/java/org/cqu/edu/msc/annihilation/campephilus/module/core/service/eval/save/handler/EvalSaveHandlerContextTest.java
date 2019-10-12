package org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.save.handler;

import com.google.gson.Gson;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.EvalAnesthesiaDepth;
import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.EvalEntityEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/9/25
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@SpringBootTest
class EvalSaveHandlerContextTest {

    @Autowired
    private EvalSaveHandlerContext evalSaveHandlerContext;

    @Test
    void getSaveInstance() {
        EvalAnesthesiaDepth entity =
                new EvalAnesthesiaDepth(
                        "test", "test", "test",
                        "test", "test", "test", "test",
                        "test", "test", "test",
                        "test", "test", "test",
                        "test", "test", "test",
                        "test", "test", "test",
                        "test", "test",
                        "test", "test",
                        "test", "test", "test",
                        "test", "test",
                        "test", "test", "test",
                        "test", "test", "test", "test", "test",
                        "test", "test", "test", "test", "test",
                        "test", "test", "test", "test", "test",
                        "test", "test");
        String object = new Gson().toJson(entity);
        Object result = evalSaveHandlerContext.getSaveInstance(EvalEntityEnum.EVAL_ANESTHESIA_DEPTH.getCode()).save(object);
        Assert.notNull(result, "no");
    }
}