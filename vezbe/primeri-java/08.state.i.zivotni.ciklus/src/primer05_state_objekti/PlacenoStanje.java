package primer05_state_objekti;

public class PlacenoStanje implements StanjePorudzbine {
    @Override
    public void plati(Porudzbina porudzbina) {
        System.out.println("Porudžbina je već plaćena.");
    }

    @Override
    public void posalji(Porudzbina porudzbina) {
        System.out.println("Porudžbina je poslata.");
        porudzbina.postaviStanje(new PoslatoStanje());
    }

    @Override
    public void otkazi(Porudzbina porudzbina) {
        System.out.println("Vraćamo novac i otkazujemo porudžbinu.");
        porudzbina.postaviStanje(new OtkazanoStanje());
    }

    @Override
    public String naziv() {
        return "PLACENA";
    }
}
