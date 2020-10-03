package p09;
//: c09:RethrowNew.java
// Rethrow a different object from the one that was caught.
// {ThrowsException}
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

class OneException extends Exception {
  public OneException(String s) { super(s); }
}

class TwoException extends Exception {
  public TwoException(String s) { super(s); }
}

public class RethrowNew {
  private static Test monitor = new Test();
  public static void f() throws OneException {
    System.out.println("originating the exception in f()");
    throw new OneException("thrown from f()");
  }
  public static void
  main(String[] args) throws TwoException {
    try {
      f();
    } catch(OneException e) {
      System.err.println(
        "Caught in main, e.printStackTrace()");
      e.printStackTrace();
      throw new TwoException("from main()");
    }
    monitor.expect(new String[] {
      "originating the exception in f()",
      "Caught in main, e.printStackTrace()",
      "OneException: thrown from f()",
      "\tat RethrowNew.f(RethrowNew.java:18)",
      "\tat RethrowNew.main(RethrowNew.java:22)",
      "Exception in thread \"main\" " +
      "TwoException: from main()",
      "\tat RethrowNew.main(RethrowNew.java:28)"
    });
  }
} ///:~
