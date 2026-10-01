package primer01_naivno_nasledjivanje;

/**
 * Bazna klasa za likove.
 *
 * Za sada pretpostavljamo da je način kretanja deo vrste lika.
 * U malom sistemu ovo još ne izgleda problematično.
 */
public abstract class Lik {
    private final String ime;

    public Lik(String ime) {
        this.ime = ime;
    }

    public String getIme() {
        return ime;
    }

    public abstract void kreciSe();
}
