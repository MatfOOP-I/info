package primer02_porudzbina_i_stavke;

public class Main {
    public static void main(String[] args) {
        Adresa adresa = new Adresa("Jurija Gagarina", 14, "Beograd");
        Kupac kupac = new Kupac("Nikola", adresa);

        Proizvod burger = new Proizvod("Burger", 790);
        Proizvod pomfrit = new Proizvod("Pomfrit", 290);

        Porudzbina porudzbina = new Porudzbina(kupac, 5);
        porudzbina.dodajStavku(new StavkaPorudzbine(burger, 2));
        porudzbina.dodajStavku(new StavkaPorudzbine(pomfrit, 1));

        System.out.println(porudzbina.opis());

        // Isti Proizvod objekat može da se koristi i u drugoj porudžbini.
        // Ne moramo svaki put da pravimo novu kopiju proizvoda.
    }
}
