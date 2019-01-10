package org.cqu.edu.mrc.realdata.modules.sys.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.cqu.edu.mrc.realdata.common.enums.MenuTypeEnum;
import org.cqu.edu.mrc.realdata.common.exception.OAuthException;
import org.cqu.edu.mrc.realdata.common.utils.R;
import org.cqu.edu.mrc.realdata.modules.sys.dataobject.SysMenuDO;
import org.cqu.edu.mrc.realdata.modules.sys.service.ShiroService;
import org.cqu.edu.mrc.realdata.modules.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author Vinicolor
 * @date 2018/10/18 13:50
 * <p>
 * Description:
 * 系统菜单
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends AbstractController {

    private final SysMenuService sysMenuService;

    private final ShiroService shiroService;

    @Autowired
    public SysMenuController(SysMenuService sysMenuService, ShiroService shiroService) {
        this.sysMenuService = sysMenuService;
        this.shiroService = shiroService;
    }

    /**
     * 导航菜单，前端初始化时将需要显示的部分发送，前端生成权限
     *
     * @return R
     */
    @GetMapping("/nav")
    public R nav() {
        List menuList = sysMenuService.listSysMenuByUserId(getUserId());
        Set<String> permissions = shiroService.getUserPermissionsByUserId(getUserId());
        return Objects.requireNonNull(R.success().put("menuList", menuList)).put("permissions", permissions);
    }


    /**
     * 所有菜单列表
     */
    @GetMapping("/list")
    @RequiresPermissions("sys:menu:list")
    public List<SysMenuDO> list() {
        List<SysMenuDO> menuList = sysMenuService.listSysMenus();
        // 设置父菜单的名字
        for (SysMenuDO sysMenuDO : menuList) {
            // 通过子菜单sysMenuDO的父菜单parentId，即MenuId为parentId，即得到父菜单了
            SysMenuDO parentSysMenuDO = sysMenuService.getSysMenuByMenuId(sysMenuDO.getParentId());
            if (parentSysMenuDO != null) {
                sysMenuDO.setParentName(parentSysMenuDO.getName());
            }
        }

        return menuList;
    }

    // TODO 未知方法
//    /**
//     * 择菜单(添加、修改菜单)
//     *
//     * @return
//     */
//    @GetMapping("/select")
//    @RequiresPermissions("sys:menu:select")
//    public R select() {
//        // 查询列表数据
//        List<SysMenuDO> menuList = sysMenuService.queryNotButtonList();
//
//        // 添加顶级菜单
//        SysMenuDO root = new SysMenuDO();
//        root.setMenuId(0L);
//        root.setName("一级菜单");
//        root.setParentId(-1L);
//        root.setOpen(true);
//        menuList.add(root);
//
//        return R.success().put("menuList", menuList);
//    }


    /**
     * 菜单信息
     *
     * @param menuId
     * @return
     */
    @GetMapping("/info/{menuId}")
    @RequiresPermissions("sys:menu:info")
    public R info(@PathVariable("menuId") Long menuId) {
        SysMenuDO menu = sysMenuService.getSysMenuByMenuId(menuId);
        return R.success().put("menu", menu);
    }

    /**
     * 保存
     *
     * @param menu
     * @return
     */
//    @SysLog("保存菜单")
    @PostMapping("/save")
    @RequiresPermissions("sys:menu:save")
    public R save(@RequestBody SysMenuDO menu) {
        // 数据校验
        verifyForm(menu);

        sysMenuService.save(menu);

        return R.success();
    }

    /**
     * 修改
     *
     * @param menu
     * @return
     */
//    @SysLog("修改菜单")
    @PostMapping("/update")
    @RequiresPermissions("sys:menu:update")
    public R update(@RequestBody SysMenuDO menu) {
        // 数据校验
        verifyForm(menu);

        sysMenuService.save(menu);

        return R.success();
    }


    /**
     * 删除
     *
     * @param menuId
     * @return
     */
//    @SysLog("删除菜单")
    @PostMapping("/delete/{menuId}")
    @RequiresPermissions("sys:menu:delete")
    public R delete(@PathVariable("menuId") long menuId) {
        if (menuId < 31) {
            return R.error("系统菜单，不能删除");
        }

        // 判断是否有子菜单或按钮
        List<SysMenuDO> menuList = sysMenuService.listSysMenusByParentId(menuId);
        if (menuList.size() > 0) {
            return R.error("请先删除子菜单或按钮");
        }

        sysMenuService.deleteSysMenuByMenuId(menuId);

        return R.success();
    }

    /**
     * 验证参数是否正确
     *
     * @param menu
     */
    private void verifyForm(SysMenuDO menu) {
        if (StringUtils.isBlank(menu.getName())) {
            throw new OAuthException("菜单名称不能为空");
        }

        if (menu.getParentId() == null) {
            throw new OAuthException("上级菜单不能为空");
        }

        // 菜单
        if (menu.getType().equals(MenuTypeEnum.MENU.getValue())) {
            if (StringUtils.isBlank(menu.getUrl())) {
                throw new OAuthException("菜单URL不能为空");
            }
        }

        // 上级菜单类型
        int parentType = MenuTypeEnum.CATALOG.getValue();
        if (menu.getParentId() != 0) {
            SysMenuDO parentSysMenuDO = sysMenuService.getSysMenuByMenuId(menu.getParentId());
            parentType = parentSysMenuDO.getType();
        }

        // 目录、菜单
        if (menu.getType().equals(MenuTypeEnum.CATALOG.getValue()) ||
                menu.getType().equals(MenuTypeEnum.MENU.getValue())) {
            if (parentType != MenuTypeEnum.CATALOG.getValue()) {
                throw new OAuthException("上级菜单只能为目录类型");
            }
            return;
        }

        // 按钮
        if (menu.getType().equals(MenuTypeEnum.BUTTON.getValue())) {
            if (parentType != MenuTypeEnum.MENU.getValue()) {
                throw new OAuthException("上级菜单只能为菜单类型");
            }
            return;
        }
    }
}
