package org.cqu.edu.mrc.campephilus.modules.sys.dataobject;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Vinicolor
 * @date 2018/10/15
 * <p>
 * Description:
 * 角色与菜单对应关系
 */
@Data
@Entity
@Table(name = "sys_role_menu")
public class SysRoleMenuDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name="idGenerator", strategy="uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator="idGenerator")
    private String id;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 菜单ID
     */
    private Long menuId;
}
