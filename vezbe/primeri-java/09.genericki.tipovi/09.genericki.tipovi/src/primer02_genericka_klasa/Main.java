package primer02_genericka_klasa;

public class Main {
    public static void main(String[] args) {
        Paket<Telefon> paketTelefona =
                new Paket<>(new Telefon("Pixel"));

        Paket<Knjiga> paketKnjige =
                new Paket<>(new Knjiga("Na Drini ćuprija"));

        /*
         * Nema kastovanja.
         * Kompajler zna da paketTelefona sadrži Telefon.
         */
        Telefon telefon = paketTelefona.getSadrzaj();
        Knjiga knjiga = paketKnjige.getSadrzaj();

        System.out.println(telefon.getModel());
        System.out.println(knjiga.getNaslov());

        /*
         * Ovo se NE bi kompajliralo:
         *
         * paketTelefona.postaviSadrzaj(new Knjiga("..."));
         *
         * Greška se otkriva pre pokretanja programa.
         */
    }
}
