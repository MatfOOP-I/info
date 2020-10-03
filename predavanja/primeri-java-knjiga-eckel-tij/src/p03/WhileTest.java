package p03;
//: c03:WhileTest.java
// Demonstrates the while loop.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

public class WhileTest {
  static Test monitor = new Test();
  public static void main(String[] args) {
    double r = 0;
    while(r < 0.99d) {
      r = Math.random();
      System.out.println(r);
      monitor.expect(new String[] {
        "%% \\d\\.\\d+E?-?\\d*"
      }, Test.AT_LEAST);
    }
  }
} ///:~
