package v05.v07RadSaPaketima;

import v05.v07RadSaPaketima.Geometry.*;    // Import the Point and Line classes

public class TryPackage
{
  public static void main(String[] args)
  {
    double[][] coords = { {1.0, 0.0}, {6.0, 0.0}, {6.0, 10.0},
                          {10.0,10.0}, {10.0, -14.0}, {8.0, -14.0}};

    // Create an array of points and fill it with Point objects
    Point[] points = new Point[coords.length]; 
    for(int i = 0; i < coords.length; i++)
      points[i] = new Point(coords[i][0],coords[i][1]);

    // Create an array of lines and fill it using Point pairs
    Line[] lines = new Line[points.length - 1]; 
    double totalLength = 0.0;           // Store total line length here
    for(int i = 0; i < points.length - 1; i++)
    {
      lines[i] = new Line(points[i], points[i+1]); // Create a Line
      totalLength += lines[i].length();            // Add its length
      System.out.println("\nLine "+(i+1)+' ' +lines[i] + 
                         "  Length is " + lines[i].length());
    }

    // Output the total length
    System.out.println("\n\nTotal line length = " + totalLength);
  }
}
