package primer03_izdvajanje_kretanja;

public class Voznja implements PonasanjeKretanja {
    @Override
    public void kreciSe(String ime) {
        System.out.println(ime + " vozi.");
    }
}
