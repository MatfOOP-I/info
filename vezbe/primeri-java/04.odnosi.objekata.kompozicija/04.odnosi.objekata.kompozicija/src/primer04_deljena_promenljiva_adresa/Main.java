package primer04_deljena_promenljiva_adresa;

public class Main {
    public static void main(String[] args) {
        Adresa adresa = new Adresa("Vojvode Stepe", 10, "Beograd");
        Kupac kupac = new Kupac("Jovana", adresa);

        // Porudžbina dobija ISTU referencu koju koristi i kupac.
        Porudzbina porudzbina = new Porudzbina(kupac.getAdresa());

        System.out.println("Pre promene:");
        System.out.println("Kupac: " + kupac.opis());
        System.out.println("Dostava: " + porudzbina.opisAdreseZaDostavu());

        // Kupac se u međuvremenu preselio.
        // Menjamo isti Adresa objekat koji koristi i porudžbina.
        kupac.getAdresa().promeni("Glavna", 25, "Zemun");

        System.out.println("\nPosle promene:");
        System.out.println("Kupac: " + kupac.opis());
        System.out.println("Dostava: " + porudzbina.opisAdreseZaDostavu());

        // Da li smo zaista želeli da se adresa stare porudžbine promeni?
    }
}
