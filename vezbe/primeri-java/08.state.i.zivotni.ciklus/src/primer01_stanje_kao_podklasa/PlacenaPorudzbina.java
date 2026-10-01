package primer01_stanje_kao_podklasa;

public class PlacenaPorudzbina extends Porudzbina {
    public PlacenaPorudzbina(int broj) {
        super(broj);
    }

    @Override
    public Porudzbina plati() {
        System.out.println("Porudžbina je već plaćena.");
        return this;
    }

    @Override
    public Porudzbina posalji() {
        System.out.println("Porudžbina je poslata.");
        return new PoslataPorudzbina(getBroj());
    }
}
