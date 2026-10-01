package primer03_delegiranje;

public class Main {
    public static void main(String[] args) {
        Proizvod pasta = new Proizvod("Pasta", 850);
        Proizvod limunada = new Proizvod("Limunada", 260);

        Porudzbina porudzbina = new Porudzbina(5);
        porudzbina.dodajStavku(new StavkaPorudzbine(pasta, 2));
        porudzbina.dodajStavku(new StavkaPorudzbine(limunada, 1));

        System.out.println(porudzbina.opis());

        // Obratiti pažnju na pozive:
        // stavka.izracunajCenu()
        // stavka.opis()
        //
        // Porudzbina koristi druge objekte da obave posao za koji su
        // prirodno odgovorni. To nazivamo delegiranjem.
    }
}
