package p06;
//: c06:SprinklerSystem.java
// Composition for code reuse.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

class WaterSource {
  private String s;
  WaterSource() {
    System.out.println("WaterSource()");
    s = new String("Constructed");
  }
  public String toString() { return s; }
}

public class SprinklerSystem {
  private static Test monitor = new Test();
  private String valve1, valve2, valve3, valve4;
  private WaterSource source;
  private int i;
  private float f;
  public String toString() {
    return
      "valve1 = " + valve1 + "\n" +
      "valve2 = " + valve2 + "\n" +
      "valve3 = " + valve3 + "\n" +
      "valve4 = " + valve4 + "\n" +
      "i = " + i + "\n" +
      "f = " + f + "\n" +
      "source = " + source;
  }
  public static void main(String[] args) {
    SprinklerSystem sprinklers = new SprinklerSystem();
    System.out.println(sprinklers);
    monitor.expect(new String[] {
      "valve1 = null",
      "valve2 = null",
      "valve3 = null",
      "valve4 = null",
      "i = 0",
      "f = 0.0",
      "source = null"
    });
  }
} ///:~
