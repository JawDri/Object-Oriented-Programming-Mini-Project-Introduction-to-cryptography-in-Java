package crypto;

import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Crypto3
{

    public static byte[] encrypt (byte[] plaintext,SecretKey key,byte[] IV ) throws Exception
    {
        //On apporte une instance de Cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        //On cree la cle SecretKeySpec
        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");

        //On cree IvParameterSpec
        IvParameterSpec ivSpec = new IvParameterSpec(IV);

        //On initialize Cipher pour ENCRYPT_MODE
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

        //On fait l'Encryption
        byte[] cipherText = cipher.doFinal(plaintext);

        return cipherText;
    }

    public static String decrypt (byte[] cipherText, SecretKey key,byte[] IV) throws Exception
    {
        //On apporte une instance de Cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        //On cree la cle SecretKeySpec
        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");

        //On cree IvParameterSpec
        IvParameterSpec ivSpec = new IvParameterSpec(IV);

        //On initialize Cipher pour ENCRYPT_MODE
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

        //On fait l'Encryption
        byte[] decryptedText = cipher.doFinal(cipherText);

        return new String(decryptedText);
    }
}