package primer06_tranzicije;

public class OtkazanoStanje implements StanjePorudzbine {
    @Override
    public void plati(Porudzbina porudzbina) {
        System.out.println("Otkazana porudžbina ne može da se plati.");
    }

    @Override
    public void posalji(Porudzbina porudzbina) {
        System.out.println("Otkazana porudžbina ne može da se pošalje.");
    }

    @Override
    public void isporuci(Porudzbina porudzbina) {
        System.out.println("Otkazana porudžbina ne može da se isporuči.");
    }

    @Override
    public void otkazi(Porudzbina porudzbina) {
        System.out.println("Porudžbina je već otkazana.");
    }

    @Override
    public String naziv() {
        return "OTKAZANA";
    }
}
