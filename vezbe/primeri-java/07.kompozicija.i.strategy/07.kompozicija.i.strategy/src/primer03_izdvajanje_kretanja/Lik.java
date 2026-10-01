package primer03_izdvajanje_kretanja;

/**
 * Lik više NE NASLEĐUJE način kretanja.
 *
 * Umesto toga:
 *
 * Lik HAS-A PonasanjeKretanja.
 */
public class Lik {
    private final String ime;
    private PonasanjeKretanja ponasanjeKretanja;

    public Lik(String ime, PonasanjeKretanja ponasanjeKretanja) {
        this.ime = ime;
        this.ponasanjeKretanja = ponasanjeKretanja;
    }

    public void kreciSe() {
        /*
         * Delegiranje:
         * Lik prosleđuje posao objektu koji zna kako se konkretno kreće.
         */
        ponasanjeKretanja.kreciSe(ime);
    }
}
