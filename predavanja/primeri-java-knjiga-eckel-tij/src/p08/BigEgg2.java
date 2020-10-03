package p08;
//: c08:BigEgg2.java
// Proper inheritance of an inner class.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

class Egg2 {
  protected class Yolk {
    public Yolk() { System.out.println("Egg2.Yolk()"); }
    public void f() { System.out.println("Egg2.Yolk.f()");}
  }
  private Yolk y = new Yolk();
  public Egg2() { System.out.println("New Egg2()"); }
  public void insertYolk(Yolk yy) { y = yy; }
  public void g() { y.f(); }
}

public class BigEgg2 extends Egg2 {
  private static Test monitor = new Test();
  public class Yolk extends Egg2.Yolk {
    public Yolk() { System.out.println("BigEgg2.Yolk()"); }
    public void f() {
      System.out.println("BigEgg2.Yolk.f()");
    }
  }
  public BigEgg2() { insertYolk(new Yolk()); }
  public static void main(String[] args) {
    Egg2 e2 = new BigEgg2();
    e2.g();
    monitor.expect(new String[] {
      "Egg2.Yolk()",
      "New Egg2()",
      "Egg2.Yolk()",
      "BigEgg2.Yolk()",
      "BigEgg2.Yolk.f()"
    });
  }
} ///:~
