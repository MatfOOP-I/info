package primer05_apstraktna_klasa_i_interfejs;

/**
 * DebitnaKartica JESTE PlatnaKartica, pa je nasleđuje.
 *
 * Istovremeno UME da se koristi kao način plaćanja,
 * pa implementira interfejs NacinPlacanja.
 */
public class DebitnaKartica extends PlatnaKartica implements NacinPlacanja {
    private int raspolozivo;

    public DebitnaKartica(
            String vlasnik,
            String poslednjeCetiriCifre,
            int raspolozivo
    ) {
        super(vlasnik, poslednjeCetiriCifre);
        this.raspolozivo = Math.max(raspolozivo, 0);
    }

    @Override
    public boolean plati(int iznos) {
        if (iznos <= 0 || iznos > raspolozivo) {
            return false;
        }

        raspolozivo -= iznos;
        return true;
    }
}
