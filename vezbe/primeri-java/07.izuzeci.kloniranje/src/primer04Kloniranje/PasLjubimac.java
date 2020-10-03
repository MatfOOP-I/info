package primer04Kloniranje;

/* Definisemo klasu PasLjubimac koja sadrzi objekat Buva kao clan koji je
 * takodje cloneable
 */

public class PasLjubimac extends Zivotinja implements Cloneable {
    private Buva buva;
    private String ime;
    private String rasa;


    public PasLjubimac(String ime, String rasa)
    {
        super("Pas");
        this.buva = new Buva("Buvica", "Neka vrsta buve");
        this.ime = ime;
        this.rasa = rasa;
    }


    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getIme() {
        return this.ime;
    }

    public String getRasa() {
        return this.rasa;
    }

    public Buva getBuva() {
        return this.buva;
    }

    public void setBuva(Buva buva) {
        this.buva = buva;
    }

    public void zvuk() {
        System.out.println("AV, AV!");
    }

    public String toString() {
        return super.toString() + " - " + this.ime + ", " + this.rasa + "\nSa buvom: " + this.buva;
    }

    // Predefinisemo nasledjeni metod clone() da bismo ga ucinili public
    // Nasledjeni metod izbacuje CloneNotSupportedException izuzetak
    // pa se metod mora deklarisati na prikazani nacin, inace nece
    // proci kompajliranje
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
