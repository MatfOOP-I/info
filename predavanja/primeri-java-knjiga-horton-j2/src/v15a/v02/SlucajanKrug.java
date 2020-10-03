package v15a.v02;
import java.awt.*;
import java.awt.event.*;

 public class SlucajanKrug extends java.applet.Applet
    implements ActionListener{

   Button krugDugme;

  public void init(){

     krugDugme = new Button("Krug");
     add(krugDugme);
     krugDugme.addActionListener(this);
  }

  public void paint (Graphics g) {
     int x, y, r, precnik;
     int c, z, p;
     int vel=300;

     setBackground(Color.white);
     
     x = (int) (vel*Math.random());
     y = (int) (vel*Math.random());

     precnik = (int) (vel*Math.random());
     r = precnik % 2;

     c= (int)Math.floor(Math.random()*256);
     z= (int)Math.floor(Math.random()*256);
     p= (int)Math.floor(Math.random()*256);

     g.setColor(new Color(c,z,p));
     g.fillOval(x-r, y-r, precnik, precnik);
   }

    public void actionPerformed(ActionEvent dogadjaj){
      repaint();
    }
     public void update (Graphics g) {
          paint(g);
    }  
 }
