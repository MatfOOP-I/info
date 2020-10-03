package pokemoni;

import java.util.Random;

public class Neprijatelj extends Pokemon {
    private static Random random = new Random();

    public Neprijatelj(String ime, int nivo, Magija magija1, Magija magija2) {
        super(ime, nivo, magija1, magija2);
    }

    @Override
    public void baciMagiju(Pokemon neprijatelj) {
        if (random.nextFloat() <= 0.5f) {
            neprijatelj.nanesiStetu(getMagija1().getSnaga());
            setPoslednjaBacena(getMagija1());
        }
        else {
            neprijatelj.nanesiStetu(getMagija2().getSnaga());
            setPoslednjaBacena(getMagija2());
        }
    }

    @Override
    public String toString() {
        return "[ai] " + super.toString();
    }
}
