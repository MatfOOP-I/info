package p04;
//: c04:OrderOfInitialization.java
// Demonstrates initialization order.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

// When the constructor is called to create a
// Tag object, you'll see a message:
class Tag {
  Tag(int marker) {
    System.out.println("Tag(" + marker + ")");
  }
}

class Card {
  Tag t1 = new Tag(1); // Before constructor
  Card() {
    // Indicate we're in the constructor:
    System.out.println("Card()");
    t3 = new Tag(33); // Reinitialize t3
  }
  Tag t2 = new Tag(2); // After constructor
  void f() {
    System.out.println("f()");
  }
  Tag t3 = new Tag(3); // At end
}

public class OrderOfInitialization {
  static Test monitor = new Test();
  public static void main(String[] args) {
    Card t = new Card();
    t.f(); // Shows that construction is done
    monitor.expect(new String[] {
      "Tag(1)",
      "Tag(2)",
      "Tag(3)",
      "Card()",
      "Tag(33)",
      "f()"
    });
  }
} ///:~
