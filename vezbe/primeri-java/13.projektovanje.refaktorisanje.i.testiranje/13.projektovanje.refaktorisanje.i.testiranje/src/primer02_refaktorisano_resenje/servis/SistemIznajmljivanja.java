package primer02_refaktorisano_resenje.servis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import primer02_refaktorisano_resenje.model.Korisnik;
import primer02_refaktorisano_resenje.model.Rezervacija;
import primer02_refaktorisano_resenje.model.Vozilo;
import primer02_refaktorisano_resenje.obracun.NacinObracunaCene;

/**
 * Odgovornost sistema je koordinacija kolekcija i kreiranje rezervacije.
 *
 * Sistem više ne zna:
 *
 * - kako konkretno vozilo računa depozit;
 * - kako se konkretno računa cena;
 * - koje su tranzicije stanja dozvoljene.
 */
public class SistemIznajmljivanja {
    private final Map<String, Vozilo> vozila =
            new HashMap<>();

    private final List<Rezervacija> rezervacije =
            new ArrayList<>();

    private int sledeciBrojRezervacije = 1;

    public void dodajVozilo(Vozilo vozilo) {
        vozila.put(vozilo.getOznaka(), vozilo);
    }

    public Rezervacija napraviRezervaciju(
            Korisnik korisnik,
            String oznakaVozila,
            int brojDana,
            NacinObracunaCene nacinObracuna
    ) throws RezervacijaException {

        Vozilo vozilo = vozila.get(oznakaVozila);

        if (vozilo == null) {
            throw new RezervacijaException(
                    "Vozilo sa oznakom "
                            + oznakaVozila
                            + " ne postoji."
            );
        }

        if (!vozilo.isDostupno()) {
            throw new RezervacijaException(
                    "Vozilo trenutno nije dostupno."
            );
        }

        try {
            Rezervacija rezervacija =
                    new Rezervacija(
                            sledeciBrojRezervacije++,
                            korisnik,
                            vozilo,
                            brojDana,
                            nacinObracuna
                    );

            vozilo.rezervisi();
            rezervacije.add(rezervacija);

            return rezervacija;
        } catch (IllegalArgumentException
                 | IllegalStateException e) {
            throw new RezervacijaException(
                    e.getMessage()
            );
        }
    }

    public Rezervacija pronadji(int broj)
            throws RezervacijaException {

        for (Rezervacija rezervacija : rezervacije) {
            if (rezervacija.getBroj() == broj) {
                return rezervacija;
            }
        }

        throw new RezervacijaException(
                "Rezervacija ne postoji."
        );
    }

    public List<Rezervacija> getRezervacije() {
        return List.copyOf(rezervacije);
    }
}
