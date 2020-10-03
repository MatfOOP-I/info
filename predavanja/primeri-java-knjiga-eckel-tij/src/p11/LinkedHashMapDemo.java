package p11;
//: c11:LinkedHashMapDemo.java
// What you can do with a LinkedHashMap.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import com.bruceeckel.util.*;
import java.util.*;

public class LinkedHashMapDemo {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    LinkedHashMap linkedMap = new LinkedHashMap();
    Collections2.fill(
      linkedMap, SimplePairGenerator.gen, 10);
    System.out.println(linkedMap);
    // Least-recently used order:
    linkedMap = new LinkedHashMap(16, 0.75f, true);
    Collections2.fill(
      linkedMap, SimplePairGenerator.gen, 10);
    System.out.println(linkedMap);
    for(int i = 0; i < 7; i++) // Cause accesses:
      linkedMap.get(SimplePairGenerator.gen.items[i].key);
    System.out.println(linkedMap);
    linkedMap.get(SimplePairGenerator.gen.items[0].key);
    System.out.println(linkedMap);
    monitor.expect(new String[] {
      "{one=A, two=B, three=C, four=D, five=E, " +
       "six=F, seven=G, eight=H, nine=I, ten=J}",
      "{one=A, two=B, three=C, four=D, five=E, " +
       "six=F, seven=G, eight=H, nine=I, ten=J}",
      "{eight=H, nine=I, ten=J, one=A, two=B, " +
       "three=C, four=D, five=E, six=F, seven=G}",
      "{eight=H, nine=I, ten=J, two=B, three=C, " +
       "four=D, five=E, six=F, seven=G, one=A}"
    });
  }
} ///:~
