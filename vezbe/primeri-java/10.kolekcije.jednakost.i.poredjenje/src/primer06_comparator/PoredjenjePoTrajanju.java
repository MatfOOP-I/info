package primer06_comparator;

import java.util.Comparator;

/**
 * Jedna konkretna strategija poređenja pesama.
 */
public class PoredjenjePoTrajanju implements Comparator<Pesma> {
    @Override
    public int compare(Pesma prva, Pesma druga) {
        return Integer.compare(
                prva.getTrajanjeSekundi(),
                druga.getTrajanjeSekundi()
        );
    }
}
