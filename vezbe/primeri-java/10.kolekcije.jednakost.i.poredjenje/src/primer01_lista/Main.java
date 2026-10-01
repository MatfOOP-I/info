package primer01_lista;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
         * Promenljiva je tipa interfejsa List.
         * Konkretna implementacija koju biramo je ArrayList.
         */
        List<Pesma> plejlista = new ArrayList<>();

        Pesma numb =
                new Pesma("Numb", "Linkin Park", 185, Zanr.ROCK);

        plejlista.add(numb);
        plejlista.add(
                new Pesma("Take Five", "Dave Brubeck", 324, Zanr.JAZZ)
        );

        // List dozvoljava duplikate.
        plejlista.add(numb);

        for (Pesma pesma : plejlista) {
            System.out.println(pesma.opis());
        }

        System.out.println("Broj elemenata: " + plejlista.size());
        System.out.println("Prva pesma: " + plejlista.get(0).opis());
    }
}
