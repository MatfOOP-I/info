package primer06_strategy;

/**
 * Konkretna strategija kretanja.
 */
public class VoznjaBicikla implements PonasanjeKretanja {
    @Override
    public void kreciSe(String ime) {
        System.out.println(ime + " vozi bicikl.");
    }
}
