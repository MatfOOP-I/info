package primer06_wildcard;

public class Paket<T> {
    private final T sadrzaj;

    public Paket(T sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public T getSadrzaj() {
        return sadrzaj;
    }
}
