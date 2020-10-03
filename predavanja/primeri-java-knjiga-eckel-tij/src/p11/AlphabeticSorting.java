package p11;
//: c11:AlphabeticSorting.java
// Keeping upper and lowercase letters together.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.util.*;
import java.util.*;

public class AlphabeticSorting {
  public static void main(String[] args) {
    String[] sa = new String[30];
    Arrays2.fill(sa, new Arrays2.RandStringGenerator(5));
    System.out.println(
      "Before sorting: " + Arrays.asList(sa));
    Arrays.sort(sa, new AlphabeticComparator());
    System.out.println(
      "After sorting: " + Arrays.asList(sa));
  }
} ///:~
