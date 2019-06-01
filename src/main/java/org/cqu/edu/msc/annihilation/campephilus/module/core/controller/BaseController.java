package org.cqu.edu.msc.annihilation.campephilus.module.core.controller;

import org.cqu.edu.msc.annihilation.common.utils.BindingResultUtils;
import org.cqu.edu.msc.annihilation.common.utils.ControllerCrudUtils;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.CrudService;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity list(@RequestParam(value = "page", defaultValue = "0") int page,
                        @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerCrudUtils.listAllResponseEntity(getCrudService().listAll(page, size));
    }

    @PostMapping("")
    ResponseEntity save(@Valid T t, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerCrudUtils.saveResponseEntity(getCrudService(), t);
    }

    @PutMapping("")
    ResponseEntity update(@Valid T t, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerCrudUtils.updateResponseEntity(getCrudService(), t);
    }

    @DeleteMapping("")
    ResponseEntity delete(@Valid T t, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerCrudUtils.deleteResponseEntity(getCrudService(), t);
    }
}
