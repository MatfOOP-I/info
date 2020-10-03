package p11;
//: c11:Iterators2.java
// Revisiting Iterators.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.*;

public class Iterators2 {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    List list = new ArrayList();
    for(int i = 0; i < 5; i++)
      list.add(new Mouse(i));
    Map m = new HashMap();
    for(int i = 0; i < 5; i++)
      m.put(new Integer(i), new Hamster(i));
    System.out.println("List");
    Printer.printAll(list.iterator());
    System.out.println("Map");
    Printer.printAll(m.entrySet().iterator());
    monitor.expect(new String[] {
      "List",
      "This is Mouse #0",
      "This is Mouse #1",
      "This is Mouse #2",
      "This is Mouse #3",
      "This is Mouse #4",
      "Map",
      "4=This is Hamster #4",
      "3=This is Hamster #3",
      "2=This is Hamster #2",
      "1=This is Hamster #1",
      "0=This is Hamster #0"
    }, Test.IGNORE_ORDER);
  }
} ///:~
