package primer04_kontroler;

import primer04_kontroler.kontroler.KontrolerZadataka;
import primer04_kontroler.kontroler.RezultatOperacije;
import primer04_kontroler.model.ListaZadataka;
import primer04_kontroler.model.Prioritet;

/**
 * I kontroler možemo da koristimo bez JavaFX-a.
 */
public class Main {
    public static void main(String[] args) {
        ListaZadataka model = new ListaZadataka();
        KontrolerZadataka kontroler =
                new KontrolerZadataka(model);

        RezultatOperacije prvi =
                kontroler.dodajZadatak(
                        "Kupiti kartu",
                        Prioritet.VISOK
                );

        System.out.println(prvi.getPoruka());

        RezultatOperacije los =
                kontroler.dodajZadatak(
                        "x",
                        Prioritet.NIZAK
                );

        System.out.println(los.getPoruka());

        kontroler.zavrsiZadatak(0);

        System.out.println(
                kontroler.getZadaci().get(0).isZavrsen()
        );
    }
}
