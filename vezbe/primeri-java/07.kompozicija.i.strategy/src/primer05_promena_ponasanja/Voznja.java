package primer05_promena_ponasanja;

public class Voznja implements PonasanjeKretanja {
    @Override
    public void kreciSe(String ime) {
        System.out.println(ime + " vozi.");
    }
}
