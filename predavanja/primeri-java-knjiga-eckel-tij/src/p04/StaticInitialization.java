package p04;
//: c04:StaticInitialization.java
// Specifying initial values in a class definition.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

class Bowl {
  Bowl(int marker) {
    System.out.println("Bowl(" + marker + ")");
  }
  void f(int marker) {
    System.out.println("f(" + marker + ")");
  }
}

class Table {
  static Bowl b1 = new Bowl(1);
  Table() {
    System.out.println("Table()");
    b2.f(1);
  }
  void f2(int marker) {
    System.out.println("f2(" + marker + ")");
  }
  static Bowl b2 = new Bowl(2);
}

class Cupboard {
  Bowl b3 = new Bowl(3);
  static Bowl b4 = new Bowl(4);
  Cupboard() {
    System.out.println("Cupboard()");
    b4.f(2);
  }
  void f3(int marker) {
    System.out.println("f3(" + marker + ")");
  }
  static Bowl b5 = new Bowl(5);
}

public class StaticInitialization {
  static Test monitor = new Test();
  public static void main(String[] args) {
    System.out.println("Creating new Cupboard() in main");
    new Cupboard();
    System.out.println("Creating new Cupboard() in main");
    new Cupboard();
    t2.f2(1);
    t3.f3(1);
    monitor.expect(new String[] {
      "Bowl(1)",
      "Bowl(2)",
      "Table()",
      "f(1)",
      "Bowl(4)",
      "Bowl(5)",
      "Bowl(3)",
      "Cupboard()",
      "f(2)",
      "Creating new Cupboard() in main",
      "Bowl(3)",
      "Cupboard()",
      "f(2)",
      "Creating new Cupboard() in main",
      "Bowl(3)",
      "Cupboard()",
      "f(2)",
      "f2(1)",
      "f3(1)"
    });
  }
  static Table t2 = new Table();
  static Cupboard t3 = new Cupboard();
} ///:~
