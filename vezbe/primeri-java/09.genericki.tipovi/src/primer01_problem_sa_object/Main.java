package primer01_problem_sa_object;

public class Main {
    public static void main(String[] args) {
        Paket paket = new Paket(new Telefon("Pixel"));

        /*
         * getSadrzaj() vraća Object.
         * Moramo ručno da kažemo kompajleru šta očekujemo unutra.
         */
        Telefon telefon = (Telefon) paket.getSadrzaj();
        System.out.println(telefon.getModel());

        /*
         * Paket prihvata i potpuno drugi tip.
         */
        paket.postaviSadrzaj(new Knjiga("Na Drini ćuprija"));

        /*
         * Sledeće bi se kompajliralo, ali bi puklo tokom izvršavanja:
         *
         * Telefon pogresno = (Telefon) paket.getSadrzaj();
         *
         * Problem tipa otkrivamo prekasno.
         */
        Knjiga knjiga = (Knjiga) paket.getSadrzaj();
        System.out.println(knjiga.getNaslov());
    }
}
