package primer05_ogranicenje_tipa;

/**
 * T nije proizvoljan tip.
 *
 * Zahtevamo da implementira Procenjiv, jer paket želi da pozove
 * proceniVrednost() nad svojim sadržajem.
 */
public class OsiguraniPaket<T extends Procenjiv> {
    private final T sadrzaj;

    public OsiguraniPaket(T sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public T getSadrzaj() {
        return sadrzaj;
    }

    public int vrednostZaOsiguranje() {
        /*
         * Ovo je bezbedno jer ograničenje tipa garantuje
         * da T ima metodu proceniVrednost().
         */
        return sadrzaj.proceniVrednost();
    }

    public int cenaOsiguranja() {
        return vrednostZaOsiguranje() / 100;
    }
}
