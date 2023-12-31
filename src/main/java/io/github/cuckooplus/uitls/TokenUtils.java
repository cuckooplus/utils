package io.github.cuckooplus.uitls;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Token工具类
 *
 * @author cuckooing
 * @date 2022/11/21
 */
public class TokenUtils {
    private TokenUtils() {
    }

    ;
    private static final TokenUtils instance = new TokenUtils();

    public static TokenUtils getInstance() {
        return instance;
    }

    /**
     * 生成24位随机Token
     *
     * @return
     */
    public static String makeToken() {
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] = md.digest(token.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}