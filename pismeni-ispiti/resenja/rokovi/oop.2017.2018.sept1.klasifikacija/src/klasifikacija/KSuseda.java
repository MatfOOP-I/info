package klasifikacija;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KSuseda extends Klasifikator
{
    private int brojSuseda;

    public KSuseda(List<Podatak> podaci, int brojSuseda)
    {
        super(podaci);
        this.brojSuseda = brojSuseda;
    }

    @Override
    public List<Pol> klasifikuj()
    {
        List<Pol> labele = new ArrayList<>();

        // Za svak podatak pravimo predikciju
        for (int i = 0; i < getPodaci().size(); i++)
        {
            // Izracunavamo rastojanje tekuceg podataka do svih ostalih
            // KOMENTAR: I do samog sebe, ali cemo ignorisati vrednost
            List<KSusedaPar> rastojanja = new ArrayList<>();
            for (int j = 0; j < getPodaci().size(); j++)
            {
                double d = Rastojanje.izracunajRastojanje(getPodaci().get(i), getPodaci().get(j));
                rastojanja.add(new KSusedaPar(j, d));
            }

            // Sortiramo po rastojanju
            Collections.sort(rastojanja);

            for (KSusedaPar par: rastojanja)
                System.out.println(par.getRastojanje());
            System.out.println("-------");

            // Prolazimo kroz prvih k i brojimo koliko puta se koji pol pojavio
            int brojMuskih = 0, brojZenskih = 0;
            for (int k = 0; k < brojSuseda && k < rastojanja.size(); k++)
            {
                if (rastojanja.get(k).getIndeksUPodacima() == i)
                    continue;

                if (getPodaci().get(rastojanja.get(k).getIndeksUPodacima()).getPol() == Pol.MUSKO) brojMuskih++;
                else if (getPodaci().get(rastojanja.get(k).getIndeksUPodacima()).getPol() == Pol.ZENSKO) brojZenskih++;
                else
                {
                    System.out.println("PROBLEM! :(");
                }
            }

            // Upisujemo labelu za tekuci podatak
            if (brojMuskih > brojZenskih) labele.add(Pol.MUSKO);
            else labele.add(Pol.ZENSKO);
        }

        return labele;
    }

    @Override
    public String toString()
    {
        return "Klasifikator K najblizih suseda, brojSuseda=" + brojSuseda;
    }
}
