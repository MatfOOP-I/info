package primer01_stanje_kao_podklasa;

public abstract class Porudzbina {
    private final int broj;

    public Porudzbina(int broj) {
        this.broj = broj;
    }

    public int getBroj() {
        return broj;
    }

    public abstract Porudzbina plati();

    public abstract Porudzbina posalji();
}
