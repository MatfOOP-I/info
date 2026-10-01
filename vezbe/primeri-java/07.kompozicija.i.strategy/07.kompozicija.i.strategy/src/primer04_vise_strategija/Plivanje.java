package primer04_vise_strategija;

public class Plivanje implements PonasanjeKretanja {
    @Override
    public void kreciSe(String ime) {
        System.out.println(ime + " pliva.");
    }
}
