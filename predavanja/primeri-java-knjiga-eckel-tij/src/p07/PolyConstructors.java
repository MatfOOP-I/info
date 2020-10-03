package p07;
//: c07:PolyConstructors.java
// Constructors and polymorphism
// don't produce what you might expect.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

abstract class Glyph {
  abstract void draw();
  Glyph() {
    System.out.println("Glyph() before draw()");
    draw();
    System.out.println("Glyph() after draw()");
  }
}

class RoundGlyph extends Glyph {
  private int radius = 1;
  RoundGlyph(int r) {
    radius = r;
    System.out.println(
      "RoundGlyph.RoundGlyph(), radius = " + radius);
  }
  void draw() {
    System.out.println(
      "RoundGlyph.draw(), radius = " + radius);
  }
}

public class PolyConstructors {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    new RoundGlyph(5);
    monitor.expect(new String[] {
      "Glyph() before draw()",
      "RoundGlyph.draw(), radius = 0",
      "Glyph() after draw()",
      "RoundGlyph.RoundGlyph(), radius = 5"
    });
  }
} ///:~