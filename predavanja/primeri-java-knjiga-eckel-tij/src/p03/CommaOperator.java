package p03;
//: c03:CommaOperator.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

public class CommaOperator {
  static Test monitor = new Test();
  public static void main(String[] args) {
    for(int i = 1, j = i + 10; i < 5;
        i++, j = i * 2) {
      System.out.println("i= " + i + " j= " + j);
    }
    monitor.expect(new String[] {
      "i= 1 j= 11",
      "i= 2 j= 4",
      "i= 3 j= 6",
      "i= 4 j= 8"
    });
  }
} ///:~
