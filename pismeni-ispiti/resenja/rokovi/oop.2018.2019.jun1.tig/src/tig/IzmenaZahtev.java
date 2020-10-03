package tig;

import java.util.StringJoiner;

// Inspirisano pull request-u sistema Git.
public class IzmenaZahtev extends Izmena {
    public IzmenaZahtev(Zaglavlje zaglavlje, String poruka) {
        super(zaglavlje, poruka);
    }

    public IzmenaZahtev(Zaglavlje zaglavlje, String poruka, int id) {
        super(zaglavlje, poruka, id);
    }

    @Override
    public String serijalizuj() {
        // iz, nikola, 5, 18.05.2019 14:31, Predlog izmene interfejsa
        StringJoiner joiner = new StringJoiner(", ");
        joiner.add("iz");
        joiner.add(getZaglavlje().getAutor());
        joiner.add("" + getId());
        joiner.add(getZaglavlje().getVremenskaOznaka());
        joiner.add(getPoruka());
        return joiner.toString();
    }

    @Override
    public String toString() {
        return "[iz] " + super.toString();
    }
}
