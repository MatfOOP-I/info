package p12;
//: c12:ChangeSystemOut.java
// Turn System.out into a PrintWriter.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.io.*;

public class ChangeSystemOut {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    PrintWriter out = new PrintWriter(System.out, true);
    out.println("Hello, world");
    monitor.expect(new String[] {
      "Hello, world"
    });
  }
} ///:~
