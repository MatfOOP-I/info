package p08;
//: c08:AnonymousConstructor.java
// Creating a constructor for an anonymous inner class.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

abstract class Base {
  public Base(int i) {
    System.out.println("Base constructor, i = " + i);
  }
  public abstract void f();
}

public class AnonymousConstructor {
  private static Test monitor = new Test();
  public static Base getBase(int i) {
    return new Base(i) {
      {
        System.out.println("Inside instance initializer");
      }
      public void f() {
        System.out.println("In anonymous f()");
      }
    };
  }
  public static void main(String[] args) {
    Base base = getBase(47);
    base.f();
    monitor.expect(new String[] {
      "Base constructor, i = 47",
      "Inside instance initializer",
      "In anonymous f()"
    });
  }
} ///:~