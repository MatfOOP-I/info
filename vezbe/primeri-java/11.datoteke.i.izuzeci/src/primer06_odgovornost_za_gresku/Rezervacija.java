package primer06_odgovornost_za_gresku;

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
                + " -> " + destinacija
                + ", " + godine + " godina";
    }
}
