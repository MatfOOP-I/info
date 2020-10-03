package p09;
//: c09:Rethrowing.java
// Demonstrating fillInStackTrace()
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

public class Rethrowing {
  private static Test monitor = new Test();
  public static void f() throws Exception {
    System.out.println("originating the exception in f()");
    throw new Exception("thrown from f()");
  }
  public static void g() throws Throwable {
    try {
      f();
    } catch(Exception e) {
      System.err.println("Inside g(),e.printStackTrace()");
      e.printStackTrace();
      throw e; // 17
      // throw e.fillInStackTrace(); // 18
    }
  }
  public static void
  main(String[] args) throws Throwable {
    try {
      g();
    } catch(Exception e) {
      System.err.println(
        "Caught in main, e.printStackTrace()");
      e.printStackTrace();
    }
    monitor.expect(new String[] {
      "originating the exception in f()",
      "Inside g(),e.printStackTrace()",
      "java.lang.Exception: thrown from f()",
      "%% \tat Rethrowing.f(.*?)",
      "%% \tat Rethrowing.g(.*?)",
      "%% \tat Rethrowing.main(.*?)",
      "Caught in main, e.printStackTrace()",
      "java.lang.Exception: thrown from f()",
      "%% \tat Rethrowing.f(.*?)",
      "%% \tat Rethrowing.g(.*?)",
      "%% \tat Rethrowing.main(.*?)"
    });
  }
} ///:~
