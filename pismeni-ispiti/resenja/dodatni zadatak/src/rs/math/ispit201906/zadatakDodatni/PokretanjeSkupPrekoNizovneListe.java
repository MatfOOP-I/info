/*
a) Napraviti klasu SkupPrekoNizovneListe koja implementira interfejs Set (tj. omogucuje ponasanje skupa).

Primerci klase SkupPrekoNizovneListe informacije o objektima koje sadrze cuvaju u nizovnoj listi.

Prilikom kreiranja primerka klase SkupPrekoNizovneListe, prosledjuju se jedna ili vise kolekcija objekata istog tipa i
svi objekti iz tih prosleđenih kolekcija treba da se nadju u novokreiranom skupu.

Skup sadrži elemente koji se ne ponavljaju.

Prilikom iteriranja kroz skup treba detektovati mogućnost da je u nekoj drugoj niti struktura skupa promenjena i u 
takvom slučaju treba izbaciti izuzetak tipa ConcurrentModificationException.

Prilikom uklanjanja elementa iz skupa koriscenjem metoda remove iteratora treba proveriti da li je takvo uklanjanje
moguce i ako nije izbaciti izuzetak tipa IndexOutOfBoundsException. 

Skup treba da prevaziđe metod toString() tako da ga prikaže u tradicionalnoj matematičkoj notaciji, korišćenjem
vitičastih (velikih) zagrada. Metod toString treba da se realizuje korišćenjem kolekcijskog for ciklusa.

b) Napraviti metod koji ce biti prvi pokrenut, gde ce biti kreiran primerak klase SkupPrekoNizovneListe koji ce
sadrzati elemente iz tri prosleđene kolekcije kojima su svi elementi istog tipa, a potom ce se
u taj skup ubacuje jedan element koji se dotad nije nalazio u skupu, ubacuje jedan element koji se već nalazio 
u skupu, izbacuje jedan element koji se nalazio u skupu i izbacuje jedan koga dotad nije bilo u skupu.

Posle kreiranja skupa i posle svakog ubacivanja i izbacivanja elementa na standardnom izlazu prikazati skup.

 */

package rs.math.ispit201906.zadatakDodatni;

import java.util.List;
import java.util.Arrays;
import java.util.Random;

public class PokretanjeSkupPrekoNizovneListe {
    public static void main(String[] args) {
        List<String> g10 = Arrays.asList("Ana", "Ivana", "Marija", "Ana");
        SkupPrekoNizovneListe<String> s1 = new SkupPrekoNizovneListe<>(g10);
        System.out.println(System.lineSeparator() + "1. -----------------------------");
        System.out.println(s1);

        List<String> g11 = Arrays.asList("Mitar", "Ana", "Zoran", "Petar", "Denis", "Petar");
        for( String s: g11 )
            s1.add(s);
        System.out.println(System.lineSeparator() + "2. -----------------------------");
        System.out.println(s1);

        s1 = new SkupPrekoNizovneListe<String>(g10, g11);
        System.out.println(System.lineSeparator() + "3. -----------------------------");
        System.out.println(s1);

        s1.remove("Mitar");
        s1.remove( "Ana");
        System.out.println(System.lineSeparator() + "4. -----------------------------");
        System.out.println(s1);

        List<Integer> g2 = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3);
        SkupPrekoNizovneListe<Integer> s2 = new SkupPrekoNizovneListe<>(g2);
        System.out.println(System.lineSeparator() + "5. -----------------------------");
        System.out.println(s2);

        Random generator = new Random();
        System.out.println(System.lineSeparator() + "6. -----------------------------");
        for( int i =0; i<10; i++) {
            int broj = generator.nextInt(20);
            s2.add(broj);
            System.out.println(broj + "\t " + s2);
        }

        System.out.println(System.lineSeparator() + "7. -----------------------------");
        for( int i =0; i<10; i++) {
            int broj = generator.nextInt(20);
            s2.remove(broj);
            System.out.println(broj + "\t " + s2);
        }
    }
}
