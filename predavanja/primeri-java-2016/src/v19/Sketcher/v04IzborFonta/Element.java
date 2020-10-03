package v19.Sketcher.v04IzborFonta;
import java.awt.Color;
import java.awt.Shape;
import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.Font;

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

  public abstract java.awt.Rectangle getBounds();

  protected Color color;                             // Color of a shape
  public abstract void modify(Point start, Point last);

  public abstract void draw(Graphics2D g2D);
  
  
  
  // Nested class defining a line
  public static class Line extends Element {
    public Line(Point start, Point end, Color color) {
      super(color);
      line = new Line2D.Double(start, end);
    }

    public java.awt.Rectangle getBounds() {
      return line.getBounds();  
    }

    public void modify(Point start, Point last) {
      line.x2 = last.x;
      line.y2 = last.y;
    }

    public void draw(Graphics2D g2D)  {
      g2D.setPaint(color);                      // Set the line color
      g2D.draw(line);                           // Draw the line
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

    public java.awt.Rectangle getBounds() { 
      return rectangle.getBounds();  
    }

    public void modify(Point start, Point last) {
      rectangle.x = Math.min(start.x, last.x);
      rectangle.y = Math.min(start.y, last.y);
      rectangle.width = Math.abs(start.x - last.x);
      rectangle.height = Math.abs(start.y - last.y);
    }

    public void draw(Graphics2D g2D)  {
      g2D.setPaint(color);                      // Set the line color
      g2D.draw(rectangle);                      // Draw the rectangle
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

    public java.awt.Rectangle getBounds() { 
      return circle.getBounds();  
    }

    public void modify(Point center, Point circum) {
      double radius = center.distance(circum);
      circle.x = center.x - (int)radius;
      circle.y = center.y - (int)radius;
      circle.width = circle.height = 2*radius;
    }

    public void draw(Graphics2D g2D)  {
      g2D.setPaint(color);                      // Set the line color
      g2D.draw(circle);                           // Draw the circle
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

    public java.awt.Rectangle getBounds() { 
      return curve.getBounds();  
    }

    public void draw(Graphics2D g2D)  {
      g2D.setPaint(color);                      // Set the line color
      g2D.draw(curve);                           // Draw the curve
    }

    private GeneralPath curve;
  }


  // Class defining text element
  public static class Text extends Element  {
    public Text(Font font, String text, Point position, Color color,
                                        java.awt.Rectangle bounds) {
      super(color);
      this.font = font;
      this.position = position;
      this.text = text;
      this.bounds = bounds;
      this.bounds.setLocation(position.x, position.y - (int)bounds.getHeight());
    }

    public java.awt.Rectangle getBounds() {
      return bounds;
    }

    public void draw(Graphics2D g2D)  {
      g2D.setPaint(color);
      Font oldFont = g2D.getFont();                // Save the old font
      g2D.setFont(font);                          // Set the new font
      g2D.drawString(text, position.x, position.y);
      g2D.setFont(oldFont);                        // Restore the old font
    }

    public void modify(Point start, Point last) {
      // No code is required here, but we must supply a definition
    }

    private Font font;                             // The font to be used
    private String text;                           // Text to be displayed
    private Point position;                        // Position of the text
   java.awt.Rectangle bounds;                      // The bounding rectangle
  }
}
