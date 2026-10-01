package primer03_izdvajanje_kretanja;

public class Hodanje implements PonasanjeKretanja {
    @Override
    public void kreciSe(String ime) {
        System.out.println(ime + " hoda.");
    }
}
