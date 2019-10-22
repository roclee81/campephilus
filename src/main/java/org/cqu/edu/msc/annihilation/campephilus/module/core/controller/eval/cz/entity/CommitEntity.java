package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.eval.cz.entity;

import javax.validation.constraints.NotNull;

import lombok.Data;


/**
 * 提交实体
 * @author cz
 */
@Data
public class CommitEntity {

    @NotNull(message = "code不能为空")
    private int code;

    @NotNull(message = "data不能为空")
    private String data;
}



