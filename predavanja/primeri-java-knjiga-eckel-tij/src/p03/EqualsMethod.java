package p03;
//: c03:EqualsMethod.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

public class EqualsMethod {
  static Test monitor = new Test();
  public static void main(String[] args) {
    Integer n1 = new Integer(47);
    Integer n2 = new Integer(47);
    System.out.println(n1.equals(n2));
    monitor.expect(new String[] {
      "true"
    });
  }
} ///:~
