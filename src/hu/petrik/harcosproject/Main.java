package hu.petrik.harcosproject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Bejegyzes> bejegyzesek;

    public static void main(String[] args) {
        bejegyzesek = new ArrayList<>();
        hozzaAd("Joe Doe", "Lorem Ipsum");
        hozzaAd("Jane Doe", "asd");
    }

    public static void hozzaAd(String szerzo, String tartalom) {
        Bejegyzes b = new Bejegyzes(szerzo, tartalom);
        bejegyzesek.add(b);
    }
}
