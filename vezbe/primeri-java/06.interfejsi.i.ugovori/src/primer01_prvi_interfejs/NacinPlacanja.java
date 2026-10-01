package primer01_prvi_interfejs;

/**
 * Ugovor koji opisuje jednu sposobnost: objekat ume da izvrši plaćanje.
 *
 * Interfejs ne govori KAKO se plaćanje izvršava.
 * To je odgovornost konkretne klase.
 */
public interface NacinPlacanja {
    boolean plati(int iznos);
}
