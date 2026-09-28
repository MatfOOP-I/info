package primer04_podrazumevana_metoda;

public class Main {
    public static void main(String[] args) {
        NacinPlacanja placanje = new PlacanjeGotovinom(1000);

        boolean uspesno = placanje.plati(750);
        placanje.ispisiRezultat(uspesno, 750);
    }
}
