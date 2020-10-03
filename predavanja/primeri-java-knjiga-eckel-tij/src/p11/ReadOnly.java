package p11;
//: c11:ReadOnly.java
// Using the Collections.unmodifiable methods.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.util.*;
import com.bruceeckel.util.*;

public class ReadOnly {
  private static Collections2.StringGenerator gen =
    Collections2.countries;
  public static void main(String[] args) {
    Collection c = new ArrayList();
    Collections2.fill(c, gen, 25); // Insert data
    c = Collections.unmodifiableCollection(c);
    System.out.println(c); // Reading is OK
    //! c.add("one"); // Can't change it

    List a = new ArrayList();
    Collections2.fill(a, gen.reset(), 25);
    a = Collections.unmodifiableList(a);
    ListIterator lit = a.listIterator();
    System.out.println(lit.next()); // Reading is OK
    //! lit.add("one"); // Can't change it

    Set s = new HashSet();
    Collections2.fill(s, gen.reset(), 25);
    s = Collections.unmodifiableSet(s);
    System.out.println(s); // Reading is OK
    //! s.add("one"); // Can't change it

    Map m = new HashMap();
    Collections2.fill(m, Collections2.geography, 25);
    m = Collections.unmodifiableMap(m);
    System.out.println(m); // Reading is OK
    //! m.put("Ralph", "Howdy!");
  }
} ///:~
