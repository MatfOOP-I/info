package v06.v08ListaTacaka;
public class PolyLine
{
  // Construct a polyline from an array of points
  public PolyLine(Point[] points)
  {
    if(points != null)                             // Make sure there is an array
    {
      // Create a one point list
      start = new ListPoint(points[0]);      // 1st point is the start
      end = start;                                 // as well as the end

      // Now add the other points
      for(int i = 1; i < points.length; i++)
        addPoint(points[i]);
    }
  }

  // Construct a polyline from an array of coordinates
   public PolyLine(double[][] coords)
   {
      if(coords != null)
     {
       // Create a one point list
       start = new ListPoint(new Point(coords[0][0], coords[0][1]));
                                               // First is start
       end = start;                            // as well as end

       // Now add the other points
       for(int i = 1; i < coords.length ; i++)
         addPoint(coords[i][0], coords[i][1]);
    }
  }

  // Add a Point object to the list
  public void addPoint(Point point)
  {
    ListPoint newEnd = new ListPoint(point);     // Create a new ListPoint
    if(start == null)
      start = newEnd;                            // Start is same as end
    else
      end.setNext(newEnd);       // Set next variable for old end as new end
    end = newEnd;                                // Store new point as end 
  }

  // Add a point to the list
  public void addPoint(double x, double y)
  {
    addPoint(new Point(x, y));
  }

  // String representation of a polyline
  public String toString()
  {
    StringBuffer str = new StringBuffer("Polyline:");
    ListPoint nextPoint = start;            // Set the 1st point as start
    while(nextPoint != null)
    {
      str.append(" "+ nextPoint);           // Output the current point
      nextPoint = nextPoint.getNext();      // Make the next point current
    }
    return str.toString();
  }

  private ListPoint start;                  // First ListPoint in the list
  private ListPoint end;                    // Last ListPoint in the list
}
