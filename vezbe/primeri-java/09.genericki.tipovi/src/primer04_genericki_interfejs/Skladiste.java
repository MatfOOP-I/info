package primer04_genericki_interfejs;

/**
 * Generički ugovor za skladište predmeta tipa T.
 */
public interface Skladiste<T> {
    void smesti(T predmet);

    T preuzmi();

    boolean jePrazno();
}
