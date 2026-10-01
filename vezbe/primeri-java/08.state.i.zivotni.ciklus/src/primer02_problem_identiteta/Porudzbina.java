package primer02_problem_identiteta;

public abstract class Porudzbina {
    private final int broj;

    public Porudzbina(int broj) {
        this.broj = broj;
    }

    public int getBroj() {
        return broj;
    }

    public abstract Porudzbina plati();

    public abstract String stanje();
}
