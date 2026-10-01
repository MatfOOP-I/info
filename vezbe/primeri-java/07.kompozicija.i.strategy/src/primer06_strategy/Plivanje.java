package primer06_strategy;

/**
 * Konkretna strategija kretanja.
 */
public class Plivanje implements PonasanjeKretanja {
    @Override
    public void kreciSe(String ime) {
        System.out.println(ime + " pliva.");
    }
}
