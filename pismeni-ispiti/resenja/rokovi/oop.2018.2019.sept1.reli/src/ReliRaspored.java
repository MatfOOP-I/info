import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class ReliRaspored {
    private List<StavkaRasporeda> redVoznje;
    private int maxVremeVoznje;

    public ReliRaspored(int maxVremeVoznje) {
        this.redVoznje = new ArrayList<>();
        this.maxVremeVoznje = maxVremeVoznje;
    }

    public ReliRaspored() {
        this(30);
    }

    @Override
    public String toString() {
        return String.join("\n", this.redVoznje.stream().map(StavkaRasporeda::toString).collect(Collectors.toList()));
    }

    public boolean ucitaj(String putanja) {
        try {
            List<String> linije = Files.readAllLines(Paths.get(putanja));
            for(String linija : linije) {
                String[] delovi = linija.split(", ");

                int h = Integer.parseInt(delovi[0]);
                int m = Integer.parseInt(delovi[1]);
                String vozacIme = delovi[2];
                String klasa = delovi[3];
                String model = delovi[4];
                int godiste = Integer.parseInt(delovi[5]);
                Pogon pogon = Pogon.izNiske(delovi[6]);

                ReliAuto auto = null;
                switch (klasa) {
                    case "Grupa A":
                        auto = new GrupaAReliAuto(model, pogon, godiste);
                        break;
                    case "Grupa B":
                        auto = new GrupaBReliAuto(model, pogon, godiste, delovi.length > 7);
                        break;
                }
                if (auto == null)
                    return false;

                ReliVozac vozac = new ReliVozac(vozacIme, auto);
                this.redVoznje.add(new StavkaRasporeda(vozac, h, m));
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean dodaj(ReliVozac v, int h, int m) {
        StavkaRasporeda s = new StavkaRasporeda(v, h, m);
        if (this.redVoznje.stream().anyMatch(sr -> s.imaKonfliktSa(sr, this.maxVremeVoznje)))
            return false;
        this.redVoznje.add(s);
        return true;
    }

    public void sortiraj() {
        Collections.sort(this.redVoznje);
    }

    public int brojAutomobilaSaGodistemVecimOd(int g) {
        return (int)this.redVoznje.stream()
                .filter(s -> s.getVozac().getAutomobil().getGodiste() > g)
                .count();
    }

    public List<ReliAuto> saPogonom(Pogon p) {
        return this.redVoznje.stream()
                .map(s -> s.getVozac().getAutomobil())
                .filter(a -> a.getTipPogona() == p)
                .collect(Collectors.toList());
    }
}
