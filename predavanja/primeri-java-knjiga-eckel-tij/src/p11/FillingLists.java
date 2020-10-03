package p11;
//: c11:FillingLists.java
// The Collections.fill() method.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.*;

public class FillingLists {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    List list = new ArrayList();
    for(int i = 0; i < 10; i++)
      list.add("");
    Collections.fill(list, "Hello");
    System.out.println(list);
    monitor.expect(new String[] {
      "[Hello, Hello, Hello, Hello, Hello, " +
        "Hello, Hello, Hello, Hello, Hello]"
    });
  }
} ///:~
