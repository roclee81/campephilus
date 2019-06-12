package org.cqu.edu.msc.annihilation.campephilus.module.core.controller;

import org.cqu.edu.msc.annihilation.campephilus.module.core.service.CrudService;
import org.cqu.edu.msc.annihilation.campephilus.utils.ControllerCrudUtils;
import org.cqu.edu.msc.annihilation.common.utils.BindingResultUtils;
import org.cqu.edu.msc.annihilation.common.utils.ResultVOUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/1 0:28
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public abstract class BaseController<T> {

    protected abstract CrudService<T> getCrudService();

    @GetMapping("")
    ResultVOUtils list(@RequestParam(value = "page", defaultValue = "0") int page,
                       @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerCrudUtils.listAll(getCrudService().listAll(page, size));
    }

    @PostMapping("")
    ResultVOUtils save(@Valid T t, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerCrudUtils.save(getCrudService(), t);
    }

    @PutMapping("")
    ResultVOUtils update(@Valid T t, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerCrudUtils.update(getCrudService(), t);
    }

    @DeleteMapping("")
    ResultVOUtils delete(@Valid T t, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerCrudUtils.delete(getCrudService(), t);
    }
}
