package p03;
//: c03:AutoInc.java
// Demonstrates the ++ and -- operators.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

public class AutoInc {
  static Test monitor = new Test();
  public static void main(String[] args) {
    int i = 1;
    System.out.println("i : " + i);
    System.out.println("++i : " + ++i); // Pre-increment
    System.out.println("i++ : " + i++); // Post-increment
    System.out.println("i : " + i);
    System.out.println("--i : " + --i); // Pre-decrement
    System.out.println("i-- : " + i--); // Post-decrement
    System.out.println("i : " + i);
    monitor.expect(new String[] {
      "i : 1",
      "++i : 2",
      "i++ : 2",
      "i : 3",
      "--i : 2",
      "i-- : 2",
      "i : 1"
    });
  }
} ///:~
