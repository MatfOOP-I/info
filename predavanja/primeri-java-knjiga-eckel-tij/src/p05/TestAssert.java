package p05;
//: c05:TestAssert.java
// Demonstrating the assertion tool. Comment the following,
// and uncomment the subsequent line to change
// assertion behavior:
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import com.bruceeckel.tools.debug.*;
// import com.bruceeckel.tools.*;

public class TestAssert {
  static Test monitor = new Test();
  public static void main(String[] args) {
    Assert.is_true((2 + 2) == 5);
    Assert.is_false((1 + 1) == 2);
    Assert.is_true((2 + 2) == 5, "2 + 2 == 5");
    Assert.is_false((1 + 1) == 2, "1 +1 != 2");
    monitor.expect(new String[] {
      "Assertion failed",
      "Assertion failed",
      "Assertion failed: 2 + 2 == 5",
      "Assertion failed: 1 +1 != 2"
    });
  }
} ///:~
