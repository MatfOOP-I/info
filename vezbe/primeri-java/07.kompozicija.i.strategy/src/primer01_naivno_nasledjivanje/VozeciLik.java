package primer01_naivno_nasledjivanje;

public class VozeciLik extends Lik {
    public VozeciLik(String ime) {
        super(ime);
    }

    @Override
    public void kreciSe() {
        System.out.println(getIme() + " vozi.");
    }
}
