package primer06_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static void ispisi(List<Pesma> pesme) {
        for (Pesma pesma : pesme) {
            System.out.println(pesma.opis());
        }
    }

    public static void main(String[] args) {
        List<Pesma> pesme = new ArrayList<>();

        pesme.add(new Pesma("Numb", "Linkin Park", 185));
        pesme.add(new Pesma("Take Five", "Dave Brubeck", 324));
        pesme.add(new Pesma("Africa", "Toto", 295));

        /*
         * Prirodni poredak iz Comparable.
         */
        Collections.sort(pesme);

        System.out.println("--- prirodni poredak ---");
        ispisi(pesme);

        /*
         * Alternativni poredak prosleđujemo algoritmu sortiranja.
         * Comparator je Strategy za poređenje.
         */
        Collections.sort(pesme, new PoredjenjePoTrajanju());

        System.out.println("--- po trajanju ---");
        ispisi(pesme);

        Collections.sort(pesme, new PoredjenjePoIzvodjacu());

        System.out.println("--- po izvođaču ---");
        ispisi(pesme);
    }
}
