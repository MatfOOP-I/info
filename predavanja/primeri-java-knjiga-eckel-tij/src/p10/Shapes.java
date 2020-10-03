package p10;
//: c10:Shapes.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

class Shape {
  void draw() { System.out.println(this + ".draw()"); }
}

class Circle extends Shape {
  public String toString() { return "Circle"; }
}

class Square extends Shape {
  public String toString() { return "Square"; }
}

class Triangle extends Shape {
  public String toString() { return "Triangle"; }
}

public class Shapes {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    // Array of Object, not Shape:
    Object[] shapeList = {
      new Circle(),
      new Square(),
      new Triangle()
    };
    for(int i = 0; i < shapeList.length; i++)
      ((Shape)shapeList[i]).draw(); // Must cast
    monitor.expect(new String[] {
      "Circle.draw()",
      "Square.draw()",
      "Triangle.draw()"
    });
  }
} ///:~
