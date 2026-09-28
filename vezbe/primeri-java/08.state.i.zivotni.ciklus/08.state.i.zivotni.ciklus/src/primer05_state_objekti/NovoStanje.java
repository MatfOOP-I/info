package primer05_state_objekti;

public class NovoStanje implements StanjePorudzbine {
    @Override
    public void plati(Porudzbina porudzbina) {
        System.out.println("Porudžbina je plaćena.");
        porudzbina.postaviStanje(new PlacenoStanje());
    }

    @Override
    public void posalji(Porudzbina porudzbina) {
        System.out.println("Nova porudžbina ne može da se pošalje.");
    }

    @Override
    public void otkazi(Porudzbina porudzbina) {
        System.out.println("Porudžbina je otkazana.");
        porudzbina.postaviStanje(new OtkazanoStanje());
    }

    @Override
    public String naziv() {
        return "NOVA";
    }
}
