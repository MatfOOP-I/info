package v15a.v01;
import java.awt.*;
import java.awt.Font;

 public class Klizaci extends java.applet.Applet{
    

  public void init(){
     
     Scrollbar prvi = new Scrollbar();
     add(prvi);

     Scrollbar drugi = new Scrollbar(Scrollbar.HORIZONTAL);
     add(drugi);

     Scrollbar treci = new Scrollbar(Scrollbar.VERTICAL, 50, 0, 0, 100);
     add(treci);
     

   }
 }
