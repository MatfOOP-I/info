package p06;
//: c06:Bath.java
// Constructor initialization with composition.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

class Soap {
  private String s;
  Soap() {
    System.out.println("Soap()");
    s = new String("Constructed");
  }
  public String toString() { return s; }
}

public class Bath {
  private static Test monitor = new Test();
  private String // Initializing at point of definition:
    s1 = new String("Happy"),
    s2 = "Happy",
    s3, s4;
  private Soap castille;
  private int i;
  private float toy;
  public Bath() {
    System.out.println("Inside Bath()");
    s3 = new String("Joy");
    i = 47;
    toy = 3.14f;
    castille = new Soap();
  }
  public String toString() {
    if(s4 == null) // Delayed initialization:
      s4 = new String("Joy");
    return
      "s1 = " + s1 + "\n" +
      "s2 = " + s2 + "\n" +
      "s3 = " + s3 + "\n" +
      "s4 = " + s4 + "\n" +
      "i = " + i + "\n" +
      "toy = " + toy + "\n" +
      "castille = " + castille;
  }
  public static void main(String[] args) {
    Bath b = new Bath();
    System.out.println(b);
    monitor.expect(new String[] {
      "Inside Bath()",
      "Soap()",
      "s1 = Happy",
      "s2 = Happy",
      "s3 = Joy",
      "s4 = Joy",
      "i = 47",
      "toy = 3.14",
      "castille = Constructed"
    });
  }
} ///:~
