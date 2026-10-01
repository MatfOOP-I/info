package primer03_testiranje;

import primer02_refaktorisano_resenje.model.Automobil;
import primer02_refaktorisano_resenje.model.Korisnik;
import primer02_refaktorisano_resenje.model.Rezervacija;
import primer02_refaktorisano_resenje.obracun.StandardniObracun;
import primer02_refaktorisano_resenje.stanje
        .NedozvoljenaOperacijaException;

public class TestZivotnogCiklusa {

    public static void pokreni() {
        testIspravnogToka();
        testNedozvoljenogOtkazivanja();
    }

    private static Rezervacija novaRezervacija() {
        Korisnik korisnik =
                new Korisnik("TEST-K", "Test");

        Automobil automobil =
                new Automobil(
                        "TEST-AUTO",
                        "Test automobil",
                        4000
                );

        /*
         * U realnom sistemu servis rezerviše vozilo.
         * U ovom izolovanom testu pripremamo objekat direktno.
         */

        return new Rezervacija(
                1,
                korisnik,
                automobil,
                2,
                new StandardniObracun()
        );
    }

    private static void testIspravnogToka() {
        Rezervacija rezervacija =
                novaRezervacija();

        Provera.jednako(
                "KREIRANA",
                rezervacija.trenutnoStanje(),
                "Početno stanje"
        );

        rezervacija.preuzmi();

        Provera.jednako(
                "AKTIVNA",
                rezervacija.trenutnoStanje(),
                "Posle preuzimanja"
        );

        rezervacija.vrati();

        Provera.jednako(
                "ZAVRSENA",
                rezervacija.trenutnoStanje(),
                "Posle vraćanja"
        );

        Provera.tacno(
                rezervacija.getVozilo().isDostupno(),
                "Vozilo treba ponovo da bude dostupno"
        );
    }

    private static void testNedozvoljenogOtkazivanja() {
        Rezervacija rezervacija =
                novaRezervacija();

        rezervacija.preuzmi();
        rezervacija.vrati();

        boolean izuzetakBacen = false;

        try {
            rezervacija.otkazi();
        } catch (NedozvoljenaOperacijaException e) {
            izuzetakBacen = true;
        }

        Provera.tacno(
                izuzetakBacen,
                "Završena rezervacija ne sme da se otkaže"
        );
    }
}
