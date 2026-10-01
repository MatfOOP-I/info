package primer04_podrazumevana_metoda;

/**
 * Interfejs može da sadrži i podrazumevanu (default) implementaciju metode.
 *
 * Ovo je pomoćni mehanizam. Glavna uloga interfejsa i dalje je da opiše ugovor.
 */
public interface NacinPlacanja {
    boolean plati(int iznos);

    default void ispisiRezultat(boolean uspesno, int iznos) {
        if (uspesno) {
            System.out.println("Plaćanje od " + iznos + " dinara je uspešno.");
        } else {
            System.out.println("Plaćanje nije uspelo.");
        }
    }
}
