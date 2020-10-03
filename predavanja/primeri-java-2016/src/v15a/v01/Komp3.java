package v15a.v01;
import java.awt.*;
import java.awt.Font;

 public class Komp3 extends java.applet.Applet{
    Font f = new Font("TimesRoman", Font.BOLD, 22);

  public void init(){
     setFont(f);

     Choice c = new Choice();

     c.addItem("Jabuka");
     c.addItem("Kruska");
     c.addItem("Kajsija");
     c.addItem("Sljiva");
     c.addItem("Jagoda");
     add(c);
     c.addItem("Visnja");
     c.addItem("Kivi");

     
     add(new TextField());
     add(new TextField(30));
     add(new TextField("Unesite Vase ime ovde"));
     add(new TextField("Ovo je samo proba", 6));
     TextField tf= new TextField(20);
     tf.setEchoCharacter('&');
     add(tf);
     add(new TextField("Pera"));
     

   }
 }
