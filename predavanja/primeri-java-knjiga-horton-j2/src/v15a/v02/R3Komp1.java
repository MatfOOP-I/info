package v15a.v02;
import java.awt.*;
import java.awt.Font;

 public class  R3Komp1 extends java.applet.Applet{
    
  public void init(){
     setLayout(new BorderLayout(10,10));
     add("East", new Button("Isticno dugme"));
     add("North",new Button("Ovo je SEVER"));
     add("West", new Button("ZAPAD!"));
     add("West", new Button("Dodatni Zapad"));
     add("West", new Label("Zapadana labela"));
     add("Center", new TextField("Ovde obratite pazju", 50));
     add("South", new Button("Ovo je JUG"));
     //setLayout(new FlowLayout());
     //add(new Button("Novo Dugme"));
    
   }
 }
