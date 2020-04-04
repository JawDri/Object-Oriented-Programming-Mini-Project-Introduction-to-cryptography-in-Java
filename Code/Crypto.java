package crypto; 
 
public class Cle { 
    String substituant; 
    String substitue; 
 
    public Cle(String paramSubstituant, String paramSubstitue) { 
        substituant = paramSubstituant; 
        substitue = paramSubstitue; 
    } 
}
package crypto; 
 
public class Crypto { 
 
    public static String chiffrer(String texte, Cle cle) { 
            StringBuffer texteChiffre = new StringBuffer(); 
            texteChiffre.append(texte); 
            while (texteChiffre.indexOf(cle.substitue) != -1) { 
                int index = texteChiffre.indexOf(cle.substitue); 
                texteChiffre.replace(index, index + 1, cle.substituant); 
            } 
        return texteChiffre.toString(); 
    } 
 
    public static String dechiffrer(String texte, Cle cle) { 
        StringBuffer texteChiffre = new StringBuffer(); 
        texteChiffre.append(texte); 
        while (texteChiffre.indexOf(cle.substituant) != -1) { 
            int index = texteChiffre.indexOf(cle.substituant); 
            texteChiffre.replace(index, index + 1, cle.substitue); 
        } 
 
        return texteChiffre.toString(); 
    } 
} 
