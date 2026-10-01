package primer02_refaktorisano_resenje.obracun;

import primer02_refaktorisano_resenje.model.Vozilo;

/**
 * Strategy za računanje cene rezervacije.
 */
public interface NacinObracunaCene {
    int izracunaj(Vozilo vozilo, int brojDana);

    String naziv();
}
