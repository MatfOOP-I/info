package primer04_genericki_interfejs;

/**
 * Jedna implementacija generičkog interfejsa.
 *
 * Ista klasa može da služi kao skladište različitih tipova.
 */
public class JednomesnoSkladiste<T> implements Skladiste<T> {
    private T predmet;

    @Override
    public void smesti(T predmet) {
        if (predmet == null) {
            throw new IllegalArgumentException("null označava prazno skladište, nije predmet.");
        }
        if (this.predmet != null) {
            throw new IllegalStateException("Skladište je već zauzeto.");
        }

        this.predmet = predmet;
    }

    @Override
    public T preuzmi() {
        T rezultat = predmet;
        predmet = null;
        return rezultat;
    }

    @Override
    public boolean jePrazno() {
        return predmet == null;
    }
}
