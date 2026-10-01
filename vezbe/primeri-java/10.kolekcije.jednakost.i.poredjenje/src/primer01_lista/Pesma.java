package primer01_lista;

public class Pesma {
    private final String naslov;
    private final String izvodjac;
    private final int trajanjeSekundi;
    private final Zanr zanr;

    public Pesma(
            String naslov,
            String izvodjac,
            int trajanjeSekundi,
            Zanr zanr
    ) {
        this.naslov = naslov;
        this.izvodjac = izvodjac;
        this.trajanjeSekundi = trajanjeSekundi;
        this.zanr = zanr;
    }

    public String getNaslov() {
        return naslov;
    }

    public String getIzvodjac() {
        return izvodjac;
    }

    public int getTrajanjeSekundi() {
        return trajanjeSekundi;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public String opis() {
        return izvodjac + " - " + naslov;
    }
}
