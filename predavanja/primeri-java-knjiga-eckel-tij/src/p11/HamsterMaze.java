package p11;
//: c11:HamsterMaze.java
// Using an Iterator.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.*;

public class HamsterMaze {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    List list = new ArrayList();
    for(int i = 0; i < 3; i++)
      list.add(new Hamster(i));
    Printer.printAll(list.iterator());
    monitor.expect(new String[] {
      "This is Hamster #0",
      "This is Hamster #1",
      "This is Hamster #2"
    });
  }
} ///:~
