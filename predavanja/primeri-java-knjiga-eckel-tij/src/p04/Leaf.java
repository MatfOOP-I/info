package p04;
//: c04:Leaf.java
// Simple use of the "this" keyword.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

public class Leaf {
  static Test monitor = new Test();
  int i = 0;
  Leaf increment() {
    i++;
    return this;
  }
  void print() {
    System.out.println("i = " + i);
  }
  public static void main(String[] args) {
    Leaf x = new Leaf();
    x.increment().increment().increment().print();
    monitor.expect(new String[] {
      "i = 3"
    });
  }
} ///:~
