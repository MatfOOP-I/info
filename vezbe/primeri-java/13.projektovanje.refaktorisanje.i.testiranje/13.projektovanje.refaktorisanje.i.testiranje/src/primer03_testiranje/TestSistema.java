package primer03_testiranje;

import primer02_refaktorisano_resenje.model.Automobil;
import primer02_refaktorisano_resenje.model.Korisnik;
import primer02_refaktorisano_resenje.model.Rezervacija;
import primer02_refaktorisano_resenje.obracun.StandardniObracun;
import primer02_refaktorisano_resenje.servis.RezervacijaException;
import primer02_refaktorisano_resenje.servis.SistemIznajmljivanja;

public class TestSistema {

    public static void pokreni() {
        testIstoVoziloNeMozeDvaput();
        testOtkazivanjeOslobadjaVozilo();
    }

    private static void testIstoVoziloNeMozeDvaput() {
        SistemIznajmljivanja sistem =
                pripremiSistem();

        Korisnik korisnik =
                new Korisnik("K-1", "Ana");

        try {
            sistem.napraviRezervaciju(
                    korisnik,
                    "BG-TEST",
                    1,
                    new StandardniObracun()
            );

            boolean drugaRezervacijaOdbijena = false;

            try {
                sistem.napraviRezervaciju(
                        korisnik,
                        "BG-TEST",
                        1,
                        new StandardniObracun()
                );
            } catch (RezervacijaException e) {
                drugaRezervacijaOdbijena = true;
            }

            Provera.tacno(
                    drugaRezervacijaOdbijena,
                    "Zauzeto vozilo ne sme ponovo da se rezerviše"
            );

        } catch (RezervacijaException e) {
            throw new AssertionError(
                    "Prva rezervacija je morala da uspe.",
                    e
            );
        }
    }

    private static void testOtkazivanjeOslobadjaVozilo() {
        SistemIznajmljivanja sistem =
                pripremiSistem();

        Korisnik korisnik =
                new Korisnik("K-2", "Marko");

        try {
            Rezervacija prva =
                    sistem.napraviRezervaciju(
                            korisnik,
                            "BG-TEST",
                            1,
                            new StandardniObracun()
                    );

            prva.otkazi();

            Rezervacija druga =
                    sistem.napraviRezervaciju(
                            korisnik,
                            "BG-TEST",
                            2,
                            new StandardniObracun()
                    );

            Provera.jednako(
                    "KREIRANA",
                    druga.trenutnoStanje(),
                    "Vozilo se može rezervisati posle otkazivanja"
            );

        } catch (RezervacijaException e) {
            throw new AssertionError(
                    "Rezervacija je trebalo da uspe.",
                    e
            );
        }
    }

    private static SistemIznajmljivanja pripremiSistem() {
        SistemIznajmljivanja sistem =
                new SistemIznajmljivanja();

        sistem.dodajVozilo(
                new Automobil(
                        "BG-TEST",
                        "Test automobil",
                        5000
                )
        );

        return sistem;
    }
}
