package primer01_stanje_kao_podklasa;

public class PoslataPorudzbina extends Porudzbina {
    public PoslataPorudzbina(int broj) {
        super(broj);
    }

    @Override
    public Porudzbina plati() {
        System.out.println("Poslata porudžbina je već plaćena.");
        return this;
    }

    @Override
    public Porudzbina posalji() {
        System.out.println("Porudžbina je već poslata.");
        return this;
    }
}
