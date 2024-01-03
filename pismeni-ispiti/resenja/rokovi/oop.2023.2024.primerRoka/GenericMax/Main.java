package PrimerIspita;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Tacka> tackice = new ArrayList<>();
        tackice.add(new Tacka(1, 2));
        tackice.add(new Tacka(1, 3));
        tackice.add(new Tacka(5, 9));
        tackice.add(new Tacka(3, 2));
        tackice.add(new Tacka(5, 7));
        MaxFinder<Tacka> finder = new MaxFinder<>(Tacka.poXPaPoY);
        Optional<Tacka> maxTacka = finder.findMax(tackice);
        if (maxTacka.isPresent()){
            System.out.println(maxTacka.get());
        }
        else{
            System.out.println("Nije moguce naci max");
        }
    }
}
