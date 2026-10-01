package primer01_stanje_kao_podklasa;

public class NovaPorudzbina extends Porudzbina {
    public NovaPorudzbina(int broj) {
        super(broj);
    }

    @Override
    public Porudzbina plati() {
        System.out.println("Porudžbina je plaćena.");

        // Promena stanja zahteva novi objekat druge klase.
        return new PlacenaPorudzbina(getBroj());
    }

    @Override
    public Porudzbina posalji() {
        System.out.println("Nova porudžbina ne može da se pošalje.");
        return this;
    }
}
