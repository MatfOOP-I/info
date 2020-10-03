package rs.math.oop1.z080301.uredjenje.z02.geometrija;

public abstract class GeometrijskiObjekat {

    private String oznaka;

    public GeometrijskiObjekat(String oznaka) {
        this.oznaka = oznaka;
    }

    public void setOznaka(String o) {
        oznaka = o;
    }

    public String getOznaka() {
        return oznaka;
    }


}
