package p11;
//: c11:Set2.java
// Putting your own type in a Set.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.*;

public class Set2 {
  private static Test monitor = new Test();
  public static Set fill(Set a, int size) {
    for(int i = 0; i < size; i++)
      a.add(new MyType(i));
    return a;
  }
  public static void test(Set a) {
    fill(a, 10);
    fill(a, 10); // Try to add duplicates
    fill(a, 10);
    a.addAll(fill(new TreeSet(), 10));
    System.out.println(a);
  }
  public static void main(String[] args) {
    test(new HashSet());
    test(new TreeSet());
    test(new LinkedHashSet());
    monitor.expect(new String[] {
      "[2 , 4 , 9 , 8 , 6 , 1 , 3 , 7 , 5 , 0 ]",
      "[9 , 8 , 7 , 6 , 5 , 4 , 3 , 2 , 1 , 0 ]",
      "[0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 ]"
    });
  }
} ///:~
