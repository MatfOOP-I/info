package vesala;

import java.util.List;
import java.util.Random;

public class KompjuterskiIgrac extends Igrac{

    private Random random;

    public KompjuterskiIgrac(String ime, int nivo, int brOdigranihPartija, int brPobedjenihPartija) {
        super(ime, nivo, brOdigranihPartija, brPobedjenihPartija);
        random = new Random();
    }

    @Override
    public char odaberiSlovo(Rec trazenaRec) {
        while(true){
            char letter = (char)('a' + random.nextInt(26));
            if (!trazenaRec.getIsprobanaSlova().contains(letter))
                return letter;
        }
    }

    public char odaberiSlovoPametno(Rec trazenaRec, List<Rec> recnik) {
        String pogodjenaSlova = trazenaRec.pogodjenaSlovaReci();
        int i;
        for (Rec r : recnik) {
            if (!r.getRec().equals(trazenaRec.getRec()))
                continue;

            for (i = 0; i < r.getRec().length(); i++) {
                if (r.getRec().charAt(i) != '_' && r.getRec().charAt(i) != pogodjenaSlova.charAt(i)) {
                    break;
                }
            }

            if (i == r.getRec().length()) {
                for (int j = 0; j < pogodjenaSlova.length(); j++) {
                    if (pogodjenaSlova.charAt(j) != '_')
                        return pogodjenaSlova.charAt(j);
                }
            }
        }
        return odaberiSlovo(trazenaRec);
    }
}
