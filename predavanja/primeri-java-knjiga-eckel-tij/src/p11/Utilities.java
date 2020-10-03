package p11;
//: c11:Utilities.java
// Simple demonstrations of the Collections utilities.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.*;
import com.bruceeckel.util.*;

public class Utilities {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    List list = Arrays.asList(
      "one Two three Four five six one".split(" "));
    System.out.println(list);
    System.out.println("max: " + Collections.max(list));
    System.out.println("min: " + Collections.min(list));
    AlphabeticComparator comp = new AlphabeticComparator();
    System.out.println("max w/ comparator: " +
      Collections.max(list, comp));
    System.out.println("min w/ comparator: " +
      Collections.min(list, comp));
    List sublist =
      Arrays.asList("Four five six".split(" "));
    System.out.println("indexOfSubList: " +
      Collections.indexOfSubList(list, sublist));
    System.out.println("lastIndexOfSubList: " +
      Collections.lastIndexOfSubList(list, sublist));
    Collections.replaceAll(list, "one", "Yo");
    System.out.println("replaceAll: " + list);
    Collections.reverse(list);
    System.out.println("reverse: " + list);
    Collections.rotate(list, 3);
    System.out.println("rotate: " + list);
    List source =
      Arrays.asList("in the matrix".split(" "));
    Collections.copy(list, source);
    System.out.println("copy: " + list);
    Collections.swap(list, 0, list.size() - 1);
    System.out.println("swap: " + list);
    Collections.fill(list, "pop");
    System.out.println("fill: " + list);
    List dups = Collections.nCopies(3, "snap");
    System.out.println("dups: " + dups);
    // Getting an old-style Enumeration:
    Enumeration e = Collections.enumeration(dups);
    Vector v = new Vector();
    while(e.hasMoreElements())
      v.addElement(e.nextElement());
    // Converting an old-style Vector
    // to a List via an Enumeration:
    ArrayList arrayList = Collections.list(v.elements());
    System.out.println("arrayList: " + arrayList);
    monitor.expect(new String[] {
      "[one, Two, three, Four, five, six, one]",
      "max: three",
      "min: Four",
      "max w/ comparator: Two",
      "min w/ comparator: five",
      "indexOfSubList: 3",
      "lastIndexOfSubList: 3",
      "replaceAll: [Yo, Two, three, Four, five, six, Yo]",
      "reverse: [Yo, six, five, Four, three, Two, Yo]",
      "rotate: [three, Two, Yo, Yo, six, five, Four]",
      "copy: [in, the, matrix, Yo, six, five, Four]",
      "swap: [Four, the, matrix, Yo, six, five, in]",
      "fill: [pop, pop, pop, pop, pop, pop, pop]",
      "dups: [snap, snap, snap]",
      "arrayList: [snap, snap, snap]"
    });
  }
} ///:~