package primer07_lambda;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import primer06_comparator.Pesma;
import primer06_comparator.PoredjenjePoTrajanju;
public class Main {
    public static void main(String[] args) {
        List<Pesma> pesme = new ArrayList<>();
        pesme.add(new Pesma("Duga", "A", 200));
        pesme.add(new Pesma("Kratka", "B", 100));
        // 1. Imenovana klasa.
        Comparator<Pesma> imenovani = new PoredjenjePoTrajanju();
        // 2. Anonimna klasa sa istim ugovorom.
        Comparator<Pesma> anonimni = new Comparator<>() {
            @Override public int compare(Pesma a, Pesma b) {
                return Integer.compare(a.getTrajanjeSekundi(), b.getTrajanjeSekundi());
            }
        };
        // 3. Lambda za funkcionalni interfejs: jedna apstraktna operacija.
        Comparator<Pesma> lambda = (a, b) ->
                Integer.compare(a.getTrajanjeSekundi(), b.getTrajanjeSekundi());
        pesme.sort(imenovani);
        pesme.sort(anonimni);
        pesme.sort(lambda);
        for (Pesma p : pesme) System.out.println(p.opis());
        // Lambda nije anonimna klasa sa identičnom semantikom (npr. this).
        // Ovde nam je dovoljno da oba oblika implementiraju isti ugovor.
    }
}
