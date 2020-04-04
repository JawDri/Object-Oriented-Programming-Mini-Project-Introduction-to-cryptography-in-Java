package crypto; 
 
public class Crypto2 { 
 
    public static String chiffrer(String texte, Cle cle) { 
        StringBuffer texteChiffre = new StringBuffer(); 
        texteChiffre.append(texte); 
        for (int i = 0 ; i < cle.substituant.length() ; i ++ ){ 
            while (texteChiffre.indexOf(String.valueOf(cle.substitue.charAt(i))) != -1) { 
                int index = texteChiffre.indexOf(String.valueOf(cle.substitue.charAt(i))); 
                texteChiffre.replace(index, index + 1, String.valueOf(cle.substituant.charAt(i))); 
            } 
        } 
        return texteChiffre.toString(); 
    } 
 
    public static String dechiffrer(String texte, Cle cle) { 
        StringBuffer texteChiffre = new StringBuffer(); 
        texteChiffre.append(texte); 
        for (int i = 0 ; i < cle.substituant.length() ; i ++ ){ 
            while (texteChiffre.indexOf(String.valueOf(cle.substituant.charAt(i))) != -1) { 
                int index = texteChiffre.indexOf(String.valueOf(cle.substituant.charAt(i))); 
                texteChiffre.replace(index, index + 1, String.valueOf(cle.substitue.charAt(i))); 
            } 
        } 
        return texteChiffre.toString(); 
    } 
 
} 
