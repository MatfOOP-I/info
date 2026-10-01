package primer02_problem_identiteta;

public class PlacenaPorudzbina extends Porudzbina {
    public PlacenaPorudzbina(int broj) {
        super(broj);
    }

    @Override
    public Porudzbina plati() {
        return this;
    }

    @Override
    public String stanje() {
        return "PLACENA";
    }
}
