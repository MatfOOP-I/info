package busplus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class GSPVozilo {
    private Map<Integer, BusPlus> kartice;
    private List<Integer> nevalidne;

    private static Random random = new Random();
    private static int noviId = 10000;

    public GSPVozilo() {
        this.kartice = new TreeMap<>();
        this.nevalidne = new ArrayList<>();
    }

    public List<BusPlus> getKartice() {
        return new ArrayList<>(kartice.values());
    }

    public boolean putniciUVozilu(String putanja) {
        try {
            List<String> linije = Files.readAllLines(Paths.get(putanja));
            for(String linija : linije) {
                String[] delovi = linija.split(", ");

                int id = Integer.parseInt(delovi[1]);
                int zona = Integer.parseInt(delovi[2]);

                if(delovi[0].equals("P")){
                    String kategorija = delovi[3];
                    String imaDopunu = delovi[4];
                    kartice.put(id, new Personalizovana(id, zona, Kategorija.valueOf(kategorija),
                            (imaDopunu.equals("da") ? true : false)));
                } else {
                    String ocitana = delovi[4];
                    kartice.put(id, new Nepersonalizovana(id, zona, Integer.parseInt(delovi[3]),
                            (ocitana.equals("+") ? true : false)));
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public BusPlus noviPutnik(int vrstaKartice) {
        BusPlus novaKartica = null;
        if(vrstaKartice == 1) {
            int kategorija = random.nextInt(Kategorija.values().length);
            boolean imaDopunu = random.nextBoolean();
            novaKartica = new Personalizovana(noviId, vrstaKartice, Kategorija.izBroja(kategorija), imaDopunu);
        }
        else {
            int kredit = random.nextInt(2* Nepersonalizovana.cena_voznje+1);
            novaKartica = new Nepersonalizovana(noviId, vrstaKartice, kredit, false);
            ((Nepersonalizovana) novaKartica).ocitajKartu();
        }

        kartice.put(noviId, novaKartica);
        noviId++;
        return novaKartica;
    }


    public String kontrola() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, BusPlus> e : kartice.entrySet()) {
            BusPlus k = e.getValue();
            if (k instanceof Personalizovana) {
                if(((Personalizovana) k).imaDopunu())
                    sb.append("+");
                else {
                    sb.append("-");
                    nevalidne.add(e.getKey());
                }
            }
            else if (k instanceof Nepersonalizovana) {
                if(((Nepersonalizovana) k).isOcitana())
                    sb.append("+");
                else {
                    sb.append("-");
                    nevalidne.add(e.getKey());
                }
            }
            sb.append(' ');
            sb.append(k.toString());
            sb.append('\n');
        }
        return sb.toString();
    }

    public boolean izbaciPutnike() {
        if(nevalidne.isEmpty())
            return false;
        for(Integer id : nevalidne)
            kartice.remove(id);
        return true;
    }

}
