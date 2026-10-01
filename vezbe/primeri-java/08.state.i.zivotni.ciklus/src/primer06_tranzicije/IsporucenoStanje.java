package primer06_tranzicije;

public class IsporucenoStanje implements StanjePorudzbine {
    @Override
    public void plati(Porudzbina porudzbina) {
        System.out.println("Isporučena porudžbina je već plaćena.");
    }

    @Override
    public void posalji(Porudzbina porudzbina) {
        System.out.println("Porudžbina je već isporučena.");
    }

    @Override
    public void isporuci(Porudzbina porudzbina) {
        System.out.println("Porudžbina je već isporučena.");
    }

    @Override
    public void otkazi(Porudzbina porudzbina) {
        System.out.println("Isporučena porudžbina ne može da se otkaže.");
    }

    @Override
    public String naziv() {
        return "ISPORUCENA";
    }
}
