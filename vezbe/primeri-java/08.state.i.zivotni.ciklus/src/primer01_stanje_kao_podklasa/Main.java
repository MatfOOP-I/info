package primer01_stanje_kao_podklasa;

public class Main {
    public static void main(String[] args) {
        Porudzbina porudzbina = new NovaPorudzbina(1042);

        porudzbina = porudzbina.plati();
        porudzbina = porudzbina.posalji();

        System.out.println(
                "Trenutna klasa: " + porudzbina.getClass().getSimpleName()
        );
    }
}
