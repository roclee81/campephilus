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
 * @date 2018/10/11
 * <p>
 * Description:
 * 用户与角色对应关系
 */
@Data
@Entity
@Table(name = "sys_user_role")
public class SysUserRoleDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    /**
     * 这个是hibernate的注解/生成32位UUID
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;


}
