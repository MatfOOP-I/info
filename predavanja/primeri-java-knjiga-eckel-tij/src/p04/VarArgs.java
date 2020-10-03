package p04;
//: c04:VarArgs.java
// Using array syntax to create variable argument lists.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

class A { int i; }

public class VarArgs {
  static Test monitor = new Test();
  static void print(Object[] x) {
    for(int i = 0; i < x.length; i++)
      System.out.println(x[i]);
  }
  public static void main(String[] args) {
    print(new Object[] {
      new Integer(47), new VarArgs(),
      new Float(3.14), new Double(11.11)
    });
    print(new Object[] {"one", "two", "three" });
    print(new Object[] {new A(), new A(), new A()});
    monitor.expect(new Object[] {
      "47",
      "%% VarArgs@\\p{XDigit}+",
      "3.14",
      "11.11",
      "one",
      "two",
      "three",
      new TestExpression("%% A@\\p{XDigit}+", 3)
    });
  }
} ///:~
