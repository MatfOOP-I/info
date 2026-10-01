package primer06_comparator;

public class Pesma implements Comparable<Pesma> {
    private final String naslov;
    private final String izvodjac;
    private final int trajanjeSekundi;

    public Pesma(
            String naslov,
            String izvodjac,
            int trajanjeSekundi
    ) {
        this.naslov = naslov;
        this.izvodjac = izvodjac;
        this.trajanjeSekundi = trajanjeSekundi;
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

    @Override
    public int compareTo(Pesma druga) {
        int poNaslovu = naslov.compareTo(druga.naslov);

        if (poNaslovu != 0) {
            return poNaslovu;
        }

        return izvodjac.compareTo(druga.izvodjac);
    }

    public String opis() {
        return izvodjac + " - " + naslov
                + " (" + trajanjeSekundi + " s)";
    }
}
