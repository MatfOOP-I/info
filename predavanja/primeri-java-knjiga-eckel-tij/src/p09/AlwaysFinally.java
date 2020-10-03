package p09;
//: c09:AlwaysFinally.java
// Finally is always executed.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

class FourException extends Exception {}

public class AlwaysFinally {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    System.out.println("Entering first try block");
    try {
      System.out.println("Entering second try block");
      try {
        throw new FourException();
      } finally {
        System.out.println("finally in 2nd try block");
      }
    } catch(FourException e) {
      System.err.println(
        "Caught FourException in 1st try block");
    } finally {
      System.err.println("finally in 1st try block");
    }
    monitor.expect(new String[] {
      "Entering first try block",
      "Entering second try block",
      "finally in 2nd try block",
      "Caught FourException in 1st try block",
      "finally in 1st try block"
    });
  }
} ///:~
