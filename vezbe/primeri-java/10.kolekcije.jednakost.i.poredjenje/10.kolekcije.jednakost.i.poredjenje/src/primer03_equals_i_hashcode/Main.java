package primer03_equals_i_hashcode;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Pesma prva =
                new Pesma("Numb", "Linkin Park");

        Pesma druga =
                new Pesma("Numb", "Linkin Park");

        System.out.println("==      : " + (prva == druga));
        System.out.println("equals  : " + prva.equals(druga));
        System.out.println(
                "isti hash : " + (prva.hashCode() == druga.hashCode())
        );

        Set<Pesma> omiljene = new HashSet<>();
        omiljene.add(prva);
        omiljene.add(druga);

        System.out.println("Broj pesama u skupu: " + omiljene.size());
    }
}
