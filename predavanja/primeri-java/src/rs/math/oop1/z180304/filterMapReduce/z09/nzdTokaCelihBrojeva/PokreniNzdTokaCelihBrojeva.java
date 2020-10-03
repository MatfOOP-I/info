package rs.math.oop1.z180304.filterMapReduce.z09.nzdTokaCelihBrojeva;

import java.util.Arrays;
import java.util.List;

public class PokreniNzdTokaCelihBrojeva {
    static int NZD(int prvi, int drugi) {
        while (true)
            if (prvi > drugi)
                // први је већи
                if (prvi % drugi == 0)
                    return drugi;
                else
                    prvi %= drugi;
            else
                // први је мањи или једнак
                if (drugi % prvi == 0)
                    return prvi;
                else
                    drugi %= prvi;
    }

    public static void main(String[] args) {
        // креирај низовну листу
        Integer[] niz = {24, 48, -96, 192, 36, 72, 144};
        //List<Integer> brojevi = new ArrayList<>();
        //for (int broj : niz)
        //    brojevi.add(broj);
        List<Integer> brojevi = Arrays.asList(niz);
        // прикажи креирану листу
        System.out.print("Колекција: ");
        brojevi.stream().forEach(z -> System.out.print(z + " "));
        System.out.println();
        // претвори негативне у позитивне и прикажи резултат
        System.out.print("Колекција позитивних: ");
        brojevi.stream().map(x -> (x >= 0) ? x : -x).forEach(z -> System.out.print(z + " "));
        System.out.println();
        // одреди НЗД за ток одговарајућих позитивних
        final int nzd = brojevi.stream().map(x -> (x >= 0) ? x : -x)
                .reduce(brojevi.get(0), (x, y) -> NZD(x, y));
        // прикажи израчунати НЗД
        System.out.println("НЗД колекције је: " + nzd);
    }
}
