package v19.Sketcher.v01StatusBar;
import java.awt.Color;
import java.awt.Shape;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

public abstract class Element {
  public Element(Color color) {
    this.color = color;  
  }

  public Color getColor() {
    return color;  
  }

  public abstract Shape getShape();
  public abstract java.awt.Rectangle getBounds();

  protected Color color;                             // Color of a shape
  public abstract void modify(Point start, Point last);

  // Nested class defining a line
  public static class Line extends Element {
    public Line(Point start, Point end, Color color) {
      super(color);
      line = new Line2D.Double(start, end);
    }

    public Shape getShape() { 
      return line; 
    }

    public java.awt.Rectangle getBounds() {
      return line.getBounds();  
    }

    public void modify(Point start, Point last) {
      line.x2 = last.x;
      line.y2 = last.y;
    }

    private Line2D.Double line;
  }

  // Nested class defining a rectangle
  public static class Rectangle extends Element {
    public Rectangle(Point start, Point end, Color color) {
      super(color);
      rectangle = new Rectangle2D.Double(
        Math.min(start.x, end.x), Math.min(start.y, end.y),    // Top-left corner
        Math.abs(start.x - end.x), Math.abs(start.y - end.y)); // Width & height
    }

    public Shape getShape() { 
      return rectangle; 
    }
    public java.awt.Rectangle getBounds() { 
      return rectangle.getBounds();  
    }

    public void modify(Point start, Point last) {
      rectangle.x = Math.min(start.x, last.x);
      rectangle.y = Math.min(start.y, last.y);
      rectangle.width = Math.abs(start.x - last.x);
      rectangle.height = Math.abs(start.y - last.y);
    }

    private Rectangle2D.Double rectangle;
  }

  // Nested class defining a circle
  public static class Circle extends Element {
    public Circle(Point center, Point circum, Color color) {
      super(color);
  
      // Radius is distance from center to circumference
      double radius = center.distance(circum);
      circle = new Ellipse2D.Double(center.x - radius, center.y - radius, 
                                    2.*radius, 2.*radius ); 
    }

    public Shape getShape() { 
      return circle; 
    }

    public java.awt.Rectangle getBounds() { 
      return circle.getBounds();  
    }

    public void modify(Point center, Point circum) {
      double radius = center.distance(circum);
      circle.x = center.x - (int)radius;
      circle.y = center.y - (int)radius;
      circle.width = circle.height = 2*radius;
    }

    private Ellipse2D.Double circle;
  }

  // Nested class defining a curve
  public static class Curve extends Element {
    public Curve(Point start, Point next, Color color) {
      super(color);
      curve = new GeneralPath();
      curve.moveTo(start.x, start.y);

      curve.lineTo(next.x, next.y);
    }

    // Add another segment
    public void modify(Point start, Point next) {
      curve.lineTo(next.x,
                   next.y);
    }

    public Shape getShape()  { 
      return curve; 
    }

    public java.awt.Rectangle getBounds() { 
      return curve.getBounds();  
    }

    private GeneralPath curve;
  }
}
