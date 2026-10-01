package primer02_refaktorisano_resenje.servis;

/**
 * Očekivani problem prilikom pokušaja kreiranja rezervacije.
 */
public class RezervacijaException extends Exception {
    public RezervacijaException(String poruka, Throwable uzrok) {
        super(poruka, uzrok);
    }
    public RezervacijaException(String poruka) {
        super(poruka);
    }
}
