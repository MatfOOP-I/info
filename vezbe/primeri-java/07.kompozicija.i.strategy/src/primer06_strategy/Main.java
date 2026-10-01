package primer06_strategy;

public class Main {
    public static void main(String[] args) {
        Lik lucija = new Lik(
                "Lucija",
                new Hodanje()
        );

        lucija.kreciSe();

        lucija.postaviStrategijuKretanja(new Voznja());
        lucija.kreciSe();

        /*
         * Dodali smo potpuno novu strategiju VoznjaBicikla.
         *
         * Klasa Lik nije morala da se promeni.
         */
        lucija.postaviStrategijuKretanja(new VoznjaBicikla());
        lucija.kreciSe();
    }
}
