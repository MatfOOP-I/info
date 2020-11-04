package rs.math.oop1.z040306.jDocKomentari.z01.interfejsi;

/**
 * @author vlado
 *         <p>
 *         Klasa <code> ProbaImplemenetacija </code> implementira interfejs
 *         <code>
 * ProbaInterfejs</code>
 * @see ProbaInterfejs
 */
public class ProbaImplementacija implements ProbaInterfejs {
    /**
     * Sabira celobrojne argumente.
     * <p>
     * Realizacija metoda za sabiranje dva cela broja.
     * 
     * @param a prvi sabirak
     * @param b drugi sabirak
     * @return zbir dva sabirka
     *         <p>
     *         Metoda je izrađena iskljucivo u svrhu demonstracije koncepta.
     * @see ProbaInterfejs#saberi(int, int)
     */
    @Override
    public int saberi(int a, int b) {

        return a + b;
    }

}
