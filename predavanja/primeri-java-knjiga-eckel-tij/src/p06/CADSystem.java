//: c06:CADSystem.java
// Ensuring proper cleanup.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
package p06;
import com.bruceeckel.simpletest.*;
import java.util.*;

class Shape {
  Shape(int i) {
    System.out.println("Shape constructor");
  }
  void dispose() {
    System.out.println("Shape dispose");
  }
}

class Circle extends Shape {
  Circle(int i) {
    super(i);
    System.out.println("Drawing Circle");
  }
  void dispose() {
    System.out.println("Erasing Circle");
    super.dispose();
  }
}

class Triangle extends Shape {
  Triangle(int i) {
    super(i);
    System.out.println("Drawing Triangle");
  }
  void dispose() {
    System.out.println("Erasing Triangle");
    super.dispose();
  }
}

class Line extends Shape {
  private int start, end;
  Line(int start, int end) {
    super(start);
    this.start = start;
    this.end = end;
    System.out.println("Drawing Line: "+ start+ ", "+ end);
  }
  void dispose() {
    System.out.println("Erasing Line: "+ start+ ", "+ end);
    super.dispose();
  }
}

public class CADSystem extends Shape {
  private static Test monitor = new Test();
  private Circle c;
  private Triangle t;
  private Line[] lines = new Line[5];
  public CADSystem(int i) {
    super(i + 1);
    for(int j = 0; j < lines.length; j++)
      lines[j] = new Line(j, j*j);
    c = new Circle(1);
    t = new Triangle(1);
    System.out.println("Combined constructor");
  }
  public void dispose() {
    System.out.println("CADSystem.dispose()");
    // The order of cleanup is the reverse
    // of the order of initialization
    t.dispose();
    c.dispose();
    for(int i = lines.length - 1; i >= 0; i--)
      lines[i].dispose();
    super.dispose();
  }
  public static void main(String[] args) {
    CADSystem x = new CADSystem(47);
    try {
      // Code and exception handling...
    } finally {
      x.dispose();
    }
    monitor.expect(new String[] {
      "Shape constructor",
      "Shape constructor",
      "Drawing Line: 0, 0",
      "Shape constructor",
      "Drawing Line: 1, 1",
      "Shape constructor",
      "Drawing Line: 2, 4",
      "Shape constructor",
      "Drawing Line: 3, 9",
      "Shape constructor",
      "Drawing Line: 4, 16",
      "Shape constructor",
      "Drawing Circle",
      "Shape constructor",
      "Drawing Triangle",
      "Combined constructor",
      "CADSystem.dispose()",
      "Erasing Triangle",
      "Shape dispose",
      "Erasing Circle",
      "Shape dispose",
      "Erasing Line: 4, 16",
      "Shape dispose",
      "Erasing Line: 3, 9",
      "Shape dispose",
      "Erasing Line: 2, 4",
      "Shape dispose",
      "Erasing Line: 1, 1",
      "Shape dispose",
      "Erasing Line: 0, 0",
      "Shape dispose",
      "Shape dispose"
    });
  }
} ///:~
