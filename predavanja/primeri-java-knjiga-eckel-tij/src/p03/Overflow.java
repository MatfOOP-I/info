package p03;
//: c03:Overflow.java
// Surprise! Java lets you overflow.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

public class Overflow {
  static Test monitor = new Test();
  public static void main(String[] args) {
    int big = 0x7fffffff; // max int value
    System.out.println("big = " + big);
    int bigger = big * 4;
    System.out.println("bigger = " + bigger);
    monitor.expect(new String[] {
      "big = 2147483647",
      "bigger = -4"
    });
  }
} ///:~
