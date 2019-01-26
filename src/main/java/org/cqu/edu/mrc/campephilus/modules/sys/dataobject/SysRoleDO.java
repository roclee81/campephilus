package org.cqu.edu.mrc.campephilus.modules.sys.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Vinicolor
 * @date 2018/10/11
 * <p>
 * Description:
 */
@Data
@Entity
@Table(name = "sys_role")
public class SysRoleDO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 角色ID
     */
    @Id
    private Long roleId;

    /**
     * 角色名称
     */
    @NotBlank(message = "角色名称不能为空")
    private String roleName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建者ID
     */
    private Long createUserId;

    @Transient
    private List<Long> menuIdList;

    /**
     * 创建时间
     */
    private Date createTime;
}
