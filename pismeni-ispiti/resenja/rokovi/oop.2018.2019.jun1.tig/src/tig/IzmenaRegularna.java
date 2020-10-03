package tig;

import java.util.StringJoiner;

public class IzmenaRegularna extends Izmena {
    private TipRegularneIzmene tipIzmene;

    public TipRegularneIzmene getTipIzmene() {
        return tipIzmene;
    }

    public IzmenaRegularna(Zaglavlje zaglavlje, String poruka, TipRegularneIzmene izmena) {
        super(zaglavlje, poruka);
        this.tipIzmene = izmena;
    }

    public IzmenaRegularna(Zaglavlje zaglavlje, String poruka, int id, TipRegularneIzmene izmena) {
        super(zaglavlje, poruka, id);
        this.tipIzmene = izmena;
    }

    @Override
    public String serijalizuj() {
        // ir, stefan, 1, 15.05.2019 09:00, Postavljen projekat, 1
        StringJoiner joiner = new StringJoiner(", ");
        joiner.add("ir");
        joiner.add(getZaglavlje().getAutor());
        joiner.add("" + getId());
        joiner.add(getZaglavlje().getVremenskaOznaka());
        joiner.add(getPoruka());
        joiner.add(tipIzmene.uBroj() + "");
        return joiner.toString();
    }

    @Override
    public String toString() {
        return "[ir] " + super.toString() + " " + tipIzmene + "\n" + getPoruka();
    }
}
