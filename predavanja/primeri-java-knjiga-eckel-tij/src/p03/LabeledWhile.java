package p03;
//: c03:LabeledWhile.java
// Java's "labeled while" loop.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

public class LabeledWhile {
  static Test monitor = new Test();
  public static void main(String[] args) {
    int i = 0;
    outer:
    while(true) {
      System.out.println("Outer while loop");
      while(true) {
        i++;
        System.out.println("i = " + i);
        if(i == 1) {
          System.out.println("continue");
          continue;
        }
        if(i == 3) {
          System.out.println("continue outer");
          continue outer;
        }
        if(i == 5) {
          System.out.println("break");
          break;
        }
        if(i == 7) {
          System.out.println("break outer");
          break outer;
        }
      }
    }
    monitor.expect(new String[] {
      "Outer while loop",
      "i = 1",
      "continue",
      "i = 2",
      "i = 3",
      "continue outer",
      "Outer while loop",
      "i = 4",
      "i = 5",
      "break",
      "Outer while loop",
      "i = 6",
      "i = 7",
      "break outer"
    });
  }
} ///:~
