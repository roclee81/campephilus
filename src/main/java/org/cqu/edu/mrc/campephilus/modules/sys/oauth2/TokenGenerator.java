package org.cqu.edu.mrc.campephilus.modules.sys.oauth2;


import org.cqu.edu.mrc.campephilus.common.exception.OAuthException;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * @author Vinicolor
 * @date 2018/10/12
 * <p>
 * Description:
 * token生成
 */
public class TokenGenerator {

    public static String generateValue() {
        return generateValue(UUID.randomUUID().toString());
    }

    private static final char[] HEX_CODE = "0123456789abcdef".toCharArray();

    private static String toHexString(byte[] data) {
        if (data == null) {
            return null;
        }
        StringBuilder r = new StringBuilder(data.length * 2);
        for (byte b : data) {
            r.append(HEX_CODE[(b >> 4) & 0xF]);
            r.append(HEX_CODE[(b & 0xF)]);
        }
        return r.toString();
    }

    private static String generateValue(String param) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(param.getBytes());
            byte[] messageDigest = algorithm.digest();
            return toHexString(messageDigest);
        } catch (Exception e) {
            throw new OAuthException("生成Token失败", e);
        }
    }



}
