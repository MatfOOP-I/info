package p05;
//: c05:Cake.java
// Accesses a class in a separate compilation unit.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

class Cake {
  static Test monitor = new Test();
  public static void main(String[] args) {
    Pie x = new Pie();
    x.f();
    monitor.expect(new String[] {
      "Pie.f()"
    });
  }
} ///:~
