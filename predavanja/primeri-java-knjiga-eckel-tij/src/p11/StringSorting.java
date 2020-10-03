package p11;
//: c11:StringSorting.java
// Sorting an array of Strings.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.util.*;
import java.util.*;

public class StringSorting {
  public static void main(String[] args) {
    String[] sa = new String[30];
    Arrays2.fill(sa, new Arrays2.RandStringGenerator(5));
    System.out.println(
      "Before sorting: " + Arrays.asList(sa));
    Arrays.sort(sa);
    System.out.println(
      "After sorting: " + Arrays.asList(sa));
  }
} ///:~
