package primer02_genericka_klasa;

/**
 * T predstavlja tip sadržaja paketa.
 *
 * T nije posebna ključna reč. Mogli bismo da koristimo drugo ime,
 * ali je T uobičajena konvencija za "type".
 */
public class Paket<T> {
    private T sadrzaj;

    public Paket(T sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public T getSadrzaj() {
        return sadrzaj;
    }

    public void postaviSadrzaj(T sadrzaj) {
        this.sadrzaj = sadrzaj;
    }
}
