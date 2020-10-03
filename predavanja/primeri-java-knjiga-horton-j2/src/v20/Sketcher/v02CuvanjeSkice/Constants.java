// Defines application wide constants
package v20.Sketcher.v02CuvanjeSkice;
import java.awt.Color;
import java.awt.Font;
import java.io.File;

public interface Constants { 
  // Element type definitions
  int LINE      = 101;
  int RECTANGLE = 102;
  int CIRCLE    = 103;
  int CURVE     = 104;
  int TEXT      = 105;
  
  int pointSizeMin = 8;    // Minimum font point size
  int pointSizeMax = 24;   // Maximum font point size
  int pointSizeStep = 2;   // Point size step

  // Initial conditions
  int DEFAULT_ELEMENT_TYPE = LINE;
  Color DEFAULT_ELEMENT_COLOR = Color.BLUE;
  Font DEFAULT_FONT = new Font("Times New Roman",Font.PLAIN, 12);

  File DEFAULT_DIRECTORY = new File("C:/Sketches");
  String DEFAULT_FILENAME = "Sketch.ske";

  // Operating modes
  int NORMAL = 0;
  int MOVE   = 1;
  int ROTATE = 2;
}
