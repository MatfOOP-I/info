package primer01_naivno_nasledjivanje;

public class HodajuciLik extends Lik {
    public HodajuciLik(String ime) {
        super(ime);
    }

    @Override
    public void kreciSe() {
        System.out.println(getIme() + " hoda.");
    }
}
