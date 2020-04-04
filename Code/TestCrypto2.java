package test;
/**
 * classe pour tester Crypto2
 */
import crypto.Crypto;
import crypto.Crypto2;

public class TestCrypto2 {

    public static void main(String[] args) {



        // TODO initialisation des variables pour testv
        // autres valeurs peuvent être utilisées pour la alidation
        String message ="Le dirigeant nord-coréen Kim Jong Un a pris mercredi matin le chemin de la Sibérie pour participer à son premier sommet avec le président russe Vladimir Poutine, a annoncé l'agence officielle nord-coréenne KCNA.";
        message ="Le dirigeant nord-coréen Kim Jong";

        String ch1= "azi";
        String ch2= "efc";
        String chiffre = null;
        String deChiffre = null;


        // TODO Crypto2 Test 1 : permutation simple
        System.out.println(" -- Test 1 ---");
        chiffre = Crypto2.chiffrer(message, ch1,ch2);
        deChiffre = Crypto2.dechiffrer(chiffre, ch1,ch2);

        System.out.println(" message: 	"+ message);
        System.out.println(" chiffre: 	"+ chiffre);
        System.out.println(" deChiffre:	"+ deChiffre);
        // verification des résultats

        assert deChiffre.equals(message) & !(chiffre.equals(message)) :"\n Echec Crypto2 Test 1: résultat incorrecte "
                +"\n Raison : la condition (deChiffre == message  et chiffre != message)est faux";

        System.out.println("Test 1 terminé avec succes");

        // TODO Crypto Test 2 : ch1 == ch2
        System.out.println(" -- Test 2 ---");
        chiffre = Crypto2.chiffrer(message, ch1,ch1);
        deChiffre = Crypto2.dechiffrer(chiffre, ch1 , ch1);

        //chiffre ="La dirigaent nord-ioréan Kcm Jong";
        System.out.println(" message: 	"+ message);
        System.out.println(" chiffre: 	"+ chiffre);
        System.out.println(" deChiffre:	"+ deChiffre);
        // verification des résultats

        assert deChiffre.equals(message) & chiffre.equals(message): "\n Echec Crypto2 Test 2: résultat incorrecte "
                +"\n Raison Si ch1==ch2 alors message = chiffré = deChiffre ";

        System.out.println("Test 2 terminé avec succes");

        // TODO Crypto Test 3 : permutation des clés

        System.out.println(" -- Test 3 ---");
        chiffre = Crypto2.chiffrer(message, ch1,ch2);
        deChiffre = Crypto2.dechiffrer(chiffre, ch2 , ch1);


        chiffre ="La dirigaent nord-ioréan Kcm Jong";
        System.out.println(" message: 	"+ message);
        System.out.println(" chiffre: 	"+ chiffre);
        System.out.println(" deChiffre:	"+ deChiffre);
        // verification des résultats
        assert deChiffre.equals(message) & !(chiffre.equals(deChiffre )): "\n Echec Crypto2 Test 3: résultat incorrecte  "
                +"\n Raison : la condition (deChiffre == message  et chiffre != message)est faux";

        System.out.println("Test 3 terminé avec succes");



        System.out.println("Les test sont terminés avec succes");
        // calculer le temps pour chiffrer et déchiffre
        performanceTest() ;

    }

    public static void performanceTest() {
        String [] texte = new String[6];
        texte[0] = "Un chiffre de transposition consiste à changer l'ordre des lettres, donc à construire des anagrammes. Cette méthode est connue depuis l'Antiquité, puisque les Spartes utilisaient déjà une scytale.";

        texte[1] ="Une analyse statistique sur les chiffrements par transposition n'est pas utile, puisque seul l'ordre des symboles est différent; les symboles restent les mêmes. Donc, les symboles les plus fréquents dans le message clair resteront évidemment les plus fréquents dans le message chiffré.";

        texte[2] ="Pour de très brefs messages, comme un simple mot, cette méthode est peu sûre car il n'y a guère de variantes pour redistribuer une poignée de lettres.";

        texte[3] ="Par exemple un mot de trois lettres ne peut être tourné quand dans 6 (=3!) positions différentes. Ainsi col ne peut se transformer qu'en col, clo, ocl, olc, lco ou loc.";

        texte[4] ="Bien entendu, lorsque le nombre de lettres croît, le nombre d'arrangements augmente rapidement et il devient quasiment impossible de retrouver le texte original sans connaître le procédé de brouillage.";

        texte[5] ="Par exemple, les 27 lettres du message ci-contre, tiré du tome 17 de la série XIII, L'or de Maximilien (Ed. Dargaud), peuvent être disposées de 27! = 10'888'869'450'418'352'160'768'000'000 manières. Ce message est d'ailleurs surchiffré, puis qu'il est écrit dans une langue rare.";
        String ch1= "abi";
        String ch2= "efc";
        String chiffre = null;
        String deChiffre = null;
        long startTime = System.currentTimeMillis();
        for (String message : texte) {
            chiffre = Crypto2.chiffrer(message, ch1,ch2);
            deChiffre = Crypto2.dechiffrer(chiffre, ch1,ch2);
        }
        long endTime = System.currentTimeMillis();
        System.out.println ( "temps pour le chiffement +déchiffremnt = "+ (endTime - startTime) +" ms");

    }

}
