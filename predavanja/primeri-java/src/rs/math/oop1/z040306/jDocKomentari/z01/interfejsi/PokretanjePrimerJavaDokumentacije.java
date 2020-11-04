package rs.math.oop1.z040306.jDocKomentari.z01.interfejsi;

/**
 * @author vlado
 *         <p>
 *         Klasa <code> PokretanjePrimerJavaDokumentacije </code> služi za
 *         pokretanje aplikacije koja koristi interfejs <code>ProbaInterfejs
 * </code> implementiran od strane klase <code> ProbaImplemenetacija </code>.
 * @see ProbaInterfejs
 * @see ProbaImplementacija
 */
public class PokretanjePrimerJavaDokumentacije {

    /**
     * Polazna tacka pri izvrsavanju Java programa.
     * 
     * @param args - argumenti komandne linije
     */
    public static void main(String[] args) {
        ProbaImplementacija p = new ProbaImplementacija();
        ProbaInterfejs ip = p;

        System.out.println(ProbaInterfejs.NULA);
        System.out.println(ip.NULA);
        int x = 2;
        int y = 3;
        System.out.println(ip.saberi(x, y));
    }

}
