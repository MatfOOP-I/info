package primer03_izdvajanje_kretanja;

public class Main {
    public static void main(String[] args) {
        Lik lucija = new Lik("Lucija", new Hodanje());
        Lik plivac = new Lik("Marko", new Plivanje());

        lucija.kreciSe();
        plivac.kreciSe();
    }
}
