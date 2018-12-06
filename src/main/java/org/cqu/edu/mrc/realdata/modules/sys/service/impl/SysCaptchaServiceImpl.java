package org.cqu.edu.mrc.realdata.modules.sys.service.impl;

import org.cqu.edu.mrc.realdata.modules.sys.dataobject.SysCaptchaDO;
import org.cqu.edu.mrc.realdata.modules.sys.repository.SysCaptchaRepository;
import org.cqu.edu.mrc.realdata.modules.sys.service.SysCaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.Optional;

/**
 * @author Vinicolor
 * @date 2018/10/15
 * <p>
 * Description:
 */
@Service
public class SysCaptchaServiceImpl implements SysCaptchaService {

//    private final Producer producer;

    private final SysCaptchaRepository sysCaptchaRepository;

    @Autowired
    public SysCaptchaServiceImpl(SysCaptchaRepository sysCaptchaRepository) {
//        this.producer = producer;
        this.sysCaptchaRepository = sysCaptchaRepository;
    }

    @Override
    public BufferedImage getCaptcha(String uuid) {
//        if (StringUtils.isBlank(uuid)) {
//            throw new OAuthException("uuid不能为空");
//        }
//        // 生成文字校验码
//        String code = producer.createText();
//
//        //5分钟后过期
//        SysCaptchaDO sysCaptchaEntity = new SysCaptchaDO(uuid, code, DateUtils.addDateMinutes(new Date(), 5));
//        sysCaptchaRepository.save(sysCaptchaEntity);
//
//        return producer.createImage(code);
        return null;
    }

    @Override
    public boolean validate(String uuid, String code) {
        Optional<SysCaptchaDO> optionalSysCaptchaEntity = sysCaptchaRepository.findById(uuid);
        if (!optionalSysCaptchaEntity.isPresent()) {
            return false;
        }

        // 删除验证码
        sysCaptchaRepository.deleteById(uuid);

        SysCaptchaDO sysCaptchaDO = optionalSysCaptchaEntity.get();

        return sysCaptchaDO.getCode().equalsIgnoreCase(code) && sysCaptchaDO.getExpireTime().getTime() >= System.currentTimeMillis();
    }
}
