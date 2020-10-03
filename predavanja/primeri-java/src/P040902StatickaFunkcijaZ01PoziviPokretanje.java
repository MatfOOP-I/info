public class P040902StatickaFunkcijaZ01PoziviPokretanje {

    static void utrostruci(double x) {
        System.out.println("\tUnutar metoda, na pocetku izvrsavanja: x=" + x);
        x = 3 * x;
        System.out.println("\tUnutar metoda, na kraju izvrsavanja:   x=" + x);
    }

    static double utrostruci1(double x) {
        System.out.println("\tUnutar metoda, na pocetku izvrsavanja: x=" + x);
        x = 3 * x;
        System.out.println("\tUnutar metoda, na kraju izvrsavanja:   x=" + x);
        return x;
    }

    public static void main(String[] args) {
        // Pokretanje 1: Metod ne moze promeniti vrednost parametara primitivnog tipa
        System.out.println("\nPokretanjeiranje metoda utrostruci():");
        double procenat = 10;
        System.out.println("Pre poziva:   procenat=" + procenat);
        utrostruci(procenat);
        System.out.println("Posle poziva: procenat=" + procenat);

        // Pokretanje 2: Metod moze da vrati vrednost primitivnog tipa kao rezultat
        System.out.println("\nPokretanjeiranje metoda utrostruci1():");
        double procenat1 = 10;
        System.out.println("Pre poziva:   procenat1=" + procenat1);
        procenat1 = utrostruci1(procenat1);
        System.out.println("Posle poziva: procenat1=" + procenat1);
    }

}
