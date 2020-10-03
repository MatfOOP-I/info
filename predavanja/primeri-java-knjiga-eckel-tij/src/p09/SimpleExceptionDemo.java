package p09;
//: c09:SimpleExceptionDemo.java
// Inheriting your own exceptions.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

class SimpleException extends Exception {}

public class SimpleExceptionDemo {
  private static Test monitor = new Test();
  public void f() throws SimpleException {
    System.out.println("Throw SimpleException from f()");
    throw new SimpleException();
  }
  public static void main(String[] args) {
    SimpleExceptionDemo sed = new SimpleExceptionDemo();
    try {
      sed.f();
    } catch(SimpleException e) {
      System.err.println("Caught it!");
    }
    monitor.expect(new String[] {
      "Throw SimpleException from f()",
      "Caught it!"
    });
  }
} ///:~
