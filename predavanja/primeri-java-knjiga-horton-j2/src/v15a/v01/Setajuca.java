package v15a.v01;
import java.awt.*;
import java.awt.Font;

 public class Setajuca extends java.applet.Applet{
    Font f = new Font("TimesRoman", Font.BOLD, 22);

  public void init(){
     setFont(f);

     List nova = new List(3, true);

     nova.addItem("Odbojka");
     nova.addItem("Kosarka");
     nova.addItem("Rukomet");
     nova.addItem("Vaterpolo");
     nova.addItem("Fudbal");
     add(nova);

     
     List prob = new List();
     prob.addItem("Pera");
     prob.addItem("Zika");
     prob.addItem("Mika");
     prob.addItem("Sima");
     prob.addItem("Djoka");
     prob.addItem("Aca");
     add(prob);
     

   }
 }
