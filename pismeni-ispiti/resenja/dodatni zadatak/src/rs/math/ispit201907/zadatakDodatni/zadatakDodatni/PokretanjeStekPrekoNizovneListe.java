/*
a) Napraviti generički interfejs Stek, koji podržava osnovne oparacije sa stekom

b) Napraviti kolekcijsku klasu klasu StekPrekoNizovneListe koja implementira interfejs Stek i implementira interfejs
Collection. Sve komponente steka moraju biti istog, generičkog tipa

Primerci klase StekPrekoNizovneListe informacije o objektima koje sadrze interno cuvaju u nizovnoj listi.

Prilikom kreiranja primerka klase StekPrekoNizovneListe, prosledjuju se jedna ili vise kolekcija objekata istog tipa i
svi objekti iz tih prosleđenih kolekcija treba da se nadju u novokreiranom steku.

Prilikom iteriranja kroz tu kolekciju treba detektovati mogućnost da je u nekoj drugoj niti
dodaje ii ukalnja elemenat steka i u takvom slučaju treba izbaciti izuzetak tipa ConcurrentModificationException.

Prilikom izbacivanja elementa iz preznog steka treba izbaciti izuzetak tipa EmptyStackException.

Iterator kolekcije ne mora da podržava uklanjanje elementa iz steka, već može u tom slučaju izbaciti izuzetak tipa
NotImplementedException.

b) Napraviti metod koji ce biti prvi pokrenut, gde ce biti kreiran primerak klase StekPrekoNizovneListe koji ce
sadrzati elemente iz tri prosleđene kolekcije kojima su svi elementi istog tipa, a potom će se
u taj stek gurnuti jedan elemenat i izbaciti dva elementa.

Posle kreiranja steka i posle svakog ubacivanja i izbacivanja elementa na standardnom izlazu prikazati stek.

 */

package rs.math.ispit201907.zadatakDodatni.zadatakDodatni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PokretanjeStekPrekoNizovneListe {
    public static void main(String[] args) {
        List<String> g1 = Arrays.asList("Biljana", "Anja");
        List<String> g2 = Arrays.asList("Nemanja", "Rastko", "Ivan");
        List<String> g3 = Arrays.asList("Aleksandar", "Vladimir");
        StekPrekoNizovneListe<String> s1 = new StekPrekoNizovneListe<>(g1, g2, g3);
        System.out.println(System.lineSeparator() + "1. Kreiran stek -----------------");
        System.out.println(s1);

        s1.push("Petar");
        System.out.println(System.lineSeparator() + "2. Dodat 'Petar' ---------------");
        System.out.println(s1);

        String uklonjen = s1.pop();
        System.out.println(System.lineSeparator() + "3. Uklonjen vrh ----------------");
        System.out.println(s1);

        s1.pop();
        System.out.println(System.lineSeparator() + "4. Uklonjen vrh ----------------");
        System.out.println(s1);

        s1 = new StekPrekoNizovneListe<>(new ArrayList<>());
        System.out.println(System.lineSeparator() + "5. Kreiran stek -----------------");
        System.out.println(s1);

        s1.push("Petar");
        System.out.println(System.lineSeparator() + "6. Dodat 'Petar' ---------------");
        System.out.println(s1);

        s1.pop();
        System.out.println(System.lineSeparator() + "7. Uklonjen vrh ----------------");
        System.out.println(s1);

        s1.pop();
        System.out.println(System.lineSeparator() + "8. Uklonjen vrh ----------------");
        System.out.println(s1);
    }

}
