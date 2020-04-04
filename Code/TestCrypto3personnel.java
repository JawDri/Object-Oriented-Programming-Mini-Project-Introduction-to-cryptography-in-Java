package test;
import crypto.Crypto3;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

import static crypto.Crypto3.decrypt;
import static crypto.Crypto3.encrypt;

public class TestCrypto3personnel {
    static String plainText = "C'est un exemple de texte à chiffrer en utilisant le standard AES avec une cle de 128, 192 ou 256 bits";

    public static void main(String[] args) throws Exception
    {
        long startTimeTotal = System.currentTimeMillis();

        int longueurDeCle = 256;
        System.out.println("On fait le chiffrement avec une clé à "+longueurDeCle+"bits:");


        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(longueurDeCle);

        //On genere la cle (key)
        SecretKey key = keyGenerator.generateKey();

        // on genere le vecteur d'initialisation IV.
        byte[] IV = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(IV);

        System.out.println("Texte original  : "+plainText);

        long startTimeChiffrement = System.currentTimeMillis();
        byte[] cipherText = encrypt(plainText.getBytes(),key, IV);
        System.out.println("Texte chiffré : "+ Base64.getEncoder().encodeToString(cipherText));
        long endTimeChiffrement = System.currentTimeMillis();


        long startTimeDechiffrement = System.currentTimeMillis();
        String decryptedText = decrypt(cipherText,key, IV);
        System.out.println("Texte déchiffré : "+decryptedText);
        long endTimeDechiffrement = System.currentTimeMillis();

        long endTimeTotal = System.currentTimeMillis();
        long timeElapsedChiffrement = endTimeChiffrement - startTimeChiffrement;
        long timeElapsedDechiffremnt = endTimeDechiffrement - startTimeDechiffrement;
        long timeElapsedTotal = endTimeTotal - startTimeTotal;

        System.out.println("Temps d'execution de chiffrement en millisecondes  : " + timeElapsedChiffrement);
        System.out.println("Temps d'execution de dechiffrement en millisecondes  : " + timeElapsedDechiffremnt);
        System.out.println("Temps d'execution total en millisecondes  : " + timeElapsedTotal);


    }
}
