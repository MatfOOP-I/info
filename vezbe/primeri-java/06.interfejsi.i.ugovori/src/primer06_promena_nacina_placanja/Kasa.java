package primer06_promena_nacina_placanja;

/**
 * Kasa može tokom rada da dobije drugi način plaćanja.
 *
 * Ona ipak sve vreme zna samo za tip NacinPlacanja.
 */
public class Kasa {
    private NacinPlacanja nacinPlacanja;

    public Kasa(NacinPlacanja nacinPlacanja) {
        this.nacinPlacanja = nacinPlacanja;
    }

    public void postaviNacinPlacanja(NacinPlacanja nacinPlacanja) {
        this.nacinPlacanja = nacinPlacanja;
    }

    public void naplati(int iznos) {
        System.out.println(
                "Pokušavamo plaćanje: " + nacinPlacanja.naziv()
        );

        if (nacinPlacanja.plati(iznos)) {
            System.out.println("Plaćanje je uspelo.");
        } else {
            System.out.println("Plaćanje nije uspelo.");
        }
    }
}
