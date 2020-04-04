package crypto;

public class Crypto2 {

    //fonction chiffrer qui parcourt les cles et fait un travail similaire que dans crypto
    public static String chiffrer(String texte, String cle1, String cle2) {
        StringBuffer texteChiffre = new StringBuffer();
        texteChiffre.append(texte);
        if (cle1==cle2){//si les deux cles sont identiques alors pas besoin de faire le parcours
            return texte;
        }else{
            for (int i = 0; i < cle2.length(); i++) {
                while (texteChiffre.indexOf(String.valueOf(cle1.charAt(i))) != -1) {
                    int index = texteChiffre.indexOf(String.valueOf(cle1.charAt(i)));
                    texteChiffre.replace(index, index + 1, String.valueOf(cle2.charAt(i)));
                }
            }
        }

        return texteChiffre.toString();
    }
//De meme, dechiffrer fait le meme travail mais avec des cles inverses
    public static String dechiffrer(String texte, String cle1, String cle2) {
        return chiffrer(texte, cle2, cle1);
    }
}
