package p11;
//: c11:ComparatorTest.java
// Implementing a Comparator for a class.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.util.*;
import java.util.*;

class CompTypeComparator implements Comparator {
  public int compare(Object o1, Object o2) {
    int j1 = ((CompType)o1).j;
    int j2 = ((CompType)o2).j;
    return (j1 < j2 ? -1 : (j1 == j2 ? 0 : 1));
  }
}

public class ComparatorTest {
  public static void main(String[] args) {
    CompType[] a = new CompType[10];
    Arrays2.fill(a, CompType.generator());
    System.out.println(
      "before sorting, a = " + Arrays.asList(a));
    Arrays.sort(a, new CompTypeComparator());
    System.out.println(
      "after sorting, a = " + Arrays.asList(a));
  }
} ///:~
