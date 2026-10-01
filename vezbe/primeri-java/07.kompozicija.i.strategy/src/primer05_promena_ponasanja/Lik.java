package primer05_promena_ponasanja;

/**
 * Identitet lika nije vezan za trenutno ponašanje.
 *
 * Zato ponašanje možemo menjati bez pravljenja novog objekta Lik.
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

    public void postaviPonasanjeKretanja(
            PonasanjeKretanja ponasanjeKretanja
    ) {
        this.ponasanjeKretanja = ponasanjeKretanja;
    }

    public void postaviPonasanjeReakcije(
            PonasanjeReakcije ponasanjeReakcije
    ) {
        this.ponasanjeReakcije = ponasanjeReakcije;
    }
}
