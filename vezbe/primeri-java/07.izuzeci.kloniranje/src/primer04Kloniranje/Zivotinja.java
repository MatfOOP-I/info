package primer04Kloniranje;


/**
 * Posto smo rekli da je Buva "cloneable", moramo implementirati Cloneable interfejs i u
 * baznoj klasi takodje, pa klasa Zivotinja treba da bude promenjena na sledeci nacin:
 *       public class Zivotinja implements Cloneable {
 *            // Detalji klase isti kao i ranije
 *       }
 */

public class Zivotinja implements Cloneable {

    private String vrsta;


    public Zivotinja(String vrsta) {
        this.vrsta = vrsta;
    }

    public Zivotinja() {

    }

    public void zvuk() {

    }

    public String toString() {
        return "Zivotinja: " + vrsta;
    }

}
