package p08;
//: c08:BigEgg.java
// An inner class cannot be overriden like a method.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

class Egg {
  private Yolk y;
  protected class Yolk {
    public Yolk() { System.out.println("Egg.Yolk()"); }
  }
  public Egg() {
    System.out.println("New Egg()");
    y = new Yolk();
  }
}

public class BigEgg extends Egg {
  private static Test monitor = new Test();
  public class Yolk {
    public Yolk() { System.out.println("BigEgg.Yolk()"); }
  }
  public static void main(String[] args) {
    new BigEgg();
    monitor.expect(new String[] {
      "New Egg()",
      "Egg.Yolk()"
    });
  }
} ///:~
