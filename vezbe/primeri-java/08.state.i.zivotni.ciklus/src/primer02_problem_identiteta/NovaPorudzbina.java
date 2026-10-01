package primer02_problem_identiteta;

public class NovaPorudzbina extends Porudzbina {
    public NovaPorudzbina(int broj) {
        super(broj);
    }

    @Override
    public Porudzbina plati() {
        return new PlacenaPorudzbina(getBroj());
    }

    @Override
    public String stanje() {
        return "NOVA";
    }
}
