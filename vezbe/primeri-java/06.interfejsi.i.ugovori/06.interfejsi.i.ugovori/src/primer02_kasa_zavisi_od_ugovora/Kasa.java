package primer02_kasa_zavisi_od_ugovora;

/**
 * Kasa ne zna da li plaćamo gotovinom ili karticom.
 *
 * Ona zavisi samo od ugovora NacinPlacanja.
 * Time je odvojena od konkretnih implementacija.
 */
public class Kasa {
    private NacinPlacanja nacinPlacanja;

    public Kasa(NacinPlacanja nacinPlacanja) {
        this.nacinPlacanja = nacinPlacanja;
    }

    public boolean naplati(int iznos) {
        /*
         * Kasa delegira konkretno izvršavanje plaćanja objektu koji joj je dat.
         */
        return nacinPlacanja.plati(iznos);
    }
}
