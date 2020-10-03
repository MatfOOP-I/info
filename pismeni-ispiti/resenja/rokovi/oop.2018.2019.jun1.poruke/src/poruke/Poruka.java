package poruke;

public abstract class Poruka implements Comparable<Poruka> {

    private String tekstPoruke;
    private Datum datum;

    public Poruka(String tekstPoruke, String datum) {
        this.tekstPoruke = tekstPoruke;
        this.datum = new Datum(datum);
    }

    public Poruka(Poruka p) {
        this(p.tekstPoruke, p.datum.toString());
    }

    public String getTekstPoruke() {
        return tekstPoruke;
    }

    public Datum getDatum() {
        return datum;
    }

    public abstract String sacuvajPoruku();

    @Override
    public String toString() {
        return datum + "\n" + tekstPoruke
                + "\n----------------------------------------------\n";
    }
}
