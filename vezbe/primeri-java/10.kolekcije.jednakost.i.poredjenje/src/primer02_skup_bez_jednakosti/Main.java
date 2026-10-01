package primer02_skup_bez_jednakosti;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Pesma> omiljene = new HashSet<>();

        Pesma prva =
                new Pesma("Numb", "Linkin Park");

        Pesma druga =
                new Pesma("Numb", "Linkin Park");

        System.out.println("Isti objekat? " + (prva == druga));

        omiljene.add(prva);
        omiljene.add(druga);

        /*
         * Domen kaže da su ovo dve reprezentacije iste pesme.
         * Ali klasa Pesma to još nije objasnila HashSet-u.
         */
        System.out.println("Broj pesama u skupu: " + omiljene.size());
    }
}
