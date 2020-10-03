package rs.math.oop1.z090401.anonimneUnutrasnje.z02.zaposleniSortiranje;

import java.util.*;

public class PokretanjeZaposleniUredjenje {
    public static void main(String[] args) {
        Zaposleni[] osoblje = new Zaposleni[4];

        osoblje[0] = new Zaposleni("Marko Markovic", 35000);
        osoblje[1] = new Zaposleni("Janko Jankovic", 75000);
        osoblje[2] = new Zaposleni("Tony Tester", 38000);
        osoblje[3] = new Zaposleni("Milena Milenkovic", 18000);

        System.out.println("-Pre sortiranja-");
        for (Zaposleni e : osoblje)
            System.out.println("ime=" + e.getIme() + ",plata=" + e.getPlata());

        System.out.println("-Po imenu-");
        Arrays.sort(osoblje, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (!(o1 instanceof Zaposleni))
                    return 1;
                if (!(o2 instanceof Zaposleni))
                    return -1;
                Zaposleni e1 = (Zaposleni) o1;
                Zaposleni e2 = (Zaposleni) o2;
                return e1.getIme().compareTo(e2.getIme());
            }
        });
        for (Zaposleni e : osoblje)
            System.out.println("ime=" + e.getIme() + ",plata=" + e.getPlata());

        System.out.println("-Po imenu obratno-");
        Arrays.sort(osoblje, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (!(o1 instanceof Zaposleni))
                    return 1;
                if (!(o2 instanceof Zaposleni))
                    return -1;
                Zaposleni e1 = (Zaposleni) o1;
                Zaposleni e2 = (Zaposleni) o2;
                return e2.getIme().compareTo(e1.getIme());
            }
        });
        for (Zaposleni e : osoblje)
            System.out.println("ime=" + e.getIme() + ",plata=" + e.getPlata());

        System.out.println("-Po plati-");
        Arrays.sort(osoblje, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (!(o1 instanceof Zaposleni))
                    return 1;
                if (!(o2 instanceof Zaposleni))
                    return -1;
                Zaposleni e1 = (Zaposleni) o1;
                Zaposleni e2 = (Zaposleni) o2;
                if (e1.getPlata() > e2.getPlata())
                    return -1;
                if (e1.getPlata() < e2.getPlata())
                    return 1;
                return 0;

            }
        });
        for (Zaposleni e : osoblje)
            System.out.println("ime=" + e.getIme() + ",plata=" + e.getPlata());

        // Zasad ovo nismo detaljno objasnili - ali radi :)
        System.out.println("-Po imenu (lambda)-");
        Arrays.sort(osoblje, (e1, e2) ->  e2.getIme().compareTo(e1.getIme()) );
        for (Zaposleni e : osoblje)
            System.out.println("ime=" + e.getIme() + ",plata=" + e.getPlata());

    }
}
