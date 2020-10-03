package p11;
//: c11:SortedMapDemo.java
// What you can do with a TreeMap.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import com.bruceeckel.util.*;
import java.util.*;

public class SortedMapDemo {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    TreeMap sortedMap = new TreeMap();
    Collections2.fill(
      sortedMap, SimplePairGenerator.gen, 10);
    System.out.println(sortedMap);
    Object
      low = sortedMap.firstKey(),
      high = sortedMap.lastKey();
    System.out.println(low);
    System.out.println(high);
    Iterator it = sortedMap.keySet().iterator();
    for(int i = 0; i <= 6; i++) {
      if(i == 3) low = it.next();
      if(i == 6) high = it.next();
      else it.next();
    }
    System.out.println(low);
    System.out.println(high);
    System.out.println(sortedMap.subMap(low, high));
    System.out.println(sortedMap.headMap(high));
    System.out.println(sortedMap.tailMap(low));
    monitor.expect(new String[] {
      "{eight=H, five=E, four=D, nine=I, one=A, seven=G," +
      " six=F, ten=J, three=C, two=B}",
      "eight",
      "two",
      "nine",
      "ten",
      "{nine=I, one=A, seven=G, six=F}",
      "{eight=H, five=E, four=D, nine=I, " +
      "one=A, seven=G, six=F}",
      "{nine=I, one=A, seven=G, six=F, " +
      "ten=J, three=C, two=B}"
    });
  }
} ///:~
