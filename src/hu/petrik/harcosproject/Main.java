package hu.petrik.harcosproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        try {
            readFromFile("bejegyzesek.csv");
        } catch (FileNotFoundException e) {
            System.err.println("A fájl nem létezik!");
        } catch (IOException e) {
            System.err.println("IOExeption hiba!");
        }
    }

    public static void hozzaAd(String szerzo, String tartalom) {
        Bejegyzes b = new Bejegyzes(szerzo, tartalom);
        bejegyzesek.add(b);
    }

    public static void userInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Adja meg hány bejegyzés szeretne létrehozni:");
        int numOfItems = sc.nextInt();
        sc.nextLine();
        if (numOfItems >= 0) {
            for (int i = 0; i < numOfItems; i++) {
                System.out.printf("\nAdja meg a(z) %d. szerzőt: ", i + 1);
                String szerzo = sc.nextLine();
                System.out.printf("\nAdja meg a(z) %d. bejegyzést: ", i + 1);
                String tartalom = sc.nextLine();
                hozzaAd(szerzo, tartalom);
            }
        } else {
            System.err.println("Nem természetes számot adott meg!");
        }

        sc.close();
    }

    public static void readFromFile(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while (line != null && line.equals("")) {
            String[] tmp = line.split(";");
            hozzaAd(tmp[0], tmp[1]);
            line = br.readLine();
        }
        br.close();
        fr.close();
    }
}
