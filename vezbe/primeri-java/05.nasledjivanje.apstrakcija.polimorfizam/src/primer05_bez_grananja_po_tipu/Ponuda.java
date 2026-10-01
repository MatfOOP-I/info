package primer05_bez_grananja_po_tipu;

/**
 * Klasa koja koristi apstrakciju Prevoz.
 *
 * <p>Ona ne zna koje konkretne podklase postoje. Zato će raditi i sa
 * nekom budućom klasom, npr. Kombi, bez izmene ove metode.</p>
 */
public class Ponuda {
    public static void ispisi(Prevoz prevoz, int udaljenostKm) {
        System.out.println(prevoz.naziv() + ": "
                + prevoz.izracunajCenu(udaljenostKm) + " din");
    }
}
