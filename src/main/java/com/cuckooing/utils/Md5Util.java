package com.cuckooing.utils;

import java.security.MessageDigest;

/**
 * MD5工具类
 *
 * @author cuckooing
 * @date 2022/11/21
 */
public class Md5Util {
    private static final String[] hexDigits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public Md5Util() {
    }

    public static String getMD5(String message) {
        String md5 = "";

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageByte = message.getBytes("UTF-8");
            byte[] md5Byte = md.digest(messageByte);
            md5 = bytesToHex(md5Byte).toLowerCase();
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return md5;
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuffer hexStr = new StringBuffer();

        for (int i = 0; i < bytes.length; ++i) {
            int num = bytes[i];
            if (num < 0) {
                num += 256;
            }

            if (num < 16) {
                hexStr.append("0");
            }

            hexStr.append(Integer.toHexString(num));
        }

        return hexStr.toString().toUpperCase();
    }

    public static String MD5Encode(String origin, String charsetName) {
        String resultString = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetName != null && !"".equals(charsetName)) {
                resultString = byteArrayToHexString(md.digest(origin.getBytes(charsetName)));
            } else {
                resultString = byteArrayToHexString(md.digest(origin.getBytes()));
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return resultString;
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuilder resultSb = new StringBuilder();

        for (int i = 0; i < b.length; ++i) {
            resultSb.append(byteToHexString(b[i]));
        }

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (b < 0) {
            n = b + 256;
        }

        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }
}
