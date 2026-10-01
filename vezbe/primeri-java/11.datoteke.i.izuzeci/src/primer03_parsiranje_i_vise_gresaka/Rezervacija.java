package primer03_parsiranje_i_vise_gresaka;

public class Rezervacija {
    private final String ime;
    private final String prezime;
    private final int godine;
    private final String destinacija;

    public Rezervacija(
            String ime,
            String prezime,
            int godine,
            String destinacija
    ) {
        this.ime = ime;
        this.prezime = prezime;
        this.godine = godine;
        this.destinacija = destinacija;
    }

    public String opis() {
        return ime + " " + prezime
                + ", " + godine + " godina"
                + ", destinacija: " + destinacija;
    }
}
