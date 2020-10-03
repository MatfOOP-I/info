package rs.math.oop1.z120500.generickiInterfejs.z03.zaposleni;

import rs.math.oop1.z090401.anonimneUnutrasnje.z02.zaposleniSortiranje.Zaposleni;

import java.util.Arrays;
import java.util.Comparator;

public class EmployeeSortTest2 {
    public static void main(String[] args) {
        Zaposleni[] osoblje = new Zaposleni[4];

        osoblje[0] = new Zaposleni("Marko Markovic", 35000);
        osoblje[1] = new Zaposleni("Janko Jankovic", 75000);
        osoblje[2] = new Zaposleni("Tony Tester", 38000);
        osoblje[3] = new Zaposleni("Milena Milenkovic", 18000);

        System.out.println("-Pre sortiranja-");
        for (Zaposleni e : osoblje)
            System.out.println(e);

        System.out.println("-Po imenu-");
        Arrays.sort(osoblje, new Comparator<Zaposleni>() {
            @Override
            public int compare(Zaposleni e1, Zaposleni e2) {
                return e1.getIme().compareTo(e2.getIme());
            }
        });
        for (Zaposleni e : osoblje)
            System.out.println(e);

        System.out.println("-Po imenu obratno-");
        Arrays.sort(osoblje, new Comparator<Zaposleni>() {
            @Override
            public int compare(Zaposleni e1, Zaposleni e2) {
                   return - e1.getIme().compareTo(e2.getIme());
            }
        });
        for (Zaposleni e : osoblje)
            System.out.println(e);

        System.out.println("-Po plati-");
        Arrays.sort(osoblje, new Comparator<Zaposleni>() {
            @Override
            public int compare(Zaposleni o1, Zaposleni o2) {
                if (o1.getPlata() > o2.getPlata())
                    return -1;
                if (o1.getPlata() < o2.getPlata())
                    return 1;
                return 0;
            }
        });
        for (Zaposleni e : osoblje)
            System.out.println(e);

        // Zasad ovo nismo detaljno objasnili - ali radi :)
        System.out.println("-Po imenu obratno (lambda)-");
        Arrays.sort(osoblje, (e1, e2) ->
                e2.getIme().compareTo(e1.getIme()) );
        for (Zaposleni e : osoblje)
            System.out.println(e);

    }
}
