package primer06_tranzicije;

/**
 * Isti objekat Porudzbina prolazi kroz čitav životni ciklus.
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

    public void isporuci() {
        stanje.isporuci(this);
    }

    public void otkazi() {
        stanje.otkazi(this);
    }

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
