package primer02Comparator.comparatorV3;

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
            Primetimo da u spoljasnjem svetu, izmene u klasi Tacka
            se sada ne odrazavaju, odnosno korisnik ne zna kako
            smo implementirali komparator, i kod iz proslog paketa
            ne moramo uopste da menjamo.
        */
        Collections.sort(tacke, Tacka.porediPoXPaY);
        System.out.println(tacke);
    }
}
