package p09;
//: c09:ExceptionMethods.java
// Demonstrating the Exception Methods.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

public class ExceptionMethods {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    try {
      throw new Exception("My Exception");
    } catch(Exception e) {
      System.err.println("Caught Exception");
      System.err.println("getMessage():" + e.getMessage());
      System.err.println("getLocalizedMessage():" +
        e.getLocalizedMessage());
      System.err.println("toString():" + e);
      System.err.println("printStackTrace():");
      e.printStackTrace();
    }
    monitor.expect(new String[] {
      "Caught Exception",
      "getMessage():My Exception",
      "getLocalizedMessage():My Exception",
      "toString():java.lang.Exception: My Exception",
      "printStackTrace():",
      "java.lang.Exception: My Exception",
      "%% \tat ExceptionMethods.main\\(.*\\)"
    });
  }
} ///:~
