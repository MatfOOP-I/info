package primer06_wildcard;

public class ProcenaPaketa {
    /**
     * Metoda prihvata Paket bilo kog konkretnog tipa
     * koji implementira Procenjiv.
     *
     * Paket<Telefon> nije Paket<Procenjiv>, pa nam je
     * za ovakav potpis potreban wildcard.
     */
    public static int proceni(
            Paket<? extends Procenjiv> paket
    ) {
        return paket.getSadrzaj().proceniVrednost();
    }
}
