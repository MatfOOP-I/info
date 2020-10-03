package p04;
//: c04:SimpleConstructor.java
// Demonstration of a simple constructor.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

class Rock {
  Rock() { // This is the constructor
    System.out.println("Creating Rock");
  }
}

public class SimpleConstructor {
  static Test monitor = new Test();
  public static void main(String[] args) {
    for(int i = 0; i < 10; i++)
      new Rock();
    monitor.expect(new String[] {
      "Creating Rock",
      "Creating Rock",
      "Creating Rock",
      "Creating Rock",
      "Creating Rock",
      "Creating Rock",
      "Creating Rock",
      "Creating Rock",
      "Creating Rock",
      "Creating Rock"
    });
  }
} ///:~
