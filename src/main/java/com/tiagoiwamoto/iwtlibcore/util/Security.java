package com.tiagoiwamoto.iwtlibcore.util;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 17/02/2021 - 14:31
*/

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.Serial;
import java.io.Serializable;
import java.security.spec.KeySpec;
import java.util.Base64;

public class Security implements Serializable {

    @Serial
    private static final long serialVersionUID = -2827476958104486431L;
    Logger log = LogManager.getLogger(Security.class.getName());

    private static final String secretKey = "boooooooooom!!!!";
    private static final String salt = "ssshhhhhhhhhhh!!!!";
    private static final byte ZERO_VALUE = 0;
    private static final String AES_CBC_PKC = "AES/CBC/PKCS5Padding";

    /**
     * Encrypt a value using AES
     * @param strToEncrypt is the value to be protect
     * @param secret is the key to lock
     * @return a string value protected
     */
    public String encrypt(String strToEncrypt, String secret) {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance(AES_CBC_PKC);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, this.getIvParameterSpec());
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            log.error("Error while encrypting: ".concat(e.toString()));
            return null;
        }
    }

    /**
     * Encrypt a value using AES
     * @param strToDecrypt is the value to be decripted
     * @param secret is the key to unlock
     * @return a string value decripted
     */
    public String decrypt(String strToDecrypt, String secret) {
        try {

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(secret.toCharArray(), salt.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance(AES_CBC_PKC);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, this.getIvParameterSpec());
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            log.error("Error while decrypting: ".concat(e.toString()));
            return null;
        }
    }

    private byte[] getIV(){
        byte[] iv = { ZERO_VALUE, ZERO_VALUE, ZERO_VALUE, ZERO_VALUE, ZERO_VALUE,
                ZERO_VALUE, ZERO_VALUE, ZERO_VALUE, ZERO_VALUE, ZERO_VALUE, ZERO_VALUE,
                ZERO_VALUE, ZERO_VALUE, ZERO_VALUE, ZERO_VALUE, ZERO_VALUE };
        return iv;
    }

    private IvParameterSpec getIvParameterSpec(){
        return new IvParameterSpec(this.getIV());
    }
}
