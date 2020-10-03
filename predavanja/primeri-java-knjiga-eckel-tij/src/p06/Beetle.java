package p06;
//: c06:Beetle.java
// The full process of initialization.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

class Insect {
  protected static Test monitor = new Test();
  private int i = 9;
  protected int j;
  Insect() {
    System.out.println("i = " + i + ", j = " + j);
    j = 39;
  }
  private static int x1 =
    print("static Insect.x1 initialized");
  static int print(String s) {
    System.out.println(s);
    return 47;
  }
}

public class Beetle extends Insect {
  private int k = print("Beetle.k initialized");
  public Beetle() {
    System.out.println("k = " + k);
    System.out.println("j = " + j);
  }
  private static int x2 =
    print("static Beetle.x2 initialized");
  public static void main(String[] args) {
    System.out.println("Beetle constructor");
    Beetle b = new Beetle();
    monitor.expect(new String[] {
      "static Insect.x1 initialized",
      "static Beetle.x2 initialized",
      "Beetle constructor",
      "i = 9, j = 0",
      "Beetle.k initialized",
      "k = 47",
      "j = 39"
    });
  }
} ///:~
