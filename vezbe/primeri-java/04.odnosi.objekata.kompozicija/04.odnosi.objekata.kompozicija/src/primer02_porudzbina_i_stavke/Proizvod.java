package primer02_porudzbina_i_stavke;

/**
 * Proizvod iz restorana.
 *
 * <p>Cenu predstavljamo celim brojem dinara da tema primera ostane
 * objektno modelovanje, a ne rad sa decimalnim novcem.</p>
 */
public class Proizvod {
    private String naziv;
    private int cena;

    public Proizvod(String naziv, int cena) {
        this.naziv = naziv;
        this.cena = cena;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getCena() {
        return cena;
    }
}
