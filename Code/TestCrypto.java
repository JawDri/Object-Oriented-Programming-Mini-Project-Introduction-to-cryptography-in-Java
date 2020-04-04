package test;
/**
 * classe pour tester Crypto
 */
import crypto.Crypto;
import crypto.Cle;
public class TestCrypto {

    public static void main(String[] args) {
        // TODO initialisation des variables pour testv
        // autres valeurs peuvent être utilisées pour la alidation
        String message ="bonjour";
        String messageVide = "";
        String chiffre = null;
        String deChiffre = null;
        Cle cle = new Cle("o", "z");
        Cle cle1 = new Cle('\u0000','z')
        Cle cle2 = new Cle("z", "o");
        

        // TODO Crypto test 1 : permutation simple
        chiffre = Crypto.chiffrer(message, cle);
        System.out.println("chiffré="+chiffre);

        deChiffre = Crypto.dechiffrer(chiffre, cle);
        System.out.println("déchiffré="+deChiffre);

        // verification des résultats

        assert deChiffre.equals("bonjour") & chiffre.equals("obnjbur"):"\n Echec: résultat incorrecte "
                +"\n Raison \t chiffré ==" +chiffre +" & deChiffre == "+deChiffre
                +"\n Attendu\t chiffré ==obnjbur & deChiffre == bonjour ";

        System.out.println("Test 1 terminé avec succes");

        // TODO Crypto test 2 : 
        chiffre = Crypto.chiffrer(message, cle1);
        deChiffre = Crypto.dechiffrer(chiffre, cle1);

        System.out.println("message =" +message +" chiffré =" +chiffre +" & deChiffre ="+deChiffre );
        System.out.println("chiffré="+chiffre);
        System.out.println("déchiffré="+deChiffre);

        assert chiffre.equals(deChiffre): "\n Echec: résultat incorrecte "
                +"\n Raison chiffré ==" +chiffre +" & deChiffre == "+deChiffre
                +"\n Attendu : chiffré ==bonjour & deChiffre == bonjour ";
        System.out.println("Test 2 terminé avec succes");

        // TODO Crypto test 3 : permutation des clés

        chiffre = Crypto.chiffrer(message, cle);
        System.out.println(chiffre);
        deChiffre = Crypto.dechiffrer(chiffre, cle2);
        System.out.println(deChiffre);
        System.out.println("chiffré="+chiffre);
        System.out.println("déchiffré="+deChiffre);
        // verification des résultats

        assert deChiffre.equals("bonjour") & chiffre.equals("obnjbur"):"\n Echec: résultat incorrecte "
                +"\n Raison \t chiffré ==" +chiffre +" & deChiffre == "+deChiffre
                +"\n Attendu\t chiffré ==obnjbur & deChiffre == bonjour ";

        System.out.println("Test 3 terminé avec succes");

        // TODO Crypto test 4 : clé de chiffrement != clé dechiffrement
        //						 ('b','z') 				('b','n')
        Cle cle3 = new Cle("b", "n");
        Cle cle4 = new Cle("b", "z");
        chiffre = Crypto.chiffrer(message, cle3);
        System.out.println(chiffre);
        deChiffre = Crypto.dechiffrer(chiffre, cle4);
        System.out.println(deChiffre);

        // verification des résultats

        assert deChiffre.equals("nozjour") & chiffre.equals("nobjour"):"\n Echec: résultat incorrecte "
                +"\n Raison \t chiffré ==" +chiffre +" & deChiffre == "+deChiffre
                +"\n Attendu\t chiffré ==nozjour & deChiffre == nozjour ";
        // fin de test
        System.out.println("chiffré="+chiffre);
        System.out.println("déchiffré="+deChiffre);
        System.out.println("Les test sont terminés avec succes");
    }

}
