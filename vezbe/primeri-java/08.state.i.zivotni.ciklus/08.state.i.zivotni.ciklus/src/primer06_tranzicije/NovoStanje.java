package primer06_tranzicije;

public class NovoStanje implements StanjePorudzbine {
    @Override
    public void plati(Porudzbina porudzbina) {
        System.out.println("Plaćanje uspešno.");
        porudzbina.postaviStanje(new PlacenoStanje());
    }

    @Override
    public void posalji(Porudzbina porudzbina) {
        System.out.println("Prvo platite porudžbinu.");
    }

    @Override
    public void isporuci(Porudzbina porudzbina) {
        System.out.println("Nova porudžbina ne može da bude isporučena.");
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
