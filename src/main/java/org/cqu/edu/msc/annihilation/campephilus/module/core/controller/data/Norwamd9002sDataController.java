package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.data;

import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.BaseController;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.data.Norwamd9002sData;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.CrudService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.Norwamd9002sDataService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/1 23:57
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@RestController
@RequestMapping(value = "/data/Norwamd9002s")
public class Norwamd9002sDataController extends BaseController<Norwamd9002sData> {

    private final Norwamd9002sDataService norwamd9002sDataService;

    public Norwamd9002sDataController(Norwamd9002sDataService norwamd9002sDataService) {
        this.norwamd9002sDataService = norwamd9002sDataService;
    }

    @Override
    protected CrudService<Norwamd9002sData> getCrudService() {
        return norwamd9002sDataService;
    }
}
