package primer05_state_objekti;

/**
 * Porudžbina čuva svoj identitet i trenutno stanje.
 *
 * Operacije delegira state objektu.
 */
public class Porudzbina {
    private final int broj;
    private StanjePorudzbine stanje;

    public Porudzbina(int broj) {
        this.broj = broj;
        stanje = new NovoStanje();
    }

    public void plati() {
        stanje.plati(this);
    }

    public void posalji() {
        stanje.posalji(this);
    }

    public void otkazi() {
        stanje.otkazi(this);
    }

    /*
     * Namerno nije public.
     * Spoljni kod ne treba proizvoljno da postavlja stanje porudžbine.
     * Tranzicije kontrolišu objekti stanja iz istog paketa.
     */
    void postaviStanje(StanjePorudzbine stanje) {
        this.stanje = stanje;
    }

    public int getBroj() {
        return broj;
    }

    public String trenutnoStanje() {
        return stanje.naziv();
    }
}
