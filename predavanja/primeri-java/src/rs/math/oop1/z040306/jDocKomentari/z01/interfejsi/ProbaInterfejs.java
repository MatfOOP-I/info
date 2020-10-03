package rs.math.oop1.z040306.jDocKomentari.z01.interfejsi;

/**
 * @author Vladimir FIlipovic
 * <p> Interfejs <code>ProbaInterfejs</code> služi za operacije i za konstante
 * @see ProbaImplementacija
 */
public interface ProbaInterfejs {
    /**
     * Metod <code> saberi </code> sabira dva
     * celobrojna argumenta
     * @param a prvi sabirak
     * @param b drugi sabirak
     * @return zbir dva sabirka
     */
    int saberi(int a, int b);

    /**
     * Konstanta <code> NULA </code> ima vrednost <code> 0 </code>
     * <p> Ova konstanta <b>nije</b> definisana kao klasna.
     */
    final int NULA = 0;

    /**
     * Konstanta <code> NULA2 </code> ima vrednost <code> 0 </code>
     * <p> Ova konstanta <b>jeste</b> definisana kao klasna.
     */
    static final int NULA2 = 0;
}
