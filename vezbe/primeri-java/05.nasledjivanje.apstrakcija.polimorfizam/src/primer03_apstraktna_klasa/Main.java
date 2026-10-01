package primer03_apstraktna_klasa;

public class Main {
    public static void main(String[] args) {
        Prevoz autobus = new Autobus();

        System.out.println(autobus.getNaziv());
        System.out.println(autobus.izracunajCenu(50) + " din");

        // Sledeće nije dozvoljeno:
        // Prevoz prevoz = new Prevoz("Nepoznati prevoz");
        //
        // Apstraktna klasa može da se koristi kao tip reference,
        // ali ne možemo direktno da napravimo njen objekat.
    }
}
