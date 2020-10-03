package rs.math.oop1.z180200.lambdaIzrazi.z03.zaposleniSortiranje;

import java.util.*;

public class EmployeeSortTest {
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
        Arrays.sort(osoblje, (x, y) -> x.getIme().compareTo(y.getIme()));
        for (Zaposleni e : osoblje)
            System.out.println("ime=" + e.getIme() + ",plata=" + e.getPlata());

        System.out.println("-Po plati-");
        Arrays.sort(osoblje, (x, y) -> (int) (x.getPlata() - y.getPlata()));
        for (Zaposleni e : osoblje)
            System.out.println("ime=" + e.getIme() + ",plata=" + e.getPlata());
    }
}
