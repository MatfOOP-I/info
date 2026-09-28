package primer06_comparator;

import java.util.Comparator;

/**
 * Druga strategija poređenja.
 *
 * Klasa Pesma nije morala da se menja.
 */
public class PoredjenjePoIzvodjacu implements Comparator<Pesma> {
    @Override
    public int compare(Pesma prva, Pesma druga) {
        int poIzvodjacu =
                prva.getIzvodjac().compareTo(druga.getIzvodjac());

        if (poIzvodjacu != 0) {
            return poIzvodjacu;
        }

        return prva.getNaslov().compareTo(druga.getNaslov());
    }
}
