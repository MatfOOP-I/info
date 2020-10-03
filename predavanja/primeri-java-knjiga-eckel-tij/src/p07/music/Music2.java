//: c07:music:Music2.java
// Overloading instead of upcasting.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
package p07.music;
import com.bruceeckel.simpletest.*;

class Stringed extends Instrument {
  public void play(Note n) {
    System.out.println("Stringed.play() " + n);
  }
}

class Brass extends Instrument {
  public void play(Note n) {
    System.out.println("Brass.play() " + n);
  }
}

public class Music2 {
  private static Test monitor = new Test();
  public static void tune(Wind i) {
    i.play(Note.MIDDLE_C);
  }
  public static void tune(Stringed i) {
    i.play(Note.MIDDLE_C);
  }
  public static void tune(Brass i) {
    i.play(Note.MIDDLE_C);
  }
  public static void main(String[] args) {
    Wind flute = new Wind();
    Stringed violin = new Stringed();
    Brass frenchHorn = new Brass();
    tune(flute); // No upcasting
    tune(violin);
    tune(frenchHorn);
    monitor.expect(new String[] {
      "Wind.play() Middle C",
      "Stringed.play() Middle C",
      "Brass.play() Middle C"
    });
  }
} ///:~
