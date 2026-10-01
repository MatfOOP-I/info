package primer04_vise_strategija;

public class Voznja implements PonasanjeKretanja {
    @Override
    public void kreciSe(String ime) {
        System.out.println(ime + " vozi.");
    }
}
