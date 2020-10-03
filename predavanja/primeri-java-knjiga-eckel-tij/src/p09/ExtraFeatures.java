package p09;
//: c09:ExtraFeatures.java
// Further embellishment of exception classes.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

class MyException2 extends Exception {
  private int x;
  public MyException2() {}
  public MyException2(String msg) { super(msg); }
  public MyException2(String msg, int x) {
    super(msg);
    this.x = x;
  }
  public int val() { return x; }
  public String getMessage() {
    return "Detail Message: "+ x + " "+ super.getMessage();
  }
}

public class ExtraFeatures {
  private static Test monitor = new Test();
  public static void f() throws MyException2 {
    System.out.println("Throwing MyException2 from f()");
    throw new MyException2();
  }
  public static void g() throws MyException2 {
    System.out.println("Throwing MyException2 from g()");
    throw new MyException2("Originated in g()");
  }
  public static void h() throws MyException2 {
    System.out.println("Throwing MyException2 from h()");
    throw new MyException2("Originated in h()", 47);
  }
  public static void main(String[] args) {
    try {
      f();
    } catch(MyException2 e) {
      e.printStackTrace();
    }
    try {
      g();
    } catch(MyException2 e) {
      e.printStackTrace();
    }
    try {
      h();
    } catch(MyException2 e) {
      e.printStackTrace();
      System.err.println("e.val() = " + e.val());
    }
    monitor.expect(new String[] {
      "Throwing MyException2 from f()",
      "MyException2: Detail Message: 0 null",
      "%% \tat ExtraFeatures.f\\(.*\\)",
      "%% \tat ExtraFeatures.main\\(.*\\)",
      "Throwing MyException2 from g()",
      "MyException2: Detail Message: 0 Originated in g()",
      "%% \tat ExtraFeatures.g\\(.*\\)",
      "%% \tat ExtraFeatures.main\\(.*\\)",
      "Throwing MyException2 from h()",
      "MyException2: Detail Message: 47 Originated in h()",
      "%% \tat ExtraFeatures.h\\(.*\\)",
      "%% \tat ExtraFeatures.main\\(.*\\)",
      "e.val() = 47"
    });
  }
} ///:~
