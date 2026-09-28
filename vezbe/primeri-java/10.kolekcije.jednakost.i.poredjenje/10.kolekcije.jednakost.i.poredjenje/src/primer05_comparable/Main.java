package primer05_comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        List<Pesma> pesme = new ArrayList<>();

        pesme.add(new Pesma("Numb", "Linkin Park"));
        pesme.add(new Pesma("Take Five", "Dave Brubeck"));
        pesme.add(new Pesma("Africa", "Toto"));
        pesme.add(new Pesma("Numb", "Drugi izvođač"));

        Collections.sort(pesme);

        System.out.println("Sortirana lista:");
        for (Pesma pesma : pesme) {
            System.out.println(pesma.opis());
        }

        /*
         * TreeSet takođe koristi poredak da održava elemente uređenim.
         */
        Set<Pesma> uredjene = new TreeSet<>(pesme);

        System.out.println("--- TreeSet ---");
        for (Pesma pesma : uredjene) {
            System.out.println(pesma.opis());
        }
    }
}
