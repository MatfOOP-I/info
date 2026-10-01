package primer02_kasa_zavisi_od_ugovora;

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
}
