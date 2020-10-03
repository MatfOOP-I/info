package rs.math.oop1.z150304.operacijaPomocuIteratora.z02.uklanjanje;

import java.util.*;

public class LinkedListTest {
    public static void main(String[] args) {
        List<String> a = new LinkedList<String>();
        a.add("Erica");
        a.add("Amy");
        a.add("Carl");
        a.add(2, "Bob");
        a.add(1, "Damir");
        // sortiranje kolekcije, anonimna klasa
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.compareTo(s1);
            }
        });
        System.out.println(a);

        // sortiranje kolekcije, lambda izraz
        Collections.sort(a, (s1, s2) -> s1.compareTo(s2));
        System.out.println(a);

        List<String> b = new ArrayList<String>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");
        System.out.println(b);

        // kreiranje jedne kolekcije na osnovu druge
        List<String> bb = new LinkedList<>(b);
        System.out.println(bb);

        // uklanjanje svakog drugog elementa iz b
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();
        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next(); // skip one element
            if (bIter.hasNext()) {
                bIter.next(); // skip next element
                bIter.remove(); // remove that element
            }
        }
        System.out.println(b);

        // uklanjanje svih elemenata iz b
        a.removeAll(b);
        System.out.println(a);
    }
}
