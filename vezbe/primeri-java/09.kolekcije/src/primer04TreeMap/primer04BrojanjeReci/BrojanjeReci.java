package primer04TreeMap.primer04BrojanjeReci;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/*
    Napisati program koji iz datoteke 'input.txt' prebrojava
    pojavljivanja svih reci.
*/
public class BrojanjeReci {

    public static void main(String[] args) {

        /*
            Pravimo mapu koja svakoj reci dodeljuje
            broj pojavljivanja.
        */
        Map<String, Integer> ponavljanjeReci = new TreeMap<>();

        Path ulaznaPutanja = Paths.get("input.txt");
        System.out.println("Ucitavamo datoteku: " + ulaznaPutanja.toAbsolutePath());

        try {
            // Citamo sve linije iz datoteke
            List<String> linije = Files.readAllLines(ulaznaPutanja);

            // Prolazimo liniju po liniju
            for(String linija : linije) {
                // Izdvajamo reci
                String[] reci = linija.split(" ");
                for(String rec : reci) {
                    // Trazimo rec u mapi
                    Integer i = ponavljanjeReci.get(rec);

                    /*
                        Ako ne postoji zadati kljuc get vraca null.
                    */
                    if(i==null) {
                        /*
                            put dodaje novi kljuc u mapu sa
                            zadatom vrednoscu, ako kljuc ne postoji
                         */
                        ponavljanjeReci.put(rec, 1);
                    }
                    /*
                        Ako postoji, uvecavamo broj pojavljivanja
                    */
                    else {
                        /*
                            put postavlja novu vrednost za zadati
                            kljuc, ako se kljuc nalazi u mapi
                         */
                        ponavljanjeReci.put(rec, i+1);
                    }
                }
            }


        } catch (IOException e) {
            System.err.println("Neuspesno citanje datoteke " + ulaznaPutanja.getFileName());
            e.printStackTrace();
        }


        for (Map.Entry<String, Integer> e : ponavljanjeReci.entrySet())
            System.out.println(e.getKey() + ": " + e.getValue());
    }
}
