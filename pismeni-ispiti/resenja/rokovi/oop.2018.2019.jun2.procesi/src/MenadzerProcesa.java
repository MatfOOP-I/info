import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class MenadzerProcesa {

    private Map<Integer, Proces> procesi;


    public MenadzerProcesa() {
        this.procesi = new TreeMap<>();
    }


    public boolean ucitajProcese(String putanja) {
        try {
            List<String> linije = Files.readAllLines(Paths.get(putanja));
            for (String linija : linije) {
                String[] delovi = linija.split(" *, *");
                if (delovi.length < 4)
                    continue;

                int pid = Integer.parseInt(delovi[1]);
                String naziv = delovi[2];
                int mb = Integer.parseInt(delovi[3]);


                Proces p;
                if (delovi[0].equals("A") && delovi.length > 4) {
                    p = new AktivanProces(pid, naziv, mb, Integer.parseInt(delovi[4]));
                } else if (delovi[0].equals("P")) {
                    if (delovi.length > 4 && delovi[4].equals("sys"))
                        p = new PozadinskiProces(pid, naziv, mb, true);
                    else
                        p = new PozadinskiProces(pid, naziv, mb, false);
                } else {
                    throw new Exception("Los format datoteke!");
                }

                procesi.put(pid, p);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Proces> entry : procesi.entrySet()) {
            Proces p = entry.getValue();
            if (p instanceof AktivanProces)
                sb.append('+');
            else if (p instanceof PozadinskiProces)
                sb.append('-');
            sb.append(' ');
            sb.append(p.toString());
            sb.append('\n');
        }
        return sb.toString();
    }

    public Proces memorijskiNajzahtevniji(int gornjaGranica) {
        Optional<Proces> maxp;
        if (gornjaGranica != 0) {
            maxp = this.procesi.values().stream()
                    .filter(p -> p.getMB() < gornjaGranica)
                    .max(Comparator.comparingInt(Proces::getMB));
        } else {
            maxp = this.procesi.values().stream()
                    .max(Comparator.comparingInt(Proces::getMB));
        }
        if (maxp.isPresent())
            return maxp.get();
        else
            return null;
    }

    public List<Proces> sistemskiProcesi() {
        return this.procesi.values().stream()
                .filter(p -> p instanceof PozadinskiProces && ((PozadinskiProces)p).isSys())
                .collect(Collectors.toList());
    }

    public int ukupnaIskoriscenostCPU() {
        return this.procesi.values().stream()
                .filter(p -> p instanceof AktivanProces)
                .mapToInt(p -> ((AktivanProces) p).getIskoriscenostCPU())
                .sum();
    }

    public boolean zaustaviProces(int pid) {
        if (this.procesi.get(pid) == null)
            return false;
        this.procesi.remove(pid);
        return true;
    }

    public List<Proces> getProcesi() {
        return new ArrayList<Proces>(this.procesi.values());
    }
}
