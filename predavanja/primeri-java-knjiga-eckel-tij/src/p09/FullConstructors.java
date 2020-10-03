package p09;
//: c09:FullConstructors.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

class MyException extends Exception {
  public MyException() {}
  public MyException(String msg) { super(msg); }
}

public class FullConstructors {
  private static Test monitor = new Test();
  public static void f() throws MyException {
    System.out.println("Throwing MyException from f()");
    throw new MyException();
  }
  public static void g() throws MyException {
    System.out.println("Throwing MyException from g()");
    throw new MyException("Originated in g()");
  }
  public static void main(String[] args) {
    try {
      f();
    } catch(MyException e) {
      e.printStackTrace();
    }
    try {
      g();
    } catch(MyException e) {
      e.printStackTrace();
    }
    monitor.expect(new String[] {
      "Throwing MyException from f()",
      "MyException",
      "%% \tat FullConstructors.f\\(.*\\)",
      "%% \tat FullConstructors.main\\(.*\\)",
      "Throwing MyException from g()",
      "MyException: Originated in g()",
      "%% \tat FullConstructors.g\\(.*\\)",
      "%% \tat FullConstructors.main\\(.*\\)"
    });
  }
} ///:~
