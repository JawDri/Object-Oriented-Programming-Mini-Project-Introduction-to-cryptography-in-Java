package crypto;

public class Crypto {

    //La fonction qui fait chiffrer le texte avec des cles composes d'un seul caractere
    public static String chiffrer(String texte, char cle1 , char cle2) {
        StringBuffer texteChiffre = new StringBuffer();
        texteChiffre.append(texte);
        while (texteChiffre.indexOf(String.valueOf(cle1)) != -1) {
            int index = texteChiffre.indexOf(String.valueOf(cle1));
            texteChiffre.replace(index, index + 1, String.valueOf(cle2));
        }
        return texteChiffre.toString();
    }

    //La fonction dechiffrer fait le meme travail mais avec des cles inverses
    public static String dechiffrer(String texte, char cle1 , char cle2) {
        return chiffrer(texte,cle2,cle1);
    }


}