package primer01_prvi_interfejs;

/**
 * Druga implementacija istog ugovora.
 *
 * Za potrebe primera kartica samo čuva raspoloživi iznos.
 * Ne modelujemo pravi bankarski sistem.
 */
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

    public int getRaspolozivo() {
        return raspolozivo;
    }
}
