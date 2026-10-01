package primer04_genericki_interfejs;

public class Main {
    public static void main(String[] args) {
        Skladiste<String> garderoba =
                new JednomesnoSkladiste<>();

        garderoba.smesti("jakna");
        System.out.println(garderoba.preuzmi());

        Skladiste<Integer> brojSkladista =
                new JednomesnoSkladiste<>();

        brojSkladista.smesti(42);
        System.out.println(brojSkladista.preuzmi());
    }
}
