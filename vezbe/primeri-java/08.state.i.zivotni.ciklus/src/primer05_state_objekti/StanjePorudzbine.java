package primer05_state_objekti;

/**
 * Ugovor koji opisuje ponašanje porudžbine u jednom stanju.
 */
public interface StanjePorudzbine {
    void plati(Porudzbina porudzbina);

    void posalji(Porudzbina porudzbina);

    void otkazi(Porudzbina porudzbina);

    String naziv();
}
