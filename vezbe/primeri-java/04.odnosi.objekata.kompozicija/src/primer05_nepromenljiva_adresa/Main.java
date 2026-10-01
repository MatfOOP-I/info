package primer05_nepromenljiva_adresa;

public class Main {
    public static void main(String[] args) {
        Adresa staraAdresa = new Adresa("Vojvode Stepe", 10, "Beograd");
        Kupac kupac = new Kupac("Jovana", staraAdresa);

        // Porudžbina čuva adresu koja je važila kada je napravljena.
        Porudzbina porudzbina = new Porudzbina(kupac.getTrenutnaAdresa());

        System.out.println("Pre preseljenja:");
        System.out.println("Kupac: " + kupac.opis());
        System.out.println("Dostava: " + porudzbina.opisAdreseZaDostavu());

        // Preseljenje se modeluje NOVIM Adresa objektom.
        Adresa novaAdresa = new Adresa("Glavna", 25, "Zemun");
        kupac.promeniAdresu(novaAdresa);

        System.out.println("\nPosle preseljenja:");
        System.out.println("Kupac: " + kupac.opis());
        System.out.println("Dostava stare porudzbine: "
                + porudzbina.opisAdreseZaDostavu());

        // Kupac sada pokazuje na novu adresu, ali stara porudžbina
        // i dalje bezbedno čuva staru nepromenljivu adresu.
    }
}
