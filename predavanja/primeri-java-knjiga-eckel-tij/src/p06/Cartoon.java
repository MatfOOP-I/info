package p06;
//: c06:Cartoon.java
// Constructor calls during inheritance.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

class Art {
  Art() {
    System.out.println("Art constructor");
  }
}

class Drawing extends Art {
  Drawing() {
    System.out.println("Drawing constructor");
  }
}

public class Cartoon extends Drawing {
  private static Test monitor = new Test();
  public Cartoon() {
    System.out.println("Cartoon constructor");
  }
  public static void main(String[] args) {
    Cartoon x = new Cartoon();
    monitor.expect(new String[] {
      "Art constructor",
      "Drawing constructor",
      "Cartoon constructor"
    });
  }
} ///:~
