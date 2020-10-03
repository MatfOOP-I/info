package p11;
//: c11:AlphabeticSearch.java
// Searching with a Comparator.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import com.bruceeckel.util.*;
import java.util.*;

public class AlphabeticSearch {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    String[] sa = new String[30];
    Arrays2.fill(sa, new Arrays2.RandStringGenerator(5));
    AlphabeticComparator comp = new AlphabeticComparator();
    Arrays.sort(sa, comp);
    int index = Arrays.binarySearch(sa, sa[10], comp);
    System.out.println("Index = " + index);
    monitor.expect(new String[] {
      "Index = 10"
    });
  }
} ///:~
