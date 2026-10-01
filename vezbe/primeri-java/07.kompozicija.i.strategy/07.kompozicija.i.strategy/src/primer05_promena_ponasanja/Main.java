package primer05_promena_ponasanja;

public class Main {
    public static void main(String[] args) {
        Lik lucija = new Lik(
                "Lucija",
                new Hodanje(),
                new BoriSe()
        );

        lucija.kreciSe();
        lucija.reagujNaOpasnost();

        System.out.println("--- ulazi u vozilo ---");
        lucija.postaviPonasanjeKretanja(new Voznja());
        lucija.kreciSe();

        System.out.println("--- ulazi u vodu ---");
        lucija.postaviPonasanjeKretanja(new Plivanje());
        lucija.kreciSe();

        System.out.println("--- odlučuje da izbegne sukob ---");
        lucija.postaviPonasanjeReakcije(new Bezi());
        lucija.reagujNaOpasnost();

        /*
         * Sve vreme radimo sa ISTIM objektom lucija.
         * Menjaju se njegovi saradnici, odnosno ponašanja.
         */
    }
}
