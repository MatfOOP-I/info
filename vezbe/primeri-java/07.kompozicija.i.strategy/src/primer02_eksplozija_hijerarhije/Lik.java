package primer02_eksplozija_hijerarhije;

public abstract class Lik {
    private final String ime;

    public Lik(String ime) {
        this.ime = ime;
    }

    public String getIme() {
        return ime;
    }

    public abstract void kreciSe();

    public abstract void reagujNaOpasnost();
}
