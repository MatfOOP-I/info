package primer02Comparator.comparatorV4;

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

        Collections.sort(tacke, Tacka.porediPoXPaY);
        System.out.println("Sortiranje po X pa po Y:");
        System.out.println(tacke);


        Collections.sort(tacke, Tacka.porediPoYPaX);
        System.out.println("Sortiranje po Y pa po X:");
        System.out.println(tacke);
    }
}
