package primer06_promena_nacina_placanja;

public class PlacanjeGotovinom implements NacinPlacanja {
    private int novac;

    public PlacanjeGotovinom(int novac) {
        this.novac = Math.max(novac, 0);
    }

    @Override
    public boolean plati(int iznos) {
        if (iznos <= 0 || iznos > novac) {
            return false;
        }

        novac -= iznos;
        return true;
    }

    @Override
    public String naziv() {
        return "gotovina";
    }
}
