package p11;
//: c11:Reverse.java
// The Collecions.reverseOrder() Comparator
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.util.*;
import java.util.*;

public class Reverse {
  public static void main(String[] args) {
    CompType[] a = new CompType[10];
    Arrays2.fill(a, CompType.generator());
    System.out.println(
      "before sorting, a = " + Arrays.asList(a));
    Arrays.sort(a, Collections.reverseOrder());
    System.out.println(
      "after sorting, a = " + Arrays.asList(a));
  }
} ///:~
