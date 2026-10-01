package primer04_vise_strategija;

/**
 * Lik se sastavlja od dva nezavisna ponašanja.
 *
 * Umesto klase za svaku kombinaciju, kombinujemo objekte.
 */
public class Lik {
    private final String ime;
    private PonasanjeKretanja ponasanjeKretanja;
    private PonasanjeReakcije ponasanjeReakcije;

    public Lik(
            String ime,
            PonasanjeKretanja ponasanjeKretanja,
            PonasanjeReakcije ponasanjeReakcije
    ) {
        this.ime = ime;
        this.ponasanjeKretanja = ponasanjeKretanja;
        this.ponasanjeReakcije = ponasanjeReakcije;
    }

    public void kreciSe() {
        ponasanjeKretanja.kreciSe(ime);
    }

    public void reagujNaOpasnost() {
        ponasanjeReakcije.reaguj(ime);
    }
}
