package primer02_eksplozija_hijerarhije;

public class Main {
    public static void main(String[] args) {
        Lik lucija = new HodajuciAgresivniLik("Lucija");

        lucija.kreciSe();
        lucija.reagujNaOpasnost();

        /*
         * Već imamo:
         *
         * 2 načina kretanja × 2 reakcije = 4 klase.
         *
         * Sa 3 načina kretanja i 3 reakcije imali bismo 9 kombinacija.
         * Sa još jednom nezavisnom osobinom broj klasa nastavlja da se množi.
         *
         * Pitanje:
         * Da li je HodajuciAgresivniLik zaista posebna VRSTA lika?
         */
    }
}
