package primer05_reference;

import primer04_konstruktori_static_final.Novcanik;

/**
 * Primer rada sa referencama na objekte.
 */
public class Main {
    public static void main(String[] args) {
        Novcanik prvi = new Novcanik("Ana");

        // Ne pravi se novi Novcanik. Kopira se vrednost reference.
        Novcanik drugi = prvi;

        drugi.uplati(1_000);

        System.out.println(prvi.opis());
        System.out.println(drugi.opis());

        // Oba izraza se odnose na isti objekat.
        System.out.println("Isti objekat: " + (prvi == drugi));

        uplatiBonus(prvi);
        System.out.println("Posle bonusa: " + prvi.opis());

        Novcanik markov = new Novcanik("Marko");
        pokusajDaPromenisReferencu(prvi, markov);

        // Promenljiva 'prvi' i dalje pokazuje na Anin novčanik.
        System.out.println("Posle poziva metode: " + prvi.opis());
    }

    private static void uplatiBonus(Novcanik novcanik) {
        // Parametar sadrži kopiju reference na isti objekat.
        // Menjamo objekat, pa se promena vidi i nakon povratka iz metode.
        novcanik.uplati(500);
    }

    private static void pokusajDaPromenisReferencu(
            Novcanik novcanik,
            Novcanik drugiNovcanik
    ) {
        // Menjamo samo lokalnu promenljivu 'novcanik'.
        // Promenljiva koju je pozivalac prosledio ne menja svoju vrednost.
        novcanik = drugiNovcanik;
        novcanik.uplati(200);
    }
}
