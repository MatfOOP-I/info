package primer01_naivno_nasledjivanje;

public class Main {
    public static void main(String[] args) {
        Lik prvi = new HodajuciLik("Lucija");
        Lik drugi = new VozeciLik("Džejson");

        prvi.kreciSe();
        drugi.kreciSe();

        /*
         * Za samo dve vrste ponašanja ovaj dizajn još ne izgleda loše.
         * Problem ćemo videti kada dodamo nezavisne osobine.
         */
    }
}
