package klasifikacija;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Podatak
{
    private int visina, tezina;
    private Pol pol;

    // Metod koji je potrebno  implementirati u kasnijem delu ispita.
    public static List<Podatak> ucitajPodatke()
    {
        List<Podatak> podaci = new ArrayList<>();

        try
        {
            List<String> linije = Files.readAllLines(Paths.get("podaci.txt"));
            for (String linija: linije)
            {
                String[] tokeni = linija.split(",");
                int visina = Integer.parseInt(tokeni[0].trim());
                int tezina = Integer.parseInt(tokeni[1].trim());
                Pol p = Pol.createFromString(tokeni[2].trim());
                podaci.add(new Podatak(visina, tezina, p));
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (NumberFormatException e)
        {
            System.out.println("Failed converting to number...");
        }

        return podaci;
    }

    public Podatak(int visina, int tezina, Pol pol)
    {
        this.visina = visina;
        this.tezina = tezina;
        this.pol = pol;
    }

    public int getVisina()
    {
        return visina;
    }

    public int getTezina()
    {
        return tezina;
    }

    public Pol getPol()
    {
        return pol;
    }

    @Override
    public String toString()
    {
        return visina + " " + tezina + " " + pol;
    }
}
