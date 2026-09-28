package primer04_vise_strategija;

public class Main {
    public static void main(String[] args) {
        Lik lucija = new Lik(
                "Lucija",
                new Hodanje(),
                new BoriSe()
        );

        Lik turista = new Lik(
                "Turista",
                new Hodanje(),
                new Bezi()
        );

        Lik vozac = new Lik(
                "Vozač",
                new Voznja(),
                new Ignorisi()
        );

        lucija.kreciSe();
        lucija.reagujNaOpasnost();

        turista.kreciSe();
        turista.reagujNaOpasnost();

        vozac.kreciSe();
        vozac.reagujNaOpasnost();
    }
}
