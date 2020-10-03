package p11;
//: c11:SortedSetDemo.java
// What you can do with a TreeSet.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.*;

public class SortedSetDemo {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    SortedSet sortedSet = new TreeSet(Arrays.asList(
    "one two three four five six seven eight".split(" ")));
    System.out.println(sortedSet);
    Object
      low = sortedSet.first(),
      high = sortedSet.last();
    System.out.println(low);
    System.out.println(high);
    Iterator it = sortedSet.iterator();
    for(int i = 0; i <= 6; i++) {
      if(i == 3) low = it.next();
      if(i == 6) high = it.next();
      else it.next();
    }
    System.out.println(low);
    System.out.println(high);
    System.out.println(sortedSet.subSet(low, high));
    System.out.println(sortedSet.headSet(high));
    System.out.println(sortedSet.tailSet(low));
    monitor.expect(new String[] {
      "[eight, five, four, one, seven, six, three, two]",
      "eight",
      "two",
      "one",
      "two",
      "[one, seven, six, three]",
      "[eight, five, four, one, seven, six, three]",
      "[one, seven, six, three, two]"
    });
  }
} ///:~
