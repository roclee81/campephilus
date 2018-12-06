package org.cqu.edu.mrc.realdata.common.enums;

import lombok.Getter;

/**
 * @author Vinicolor
 * @date 2018/10/24 16:42
 * <p>
 * Description:
 */
@Getter
public enum MenuTypeEnum {

    /**
     * 目录
     */
    CATALOG(0, "目录"),
    /**
     * 菜单
     */
    MENU(1, "菜单"),
    /**
     * 按钮
     */
    BUTTON(2, "按钮");

    private Integer value;

    private String msg;

    MenuTypeEnum(Integer value, String msg) {
        this.value = value;
        this.msg = msg;
    }


}
