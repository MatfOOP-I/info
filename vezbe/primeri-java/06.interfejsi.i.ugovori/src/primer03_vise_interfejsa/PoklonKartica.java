package primer03_vise_interfejsa;

/**
 * Poklon karticom može da se plati, ali se u ovom modelu ne može dopunjavati.
 */
public class PoklonKartica implements NacinPlacanja {
    private int preostaliIznos;

    public PoklonKartica(int preostaliIznos) {
        this.preostaliIznos = Math.max(preostaliIznos, 0);
    }

    @Override
    public boolean plati(int iznos) {
        if (iznos <= 0 || iznos > preostaliIznos) {
            return false;
        }

        preostaliIznos -= iznos;
        return true;
    }
}
