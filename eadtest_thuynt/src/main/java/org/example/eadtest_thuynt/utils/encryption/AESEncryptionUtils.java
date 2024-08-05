package org.example.eadtest_thuynt.utils.encryption;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class AESEncryptionUtils {

    public static SecretKey generateKey(int n) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(n);
        return keyGenerator.generateKey();
    }

    public static byte[] encrypt(String data, String key) throws Exception {
        SecretKeySpec spec = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, spec);
        return cipher.doFinal(data.getBytes());
    }

    public static String decrypt(byte[] data, String key) throws Exception {
        SecretKeySpec spec = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, spec);
        byte[] decrypted = cipher.doFinal(data);
        return new String(decrypted);
    }
}
