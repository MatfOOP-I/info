package primer01_pocetni_kod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Program radi, ali ova klasa ima mnogo različitih odgovornosti.
 *
 * Tokom časa treba postaviti pitanje:
 *
 * "Koji deo ovog ponašanja zaista pripada sistemu,
 * a koji pripada drugim objektima?"
 */
public class SistemIznajmljivanja {
    private final Map<String, Vozilo> vozila = new HashMap<>();
    private final List<Rezervacija> rezervacije = new ArrayList<>();
    private int sledeciBrojRezervacije = 1;

    public void dodajVozilo(Vozilo vozilo) {
        vozila.put(vozilo.getOznaka(), vozilo);
    }

    public Rezervacija napraviRezervaciju(
            Korisnik korisnik,
            String oznakaVozila,
            int brojDana,
            String tipObracuna
    ) {
        Vozilo vozilo = vozila.get(oznakaVozila);

        if (vozilo == null) {
            System.out.println("Vozilo ne postoji.");
            return null;
        }

        if (!vozilo.isDostupno()) {
            System.out.println("Vozilo nije dostupno.");
            return null;
        }

        if (brojDana <= 0) {
            System.out.println("Broj dana mora biti pozitivan.");
            return null;
        }

        /*
         * Sistem zna sve vrste obračuna.
         * Svaki novi način obračuna širi ovo grananje.
         */
        int cena;

        if (tipObracuna.equals("STANDARDNI")) {
            cena = vozilo.getCenaPoDanu() * brojDana;
        } else if (tipObracuna.equals("CLANSKI")) {
            cena = vozilo.getCenaPoDanu() * brojDana * 90 / 100;
        } else {
            System.out.println("Nepoznat tip obračuna.");
            return null;
        }

        /*
         * Sistem zna i kako se depozit razlikuje po vrsti vozila.
         */
        int depozit;

        if (vozilo.getTip().equals("AUTOMOBIL")) {
            depozit = vozilo.getCenaPoDanu() * 2;
        } else if (vozilo.getTip().equals("BICIKL")) {
            depozit = 0;
        } else {
            depozit = vozilo.getCenaPoDanu();
        }

        System.out.println("Depozit: " + depozit + " din.");

        Rezervacija rezervacija = new Rezervacija(
                sledeciBrojRezervacije++,
                korisnik,
                vozilo,
                brojDana,
                tipObracuna,
                cena
        );

        rezervacije.add(rezervacija);

        /*
         * Bilo ko ko ima Vozilo može pozvati setDostupno(...).
         */
        vozilo.setDostupno(false);

        return rezervacija;
    }

    public void preuzmi(int brojRezervacije) {
        Rezervacija rezervacija = pronadji(brojRezervacije);

        if (rezervacija == null) {
            return;
        }

        if (!rezervacija.getStatus().equals("KREIRANA")) {
            System.out.println("Rezervacija ne može da se preuzme.");
            return;
        }

        rezervacija.setStatus("AKTIVNA");
    }

    public void vrati(int brojRezervacije) {
        Rezervacija rezervacija = pronadji(brojRezervacije);

        if (rezervacija == null) {
            return;
        }

        if (!rezervacija.getStatus().equals("AKTIVNA")) {
            System.out.println("Rezervacija ne može da se završi.");
            return;
        }

        rezervacija.setStatus("ZAVRSENA");
        rezervacija.getVozilo().setDostupno(true);
    }

    public void otkazi(int brojRezervacije) {
        Rezervacija rezervacija = pronadji(brojRezervacije);

        if (rezervacija == null) {
            return;
        }

        if (!rezervacija.getStatus().equals("KREIRANA")) {
            System.out.println("Rezervacija ne može da se otkaže.");
            return;
        }

        rezervacija.setStatus("OTKAZANA");
        rezervacija.getVozilo().setDostupno(true);
    }

    public Rezervacija pronadji(int brojRezervacije) {
        for (Rezervacija rezervacija : rezervacije) {
            if (rezervacija.getBroj() == brojRezervacije) {
                return rezervacija;
            }
        }

        System.out.println("Rezervacija ne postoji.");
        return null;
    }
}
