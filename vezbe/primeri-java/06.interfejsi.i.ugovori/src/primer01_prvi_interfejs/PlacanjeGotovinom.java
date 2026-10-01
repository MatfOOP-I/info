package primer01_prvi_interfejs;

/**
 * Jedna konkretna implementacija ugovora NacinPlacanja.
 */
public class PlacanjeGotovinom implements NacinPlacanja {
    private int novacKodKupca;

    public PlacanjeGotovinom(int novacKodKupca) {
        this.novacKodKupca = novacKodKupca;
    }

    @Override
    public boolean plati(int iznos) {
        if (iznos <= 0 || iznos > novacKodKupca) {
            return false;
        }

        novacKodKupca -= iznos;
        return true;
    }

    public int getNovacKodKupca() {
        return novacKodKupca;
    }
}
