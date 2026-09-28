package primer06_tranzicije;

public class Main {
    public static void main(String[] args) {
        Porudzbina porudzbina = new Porudzbina(1042);

        System.out.println("Početno stanje: " + porudzbina.trenutnoStanje());

        porudzbina.plati();
        System.out.println("Stanje: " + porudzbina.trenutnoStanje());

        porudzbina.posalji();
        System.out.println("Stanje: " + porudzbina.trenutnoStanje());

        porudzbina.isporuci();
        System.out.println("Stanje: " + porudzbina.trenutnoStanje());

        porudzbina.otkazi();

        /*
         * Broj porudžbine se nikada nije promenio.
         * Nismo pravili novi objekat Porudzbina za svaku tranziciju.
         */
        System.out.println("Broj porudžbine: " + porudzbina.getBroj());
    }
}
