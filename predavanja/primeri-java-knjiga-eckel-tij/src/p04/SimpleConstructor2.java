package p04;
//: c04:SimpleConstructor2.java
// Constructors can have arguments.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

class Rock2 {
  Rock2(int i) {
    System.out.println("Creating Rock number " + i);
  }
}

public class SimpleConstructor2 {
  static Test monitor = new Test();
  public static void main(String[] args) {
    for(int i = 0; i < 10; i++)
      new Rock2(i);
    monitor.expect(new String[] {
      "Creating Rock number 0",
      "Creating Rock number 1",
      "Creating Rock number 2",
      "Creating Rock number 3",
      "Creating Rock number 4",
      "Creating Rock number 5",
      "Creating Rock number 6",
      "Creating Rock number 7",
      "Creating Rock number 8",
      "Creating Rock number 9"
    });
  }
} ///:~
