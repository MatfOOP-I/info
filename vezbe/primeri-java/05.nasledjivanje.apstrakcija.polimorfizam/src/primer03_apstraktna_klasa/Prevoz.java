package primer03_apstraktna_klasa;

/**
 * Apstraktna klasa opisuje zajedničku ideju prevoza.
 *
 * <p>Možemo da kažemo šta svaki prevoz mora da ume, iako na ovom nivou
 * ne možemo da napišemo jedno pravilo za računanje cene.</p>
 */
public abstract class Prevoz {
    private String naziv;

    public Prevoz(String naziv) {
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public abstract int izracunajCenu(int udaljenostKm);
}
