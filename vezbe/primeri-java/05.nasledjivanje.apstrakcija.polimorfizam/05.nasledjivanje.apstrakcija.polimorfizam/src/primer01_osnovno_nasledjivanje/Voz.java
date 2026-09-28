package primer01_osnovno_nasledjivanje;

/** Voz JESTE jedna vrsta prevoza. */
public class Voz extends Prevoz {
    private int brojVagona;

    public Voz(String naziv, int prosecnaBrzina, int brojVagona) {
        super(naziv, prosecnaBrzina);
        this.brojVagona = brojVagona;
    }

    public int getBrojVagona() {
        return brojVagona;
    }
}
