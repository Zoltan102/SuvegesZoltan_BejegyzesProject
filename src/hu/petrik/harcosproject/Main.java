package hu.petrik.harcosproject;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Bejegyzes> bejegyzesek;

    public static void main(String[] args) {
        bejegyzesek = new ArrayList<>();
        hozzaAd("Joe Doe", "Lorem Ipsum");
        hozzaAd("Jane Doe", "asd");
        userInput();
        for (Bejegyzes b : bejegyzesek) {
            System.out.println(b);
        }
    }

    public static void hozzaAd(String szerzo, String tartalom) {
        Bejegyzes b = new Bejegyzes(szerzo, tartalom);
        bejegyzesek.add(b);
    }

    public static void userInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Adja meg hány bejegyzés szeretne létrehozni:");
        int numOfItem = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numOfItem; i++) {
            System.out.printf("\nAdja meg a(z) %d. szerzőt: ", i + 1);
            String szerzo = sc.nextLine();
            System.out.printf("\nAdja meg a(z) %d. bejegyzést: ", i + 1);
            String tartalom = sc.nextLine();
            hozzaAd(szerzo, tartalom);
        }
    }
}
