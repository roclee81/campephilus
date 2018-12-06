package org.cqu.edu.mrc.realdata.modules.sys.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Vinicolor
 * @date 2018/10/12
 * <p>
 * Description:
 * System verification code
 */
@Entity
@Data
@Table(name = "sys_captcha")
public class SysCaptchaDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String uuid;

    /**
     * Verification code
     */
    private String code;

    /**
     * 过期时间
     */
    private Date expireTime;

}
