package p05;
//: c05:ToolTest.java
// Uses the tools library.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.tools.*;
import com.bruceeckel.simpletest.*;

public class ToolTest {
  static Test monitor = new Test();
  public static void main(String[] args) {
    P.rintln("Available from now on!");
    P.rintln("" + 100); // Force it to be a String
    P.rintln("" + 100L);
    P.rintln("" + 3.14159);
    monitor.expect(new String[] {
      "Available from now on!",
      "100",
      "100",
      "3.14159"
    });
  }
} ///:~
