package p11;
//: c11:StringHashCode.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

public class StringHashCode {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    System.out.println("Hello".hashCode());
    System.out.println("Hello".hashCode());
    monitor.expect(new String[] {
      "69609650",
      "69609650"
    });
  }
} ///:~
