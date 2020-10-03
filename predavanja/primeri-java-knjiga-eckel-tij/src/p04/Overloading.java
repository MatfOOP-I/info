package p04;
//: c04:Overloading.java
// Demonstration of both constructor
// and ordinary method overloading.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.*;

class Tree {
  int height;
  Tree() {
    System.out.println("Planting a seedling");
    height = 0;
  }
  Tree(int i) {
    System.out.println("Creating new Tree that is "
      + i + " feet tall");
    height = i;
  }
  void info() {
    System.out.println("Tree is " + height + " feet tall");
  }
  void info(String s) {
    System.out.println(s + ": Tree is "
      + height + " feet tall");
  }
}

public class Overloading {
  static Test monitor = new Test();
  public static void main(String[] args) {
    for(int i = 0; i < 5; i++) {
      Tree t = new Tree(i);
      t.info();
      t.info("overloaded method");
    }
    // Overloaded constructor:
    new Tree();
    monitor.expect(new String[] {
      "Creating new Tree that is 0 feet tall",
      "Tree is 0 feet tall",
      "overloaded method: Tree is 0 feet tall",
      "Creating new Tree that is 1 feet tall",
      "Tree is 1 feet tall",
      "overloaded method: Tree is 1 feet tall",
      "Creating new Tree that is 2 feet tall",
      "Tree is 2 feet tall",
      "overloaded method: Tree is 2 feet tall",
      "Creating new Tree that is 3 feet tall",
      "Tree is 3 feet tall",
      "overloaded method: Tree is 3 feet tall",
      "Creating new Tree that is 4 feet tall",
      "Tree is 4 feet tall",
      "overloaded method: Tree is 4 feet tall",
      "Planting a seedling"
    });
  }
} ///:~
