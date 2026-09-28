package primer03_genericka_metoda;

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
