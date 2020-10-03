package tig;

import java.util.StringJoiner;

public class IzmenaPrihvatanjeZahteva extends Izmena {
    private int idPrihvacenogZahteva;

    public IzmenaPrihvatanjeZahteva(Zaglavlje zaglavlje, String poruka, int idPrihvacenogZahteva) {
        super(zaglavlje, poruka);
        this.idPrihvacenogZahteva = idPrihvacenogZahteva;
    }

    public IzmenaPrihvatanjeZahteva(Zaglavlje zaglavlje, String poruka, int id, int idPrihvacenogZahteva) {
        super(zaglavlje, poruka, id);
        this.idPrihvacenogZahteva = idPrihvacenogZahteva;
    }

    public int getIdPrihvacenogZahteva() {
        return idPrihvacenogZahteva;
    }

    @Override
    public String serijalizuj() {
        // ipz, stefan, 7, 18.05.2019 17:00, Prihvacen zahtev, 5
        StringJoiner joiner = new StringJoiner(", ");
        joiner.add("ipz");
        joiner.add(getZaglavlje().getAutor());
        joiner.add("" + getId());
        joiner.add(getZaglavlje().getVremenskaOznaka());
        joiner.add(getPoruka());
        joiner.add(idPrihvacenogZahteva + "");
        return joiner.toString();
    }

    @Override
    public String toString() {
        return "[ipz] " + super.toString() + " za #" + idPrihvacenogZahteva + "\n" + getPoruka();
    }

}
