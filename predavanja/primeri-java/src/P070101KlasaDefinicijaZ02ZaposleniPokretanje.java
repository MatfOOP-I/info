class Zaposleni {
    String imePrezime;
    double plata;
}

public class P070101KlasaDefinicijaZ02ZaposleniPokretanje {
    public static void main(String[] args) {
       
        Zaposleni e = new Zaposleni();
        e.imePrezime = "Pripravnik Peca";
        e.plata = 750;

        System.out.println("Inicijalno");
        System.out.println("ime i prezime=" + e.imePrezime + ", plata=" + e.plata);

        e.plata += 50;

        System.out.println("\nPosle povisice");
        System.out.println("ime i prezime=" + e.imePrezime + ", plata=" + e.plata);
    }
}

