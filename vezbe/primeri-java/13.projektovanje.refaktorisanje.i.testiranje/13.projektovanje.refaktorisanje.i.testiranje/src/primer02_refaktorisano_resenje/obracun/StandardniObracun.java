package primer02_refaktorisano_resenje.obracun;

import primer02_refaktorisano_resenje.model.Vozilo;

public class StandardniObracun implements NacinObracunaCene {
    @Override
    public int izracunaj(Vozilo vozilo, int brojDana) {
        return vozilo.getCenaPoDanu() * brojDana;
    }

    @Override
    public String naziv() {
        return "standardni";
    }
}
