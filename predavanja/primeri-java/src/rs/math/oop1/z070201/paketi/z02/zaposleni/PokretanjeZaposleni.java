package rs.math.oop1.z070201.paketi.z02.zaposleni;

public class PokretanjeZaposleni {


    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner("Pripravnik Peca/300/Talicni Tom/500");
        sc.useDelimiter("/");
        Zaposleni z1 = new Zaposleni();
        z1.imePrezime = sc.next();
        z1.plata = sc.nextInt();
        Zaposleni z2 = new Zaposleni();
        z2.imePrezime = sc.next();
        z2.plata = sc.nextInt();
        sc.close();

        System.out.println("Inicijalno");
        System.out.println("ime i prezime=" + z1.imePrezime + ", plata=" + z1.plata);
        System.out.println("ime i prezime=" + z2.imePrezime + ", plata=" + z2.plata);

        z1.plata += 100;
        z2.plata += 300;

        System.out.println("\nPosle povisice");
        System.out.println("ime i prezime=" + z1.imePrezime + ", plata=" + z1.plata);
        System.out.println("ime i prezime=" + z2.imePrezime + ", plata=" + z2.plata);
    }
}

