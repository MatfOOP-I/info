package klasifikacija;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NasumicniKlasifikator extends Klasifikator
{
    public NasumicniKlasifikator(List<Podatak> podaci)
    {
        super(podaci);
    }

    @Override
    public List<Pol> klasifikuj()
    {
        List<Pol> predikcija = new ArrayList<>();
        Random random = new Random();
        random.setSeed(42);

        for (int i = 0; i < getPodaci().size(); i++)
        {
            if (random.nextDouble() < 0.5)
                predikcija.add(Pol.MUSKO);
            else
                predikcija.add(Pol.ZENSKO);
        }

        return predikcija;
    }

    @Override
    public String toString()
    {
        return "Nasumicni klasifikator";
    }
}
