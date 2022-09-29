package hu.petrik.harcosproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static List<Bejegyzes> bejegyzesek;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        bejegyzesek = new ArrayList<>();
        hozzaAd("Joe Doe", "Lorem Ipsum");
        hozzaAd("Jane Doe", "asd");
        userInput();
        try {
            readFromFile("bejegyzesek.csv");
        } catch (FileNotFoundException e) {
            System.err.println("A fájl nem létezik!");
        } catch (IOException e) {
            System.err.println("IOExeption hiba!");
        }
        randomLike();
        edit();
        for (Bejegyzes b : bejegyzesek) {
            System.out.println(b);
        }
        mostLiked();
    }

    public static void hozzaAd(String szerzo, String tartalom) {
        Bejegyzes b = new Bejegyzes(szerzo, tartalom);
        bejegyzesek.add(b);
    }

    public static void userInput() {
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
    }

    public static void readFromFile(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while (line != null) {
            String[] tmp = line.split(";");
            hozzaAd(tmp[0], tmp[1]);
            line = br.readLine();
        }
        br.close();
        fr.close();
    }

    public static void randomLike() {
        Random rnd = new Random();
        for (int i = 0; i < (bejegyzesek.size() * 20); i++) {
            bejegyzesek.get(rnd.nextInt(bejegyzesek.size())).like();
        }
    }

    public static void edit() {
        System.out.println("Adja meg a szöveget amire változtatni szeretné a második bejegyzést:");
        String line = sc.nextLine();
        bejegyzesek.get(1).setTartalom(line);
    }

    public static void mostLiked() {
        int index = 0;
        for (int i = 0; i < bejegyzesek.size(); i++) {
            if (bejegyzesek.get(index).getLikeok() < bejegyzesek.get(i).getLikeok()) {
                index = i;
            }
        }
        System.out.println("A legtöbb like:" + bejegyzesek.get(index).getLikeok());
    }
}
