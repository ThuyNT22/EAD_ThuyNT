package org.example.eadtest_thuynt.utils.encryption;

import java.security.MessageDigest;

public class ShaEncryptionUtils {

    public static String hashString(String data, String algorithm) throws Exception {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        byte[] hash = digest.digest(data.getBytes("UTF-8"));
        return bytesToHex(hash);
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
