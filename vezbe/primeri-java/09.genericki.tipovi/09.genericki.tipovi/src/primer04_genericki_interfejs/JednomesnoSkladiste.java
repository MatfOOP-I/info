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
        if (this.predmet != null) {
            System.out.println("Skladište je već zauzeto.");
            return;
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
