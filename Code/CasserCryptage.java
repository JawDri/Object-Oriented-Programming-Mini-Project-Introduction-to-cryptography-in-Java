package crypto;

import java.util.ArrayList;
import java.util.*;

public class CasserCryptage {
    public static String casser(String texte, int degre) {

        //on prepare deux listes
        //tabchar contient les caracteres qui existent dans le texte
        //et la liste taboccurences contient les occurences respectives
        ArrayList<Character> tabchar = new ArrayList<>();
        ArrayList<Integer> taboccurences = new ArrayList<>();
        int indexCaract;


        //on fait remplir les deux tableaux
        for (int i = 0; i < texte.length(); i++) {
            char caractere = texte.charAt(i);
            if (caractere!=' ') {
                if (!tabchar.contains(caractere)) {
                    tabchar.add(texte.charAt(i));
                    taboccurences.add(0);
                }
                indexCaract=tabchar.indexOf(caractere);
                taboccurences.set(indexCaract,taboccurences.get(indexCaract)+1);
            }
        }


        //on visualise les deux tableaux avant le tri
        System.out.println(tabchar);
        System.out.println(taboccurences);


        //on fait le tri des deux tableaux a la fois
        int n = tabchar.size();
        for (int i = 0; i < n-1; i++) {
            int max_idx = i;
            for (int j = i+1; j < n; j++) {
                if (taboccurences.get(j) > taboccurences.get(max_idx))
                    max_idx = j;
            }
            Collections.swap(tabchar,i,max_idx);
            Collections.swap(taboccurences,i ,max_idx);
        }


        //on prepare une liste qui contient les lettres de l'alphabet les plus frequentes (dans l'ordre)
        char []lettresLesPlusUtilisees = {'e','a','s','i','n','t','r','l','u','o','d','c','p','m','v','g','f','b','q','h','x','j','y','z','k','w'};


        //on verifie que les deux tableaux sont triés maintenant
        System.out.println(tabchar);
        System.out.println(taboccurences);


        //maintenant on utilise la methode chiffrer pour casser le code
        String texteChiffre = texte;
        for (int i = 0 ; i<degre ; i++){
            texteChiffre= Crypto.chiffrer(texteChiffre,lettresLesPlusUtilisees[i],tabchar.get(i));
        }
        return texteChiffre;
    }
}