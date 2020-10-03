package v15a.v03;
import java.applet.*;
import java.awt.*;
import java.awt.Frame;

 public class CrtaApl extends Applet{


 public static void main(String args[]) {
    
  CrtaApl a = new CrtaApl();
  a.init();
  a.start();
  
  Frame appletFrame = new Frame("Prozor Apleta");
  appletFrame.add("Center", a);
  appletFrame.setSize(400,400);
  appletFrame.setLocation(100,100);
  appletFrame.setVisible(true);
 
}

   public  void paint (Graphics g){
     g.setColor(Color.blue);
     g.drawOval( 10, 10, 75, 100);
     g.fillOval(100, 100, 50,50);
     g.drawArc(200, 200, 100, 80, 45, 130);
     g.fillArc(200,100, 50, 50, 20, -150);
     
 }
}
