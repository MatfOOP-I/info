package v15a.v02;
import java.awt.*;
import java.awt.event.*;

 public class SlucKrug1 extends java.applet.Applet
    implements ActionListener{

    
   Button krugDugme;

  public void init(){

     krugDugme = new Button("Krug");
     add(krugDugme);
     krugDugme.addActionListener(this);
  }

  public void paint (Graphics g) {
     int x,y,precnik;
     x=y=precnik=(int)(400*Math.random());
     g.fillOval(x, y, precnik, precnik);
   }

    public void actionPerformed(ActionEvent dog){
      repaint();
    }
    
 }
