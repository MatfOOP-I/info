package primer01_javna_polja;

/**
 * Prva, namerno loša verzija digitalnog novčanika.
 *
 * <p>Sva polja su javna, pa bilo koji deo programa može da ih promeni
 * bez ikakve kontrole. Zbog toga objekat vrlo lako može da završi u
 * stanju koje nema smisla.</p>
 */
public class Novcanik {
    public String vlasnik;
    public int stanje;
}
