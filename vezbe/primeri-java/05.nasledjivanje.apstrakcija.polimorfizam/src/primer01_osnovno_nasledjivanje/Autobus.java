package primer01_osnovno_nasledjivanje;

/** Autobus JESTE jedna vrsta prevoza. */
public class Autobus extends Prevoz {
    private int brojSedista;

    public Autobus(String naziv, int prosecnaBrzina, int brojSedista) {
        // super(...) poziva konstruktor bazne klase.
        super(naziv, prosecnaBrzina);
        this.brojSedista = brojSedista;
    }

    public int getBrojSedista() {
        return brojSedista;
    }
}
