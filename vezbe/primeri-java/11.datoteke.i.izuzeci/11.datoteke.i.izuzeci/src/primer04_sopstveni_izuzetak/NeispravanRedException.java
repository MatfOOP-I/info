package primer04_sopstveni_izuzetak;

/**
 * Domenski izuzetak.
 *
 * Znači: tekstualni red ne predstavlja ispravnu rezervaciju.
 */
public class NeispravanRedException extends Exception {
    public NeispravanRedException(String poruka) {
        super(poruka);
    }
}
