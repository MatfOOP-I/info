package p04;
//: c04:OverloadingOrder.java
// Overloading based on the order of the arguments.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

public class OverloadingOrder {
  static Test monitor = new Test();
  static void print(String s, int i) {
    System.out.println("String: " + s + ", int: " + i);
  }
  static void print(int i, String s) {
    System.out.println("int: " + i + ", String: " + s);
  }
  public static void main(String[] args) {
    print("String first", 11);
    print(99, "Int first");
    monitor.expect(new String[] {
      "String: String first, int: 11",
      "int: 99, String: Int first"
    });
  }
} ///:~
