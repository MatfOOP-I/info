public class ReliVozac {
    private String ime;
    private ReliAuto automobil;

    public ReliVozac(String ime, ReliAuto automobil) {
        this.ime = ime;
        this.automobil = automobil;
    }

    @Override
    public String toString() {
        return this.ime + " - " + this.automobil.toString();
    }

    public ReliAuto getAutomobil() {
        return automobil;
    }
}
