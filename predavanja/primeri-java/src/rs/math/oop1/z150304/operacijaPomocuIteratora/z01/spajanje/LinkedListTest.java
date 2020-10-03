package rs.math.oop1.z150304.operacijaPomocuIteratora.z01.spajanje;

import java.util.*;

public class LinkedListTest {
    public static void main(String[] args) {
        List<String> a = new LinkedList<String>();
        a.add("Erica");
        a.add("Amy");
        a.add("Carl");
        a.add(2, "Bob");
        a.add("Damir");
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

        // spajanje dve kolekcije - na kraj a se nalepljuje b
        List<String> aa = new ArrayList<String>(a);
        ListIterator<String> aaIter = aa.listIterator();
        while (aaIter.hasNext())
            aaIter.next();
        Iterator<String> bbIter = bb.iterator();
        while (bbIter.hasNext()) {
            aaIter.add(bbIter.next());
        }
        System.out.println(aa);

        // spajanje dve kolekcije - na a se nalepljuje b naizmenicno
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();
        while (bIter.hasNext()) {
            if (aIter.hasNext())
                aIter.next();
            aIter.add(bIter.next());
        }
        System.out.println(a);

    }
}
