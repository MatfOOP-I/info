package v06.v09PovezanaLista;
public class PolyLine
{
  // Construct a polyline from an array of coordinate pairs
  public PolyLine(double[][] coords)
  {
    Point[] points = new Point[coords.length];  // Array to hold points

    // Create points from the coordinates
    for(int i = 0; i < coords.length ; i++)
      points[i] = new Point(coords[i][0], coords[i][1]);

    // Create the polyline from the array of points
    polyline = new LinkedList(points); 
  }

  // Construct a polyline from an array of points
  public PolyLine(Point[] points)
  {
    polyline = new LinkedList(points);      // Create the polyline
  }
  
  // Add a Point object to the list
   public void addPoint(Point point)
   {
    polyline.addItem(point);                // Add the point to the list
   }

  // Add a point from a coordinate pair to the list
   public void addPoint(double x, double y)
   {
     polyline.addItem(new Point(x, y));     // Add the point to the list
  }

  // String representation of a polyline
  public String toString()
  {
    StringBuffer str = new StringBuffer("Polyline:");
    Point point = (Point) polyline.getFirst();  
                                            // Set the 1st point as start
    while(point != null)
    {
      str.append(" ("+ point+ ")");         // Append the current point
      point = (Point)polyline.getNext();    // Make the next point current
    }
    return str.toString();
  }

  private LinkedList polyline;              // The linked list of points
}
