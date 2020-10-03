package p11;
//: c11:Set1.java
// Things you can do with Sets.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.*;

public class Set1 {
  private static Test monitor = new Test();
  static void fill(Set s) {
    s.addAll(Arrays.asList(
      "one two three four five six seven".split(" ")));
  }
  public static void test(Set s) {
    // Strip qualifiers from class name:
    System.out.println(
      s.getClass().getName().replaceAll("\\w+\\.", ""));
    fill(s); fill(s); fill(s);
    System.out.println(s); // No duplicates!
    // Add another set to this one:
    s.addAll(s);
    s.add("one");
    s.add("one");
    s.add("one");
    System.out.println(s);
    // Look something up:
    System.out.println("s.contains(\"one\"): " +
      s.contains("one"));
  }
  public static void main(String[] args) {
    test(new HashSet());
    test(new TreeSet());
    test(new LinkedHashSet());
    monitor.expect(new String[] {
      "HashSet",
      "[one, two, five, four, three, seven, six]",
      "[one, two, five, four, three, seven, six]",
      "s.contains(\"one\"): true",
      "TreeSet",
      "[five, four, one, seven, six, three, two]",
      "[five, four, one, seven, six, three, two]",
      "s.contains(\"one\"): true",
      "LinkedHashSet",
      "[one, two, three, four, five, six, seven]",
      "[one, two, three, four, five, six, seven]",
      "s.contains(\"one\"): true"
    });
  }
} ///:~
