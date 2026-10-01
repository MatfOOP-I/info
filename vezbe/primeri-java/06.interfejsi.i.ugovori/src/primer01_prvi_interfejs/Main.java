package primer01_prvi_interfejs;

public class Main {
    public static void main(String[] args) {
        /*
         * Tip promenljive je interfejs, a konkretni objekti su različitih klasa.
         * Ostatku programa je dovoljno da oba objekta umeju da plate.
         */
        NacinPlacanja prvoPlacanje = new PlacanjeGotovinom(3000);
        NacinPlacanja drugoPlacanje = new PlacanjeKarticom(5000);

        System.out.println(prvoPlacanje.plati(1200));
        System.out.println(drugoPlacanje.plati(1200));
    }
}
