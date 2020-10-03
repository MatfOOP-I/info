package rs.math.oop1.z150703.generickiMetodi.z01.sadrzavanje;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Generic {

    public static <E> boolean contains(Collection<E> c, Object obj) {
        if (obj == null) {
            for (E element : c)
                if (element == null)
                    return true;
        }
        for (E element : c)
            if (element.equals(obj))
                return true;
        return false;
    }

    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("Ovo");
        l.add("je");
        l.add("proba");
        System.out.println("Unesite rec:");
        Scanner sc = new Scanner(System.in);
        String rec = sc.next();
        if (contains(l, rec))
            System.out.println("Unesena rec '" + rec + "' se nalazi u listi " + l);
        else
            System.out.println("Unesena rec '" + rec + "' se NE nalazi u listi " + l);
        sc.close();
    }

}
