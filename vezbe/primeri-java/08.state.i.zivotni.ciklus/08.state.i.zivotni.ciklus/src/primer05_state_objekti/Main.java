package primer05_state_objekti;

public class Main {
    public static void main(String[] args) {
        Porudzbina porudzbina = new Porudzbina(1042);

        System.out.println(porudzbina.trenutnoStanje());

        porudzbina.posalji();
        porudzbina.plati();

        System.out.println(porudzbina.trenutnoStanje());

        porudzbina.posalji();

        System.out.println(porudzbina.trenutnoStanje());
    }
}
