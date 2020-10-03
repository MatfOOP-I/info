package podmornice;

import java.util.Random;

public class Racunar extends Igrac {
    private static Random random = new Random();

    @Override
    public boolean inicijalizuj() {
        int i = 0;

        while (i < 5) {
            i++;
            char pravac = random.nextBoolean()? 'd' : 'r';

            Polje k = generisiKoordinatu(pravac, i);
            while (imaPoklapanja(k))
                k = generisiKoordinatu(pravac, i);

            this.dodajPodmornicu(new Podmornica(k, pravac, i));

        }

        return true;
    }

    private Polje generisiKoordinatu(char pravac, int velicina) {
        int x, y;
        if (pravac == 'd') {
            x = random.nextInt(10 - velicina);
            y = random.nextInt(10);
        }
        else {
            x = random.nextInt(10);
            y = random.nextInt(10 - velicina);
        }
        return new Polje(x, y);
    }

    private boolean imaPoklapanja(Polje k) {

        for (Podmornica p : getPodmornice().keySet()) {
            if (p.getZauzetaPolja().keySet().contains(k))
                return true;
        }

        return false;
    }
}
