package v15a.v02;
import java.awt.*;
import java.awt.Font;

 public class  R4Komp1 extends java.applet.Applet{
    int tekuca=0;
  public void init(){
     CardLayout karte = new CardLayout();
     setLayout(karte);
     
     add("Prva", new Label("Srbija"));
     
     add("Druga", new Button("Vojvodina"));
     add("Treca", new Label("Crna Gora"));
     karte.show(this, "Prva");
     for(int i=0; i<10000000; i++)Math.random();
     
     karte.show(this, "Druga");

     for(int i=0; i<10000000; i++)Math.random();
     karte.show(this, "Treca");
   }
 }
