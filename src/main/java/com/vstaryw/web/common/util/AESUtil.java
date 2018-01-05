package com.vstaryw.web.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESUtil {

    static Logger log = LoggerFactory.getLogger(AESUtil.class);

    private static final String CIPHER_ALGORITHM ="AES/CBC/PKCS5Padding";

    public static String encryptData(String encData,String secretKey,String vector){
        if(secretKey == null) {
            return null;
        }
        if(secretKey.length() != 16) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            byte[] raw = secretKey.getBytes();
            SecretKeySpec skeySpec  = new SecretKeySpec(raw, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(vector.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE,skeySpec,ivParameterSpec);
            byte[] bytes = cipher.doFinal(encData.getBytes("utf-8"));
            return Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
           log.error(e.getMessage(),e);
        }
        return null;
    }

    public static String decryptData(String sStr,String key,String ivs){
        try{
            byte[] raw = key.getBytes("ASCII");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            IvParameterSpec iv = new IvParameterSpec(ivs.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = Base64.getDecoder().decode(sStr);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original, "utf-8");
            return originalString;
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
        return null;
    }
}
