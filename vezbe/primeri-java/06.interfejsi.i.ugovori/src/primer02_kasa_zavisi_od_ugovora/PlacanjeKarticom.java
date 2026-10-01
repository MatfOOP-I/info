package primer02_kasa_zavisi_od_ugovora;

public class PlacanjeKarticom implements NacinPlacanja {
    private int raspolozivo;

    public PlacanjeKarticom(int raspolozivo) {
        this.raspolozivo = raspolozivo;
    }

    @Override
    public boolean plati(int iznos) {
        if (iznos <= 0 || iznos > raspolozivo) {
            return false;
        }

        raspolozivo -= iznos;
        return true;
    }
}
