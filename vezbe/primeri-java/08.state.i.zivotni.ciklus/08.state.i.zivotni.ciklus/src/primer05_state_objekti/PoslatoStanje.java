package primer05_state_objekti;

public class PoslatoStanje implements StanjePorudzbine {
    @Override
    public void plati(Porudzbina porudzbina) {
        System.out.println("Poslata porudžbina je već plaćena.");
    }

    @Override
    public void posalji(Porudzbina porudzbina) {
        System.out.println("Porudžbina je već poslata.");
    }

    @Override
    public void otkazi(Porudzbina porudzbina) {
        System.out.println("Poslata porudžbina više ne može da se otkaže.");
    }

    @Override
    public String naziv() {
        return "POSLATA";
    }
}
