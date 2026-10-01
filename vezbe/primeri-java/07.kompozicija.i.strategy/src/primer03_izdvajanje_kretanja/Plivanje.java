package primer03_izdvajanje_kretanja;

public class Plivanje implements PonasanjeKretanja {
    @Override
    public void kreciSe(String ime) {
        System.out.println(ime + " pliva.");
    }
}
