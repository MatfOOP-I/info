package primer02_refaktorisano_resenje.obracun;

import primer02_refaktorisano_resenje.model.Vozilo;

/**
 * Članovi imaju 10% popusta.
 */
public class ClanskiObracun implements NacinObracunaCene {
    @Override
    public int izracunaj(Vozilo vozilo, int brojDana) {
        int osnovnaCena =
                vozilo.getCenaPoDanu() * brojDana;

        return osnovnaCena * 90 / 100;
    }

    @Override
    public String naziv() {
        return "članski";
    }
}
