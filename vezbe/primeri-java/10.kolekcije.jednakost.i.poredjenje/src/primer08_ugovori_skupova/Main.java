package primer08_ugovori_skupova;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import primer06_comparator.Pesma;
import primer06_comparator.PoredjenjePoTrajanju;
public class Main {
    public static void main(String[] args) {
        Pesma a = new Pesma("Prva", "A", 180);
        Pesma b = new Pesma("Druga", "B", 180);
        Set<Pesma> hash = new HashSet<>();
        Set<Pesma> prirodni = new TreeSet<>();
        Set<Pesma> poTrajanju = new TreeSet<>(new PoredjenjePoTrajanju());
        for (Pesma p : new Pesma[]{a, b}) {
            hash.add(p); prirodni.add(p); poTrajanju.add(p);
        }
        System.out.println(hash.size());       // 2
        System.out.println(prirodni.size());   // 2
        System.out.println(poTrajanju.size()); // 1!
        // Comparator po trajanju je pogodan za sortiranje liste.
        // U TreeSet-u 0 označava isti element iz perspektive skupa.
        // Zato taj Comparator nije dobar izbor za skup svih različitih pesama.
    }
}
