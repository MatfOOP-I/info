package primer01_pocetni_kod;

public class Main {
    public static void main(String[] args) {
        SistemIznajmljivanja sistem =
                new SistemIznajmljivanja();

        sistem.dodajVozilo(
                new Vozilo(
                        "BG-101",
                        "AUTOMOBIL",
                        "Škoda Octavia",
                        5000
                )
        );

        sistem.dodajVozilo(
                new Vozilo(
                        "BIKE-7",
                        "BICIKL",
                        "Gradski bicikl",
                        800
                )
        );

        Korisnik ana =
                new Korisnik("K-1", "Ana");

        Rezervacija rezervacija =
                sistem.napraviRezervaciju(
                        ana,
                        "BG-101",
                        2,
                        "CLANSKI"
                );

        if (rezervacija != null) {
            System.out.println(
                    "Cena: "
                            + rezervacija.getUkupnaCena()
                            + " din."
            );

            sistem.preuzmi(rezervacija.getBroj());
            sistem.vrati(rezervacija.getBroj());

            System.out.println(
                    "Status: " + rezervacija.getStatus()
            );
        }

        /*
         * Pitanja pre otvaranja refaktorisanog rešenja:
         *
         * 1. Šta menjamo da dodamo ELEKTRICNI_TROTINET?
         * 2. Šta menjamo da dodamo VIKEND obračun?
         * 3. Gde zapravo pripada pravilo depozita?
         * 4. Ko treba da zna koje su tranzicije statusa dozvoljene?
         * 5. Zašto bilo ko sme da pozove setDostupno(true)?
         */
    }
}
