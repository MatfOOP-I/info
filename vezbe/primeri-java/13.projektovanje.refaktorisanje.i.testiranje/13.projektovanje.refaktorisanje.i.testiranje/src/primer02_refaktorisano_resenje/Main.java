package primer02_refaktorisano_resenje;

import primer02_refaktorisano_resenje.model.Automobil;
import primer02_refaktorisano_resenje.model.Bicikl;
import primer02_refaktorisano_resenje.model.Korisnik;
import primer02_refaktorisano_resenje.model.Rezervacija;
import primer02_refaktorisano_resenje.obracun.ClanskiObracun;
import primer02_refaktorisano_resenje.obracun.StandardniObracun;
import primer02_refaktorisano_resenje.servis.RezervacijaException;
import primer02_refaktorisano_resenje.servis.SistemIznajmljivanja;

public class Main {
    public static void main(String[] args) {
        SistemIznajmljivanja sistem =
                new SistemIznajmljivanja();

        sistem.dodajVozilo(
                new Automobil(
                        "BG-101",
                        "Škoda Octavia",
                        5000
                )
        );

        sistem.dodajVozilo(
                new Bicikl(
                        "BIKE-7",
                        "Gradski bicikl",
                        800
                )
        );

        Korisnik ana =
                new Korisnik("K-1", "Ana");

        try {
            Rezervacija automobil =
                    sistem.napraviRezervaciju(
                            ana,
                            "BG-101",
                            2,
                            new ClanskiObracun()
                    );

            System.out.println(
                    "Cena: " + automobil.ukupnaCena()
            );

            System.out.println(
                    "Depozit: " + automobil.depozit()
            );

            System.out.println(
                    "Stanje: "
                            + automobil.trenutnoStanje()
            );

            automobil.preuzmi();

            System.out.println(
                    "Stanje: "
                            + automobil.trenutnoStanje()
            );

            automobil.vrati();

            System.out.println(
                    "Stanje: "
                            + automobil.trenutnoStanje()
            );

            /*
             * Druga rezervacija koristi isti servis,
             * ali drugu vrstu vozila i drugu Strategy implementaciju.
             */
            Rezervacija bicikl =
                    sistem.napraviRezervaciju(
                            ana,
                            "BIKE-7",
                            3,
                            new StandardniObracun()
                    );

            System.out.println(
                    "Bicikl, cena: "
                            + bicikl.ukupnaCena()
            );

        } catch (RezervacijaException e) {
            System.out.println(
                    "Rezervacija nije uspela: "
                            + e.getMessage()
            );
        }
    }
}
