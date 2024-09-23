package com.tech.playbook.crypto.keys;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class CryptoOperation {

    public static String encrypt(String plainText, SecretKey secretKey) throws
            NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] bytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static String decrypt(String cipherText, SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedBytes = Base64.getDecoder().decode(cipherText);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }

    public static void main(String[] args) throws Exception {
        SecretKey secretKey = KeyGeneratorHelper.generateKey();
        System.out.println(secretKey.getAlgorithm());
        String encrypt = encrypt("tech-playbook-hub", secretKey);
        System.out.println(encrypt);
        String decrypt = decrypt(encrypt, secretKey);
        System.out.println(decrypt);
    }
}
