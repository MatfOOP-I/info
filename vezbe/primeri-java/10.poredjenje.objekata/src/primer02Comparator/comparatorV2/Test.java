package primer02Comparator.comparatorV2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<Tacka> tacke = new ArrayList<>(Arrays.asList(
                new Tacka(2, 3),
                new Tacka(2, 5),
                new Tacka(3, 1),
                new Tacka(-1, 1),
                new Tacka(7, 6),
                new Tacka(5, -7),
                new Tacka(-3, 2),
                new Tacka(5, -6)
        ));

        /*
            Ne svidja nam se da korisnik bude primoran da
            instancira objekat kada god zeli da sortira tacke,
            te podizemo nivo enkapsulacije i apstrakcije tako
            sto komparator premestamo u klasu 'comparatorV2.Tacka'.
            Osim toga, zelimo da obezbedimo da postoji najvise
            jedan objekat komparatora, a ne da se objekat
            instancira svaki put kada se zeli poredjenje.
            Dodatno, sakrili smo klasu 'PorediPoXPaY' od spoljasnjeg
            sveta jer je ona sada umetnuta u klasu
            'comparatorV2.Tacka' kao privatna.
        */
        Collections.sort(tacke, Tacka.porediPoXPaY);
        System.out.println(tacke);
    }
}
