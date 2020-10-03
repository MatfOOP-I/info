package primer04Kloniranje;

public class Buva extends Zivotinja implements Cloneable {

    private String ime;
    private String podvrsta;


    public Buva(String ime, String podvrsta )
    {
        super("Buva");
        this.ime = ime;
        this.podvrsta = podvrsta;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getIme() {
        return this.ime;
    }

    public String getPodvrsta() {
        return this.podvrsta;
    }

    public void zvuk() {
        System.out.println("Psst!");
    }

    public String toString() {
        return super.toString() + " - " + this.ime + ", " + this.podvrsta;
    }

    // Predefinisanje nasledjenog metoda clone() da bismo ga ucinili public
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
