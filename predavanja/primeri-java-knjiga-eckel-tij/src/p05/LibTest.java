package p05;
//: c05:LibTest.java
// Uses the library.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import com.bruceeckel.simple.*;

public class LibTest {
  static Test monitor = new Test();
  public static void main(String[] args) {
    Vector v = new Vector();
    List l = new List();
    monitor.expect(new String[] {
      "com.bruceeckel.simple.Vector",
      "com.bruceeckel.simple.List"
    });
  }
} ///:~
