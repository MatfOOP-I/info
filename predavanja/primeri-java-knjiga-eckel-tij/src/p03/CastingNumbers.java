package p03;
//: c03:CastingNumbers.java
// What happens when you cast a float
// or double to an integral value?
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

public class CastingNumbers {
  static Test monitor = new Test();
  public static void main(String[] args) {
    double
      above = 0.7,
      below = 0.4;
    System.out.println("above: " + above);
    System.out.println("below: " + below);
    System.out.println("(int)above: " + (int)above);
    System.out.println("(int)below: " + (int)below);
    System.out.println("(char)('a' + above): " +
      (char)('a' + above));
    System.out.println("(char)('a' + below): " +
      (char)('a' + below));
    monitor.expect(new String[] {
      "above: 0.7",
      "below: 0.4",
      "(int)above: 0",
      "(int)below: 0",
      "(char)('a' + above): a",
      "(char)('a' + below): a"
    });
  }
} ///:~
