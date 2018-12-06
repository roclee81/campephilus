package org.cqu.edu.mrc.realdata.modules.sys.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 *
 * @author Vinicolor
 * @date 2018/10/11
 * <p>
 * Description:
 * 系统用户Token
 */
@Data
@Entity
@Table(name = "sys_user_token")
public class SysUserTokenDO {

    /**
     * 用户ID
     */
    @Id
    private Long userId;

    /**
     * token
     */
    private String token;

    /**
     * 过期时间
     */
    private Date expireTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public SysUserTokenDO() {
    }

    public SysUserTokenDO(Long userId, String token, Date expireTime, Date updateTime) {
        this.userId = userId;
        this.token = token;
        this.expireTime = expireTime;
        this.updateTime = updateTime;
    }
}
