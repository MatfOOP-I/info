package v06.v09PovezanaLista;
public class Point
{
  // Create a point from its coordinates
  public Point(double xVal, double yVal)
  {
     x = xVal;
     y = yVal;
  }

  // Create a point from another point
  public Point(Point point)
  {
     x = point.x;
     y = point.y;
  }

  // Convert a point to a string
  public String toString()
  { 
     return x+","+y; 
  }

  // Coordinates of the point
  protected double x;
  protected double y;
}
