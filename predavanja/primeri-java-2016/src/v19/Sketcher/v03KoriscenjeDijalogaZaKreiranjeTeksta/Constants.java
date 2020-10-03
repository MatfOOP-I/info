// Defines application wide constants
package v19.Sketcher.v03KoriscenjeDijalogaZaKreiranjeTeksta;
import java.awt.Color;
import java.awt.Font;

public interface Constants { 
  // Element type definitions
  int LINE      = 101;
  int RECTANGLE = 102;
  int CIRCLE    = 103;
  int CURVE     = 104;
  int TEXT      = 105;
  
  // Initial conditions
  int DEFAULT_ELEMENT_TYPE = LINE;
  Color DEFAULT_ELEMENT_COLOR = Color.BLUE;
  Font DEFAULT_FONT = new Font("Times New Roman",Font.PLAIN, 12);
}
