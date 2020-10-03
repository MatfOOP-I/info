package p11;
//: c11:PrintingContainers.java
// Containers print themselves automatically.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.*;

public class PrintingContainers {
  private static Test monitor = new Test();
  static Collection fill(Collection c) {
    c.add("dog");
    c.add("dog");
    c.add("cat");
    return c;
  }
  static Map fill(Map m) {
    m.put("dog", "Bosco");
    m.put("dog", "Spot");
    m.put("cat", "Rags");
    return m;
  }
  public static void main(String[] args) {
    System.out.println(fill(new ArrayList()));
    System.out.println(fill(new HashSet()));
    System.out.println(fill(new HashMap()));
    monitor.expect(new String[] {
      "[dog, dog, cat]",
      "[dog, cat]",
      "{dog=Spot, cat=Rags}"
    });
  }
} ///:~
