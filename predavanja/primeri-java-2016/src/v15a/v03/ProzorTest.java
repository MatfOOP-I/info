package v15a.v03;
import java.awt.*;
import java.applet.*;

public class ProzorTest extends Applet {

  public void init() {
    
    Frame mojFrame = new Frame("Moj prozor u apletu");
    mojFrame.setSize(250, 250);
    mojFrame.setLocation(300,200);
    mojFrame.add("North", new TextArea(10, 40));
    mojFrame.setVisible(true); 
  } 
}

