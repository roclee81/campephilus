package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.data;

import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.BaseController;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.data.PearlcareYy106Data;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.CrudService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.PearlcareYy106DataService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/1 23:58
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@RestController
@RequestMapping(value = "/data/PearlcareYy106")
public class PearlcareYy106DataController extends BaseController<PearlcareYy106Data> {

    private final PearlcareYy106DataService pearlcareYy106DataService;

    public PearlcareYy106DataController(PearlcareYy106DataService pearlcareYy106DataService) {
        this.pearlcareYy106DataService = pearlcareYy106DataService;
    }

    @Override
    protected CrudService<PearlcareYy106Data> getCrudService() {
        return pearlcareYy106DataService;
    }
}
