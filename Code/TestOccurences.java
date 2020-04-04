package test;
import java.util.Scanner;
import crypto.CasserCryptage;

public class TestOccurences {
    public static void main(String[] args){
        System.out.println("Donner un texte a casser le code:");
        Scanner sc = new Scanner(System.in);
        String texte = sc.nextLine();
        System.out.println(CasserCryptage.casser(texte,4));
    }
}
