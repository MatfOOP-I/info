package p03;
//: c03:EqualsMethod2.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

class Value {
  int i;
}

public class EqualsMethod2 {
  static Test monitor = new Test();
  public static void main(String[] args) {
    Value v1 = new Value();
    Value v2 = new Value();
    v1.i = v2.i = 100;
    System.out.println(v1.equals(v2));
    monitor.expect(new String[] {
      "false"
    });
  }
} ///:~
