package primer06_odgovornost_za_gresku;

public class NeispravanRedException extends Exception {
    public NeispravanRedException(String poruka) {
        super(poruka);
    }
}
