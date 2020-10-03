package v16.v02KoriscenjeGrafickogOkruzenja;
import javax.swing.JFrame;
import java.awt.Point;
import java.awt.GraphicsEnvironment;

public class TryWindow
{
  // The window object
  static JFrame aWindow = new JFrame("This is the Window Title"); 

  public static void main(String[] args)
  {
    Point center = 
              GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
    int windowWidth = 400;
    int windowHeight = 150;
    // set position and size
    aWindow.setBounds(center.x-windowWidth/2, center.y-windowHeight/2, windowWidth, windowHeight); 
    aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    aWindow.setVisible(true);                           // Display the window
  }
}
