package p09;
//: c09:NeverCaught.java
// Ignoring RuntimeExceptions.
// {ThrowsException}
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

public class NeverCaught {
  private static Test monitor = new Test();
  static void f() {
    throw new RuntimeException("From f()");
  }
  static void g() {
    f();
  }
  public static void main(String[] args) {
    g();
    monitor.expect(new String[] {
      "Exception in thread \"main\" " +
      "java.lang.RuntimeException: From f()",
      "        at NeverCaught.f(NeverCaught.java:7)",
      "        at NeverCaught.g(NeverCaught.java:10)",
      "        at NeverCaught.main(NeverCaught.java:13)"
    });
  }
} ///:~
