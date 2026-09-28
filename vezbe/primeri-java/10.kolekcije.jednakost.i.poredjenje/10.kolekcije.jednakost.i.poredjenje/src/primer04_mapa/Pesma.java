package primer04_mapa;

public class Pesma {
    private final String naslov;
    private final String izvodjac;

    public Pesma(String naslov, String izvodjac) {
        this.naslov = naslov;
        this.izvodjac = izvodjac;
    }

    public String opis() {
        return izvodjac + " - " + naslov;
    }
}
