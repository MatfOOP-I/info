// Defines application wide constants
package v18.v04Sketcher.v00Pocetak;
import java.awt.Color;

public interface Constants { 
  // Element type definitions
  int LINE      = 101;
  int RECTANGLE = 102;
  int CIRCLE    = 103;
  int CURVE     = 104;

  // Initial conditions
  int DEFAULT_ELEMENT_TYPE = LINE;
  Color DEFAULT_ELEMENT_COLOR = Color.BLUE;
}
