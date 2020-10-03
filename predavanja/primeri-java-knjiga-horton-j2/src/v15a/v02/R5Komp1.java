package v15a.v02;
import java.awt.*;
import java.awt.Font;

 public class  R5Komp1 extends java.applet.Applet{
    Panel p1 = new Panel();
    Panel p2 = new Panel();

  public void init(){

     setLayout(new GridLayout());
     //setLayout(new GridLayout(2,2, 10,20));

     p1.setLayout(new FlowLayout(FlowLayout.RIGHT));
     p1.add(new Label("Dugme 1"));
     p1.add(new Button("Prvo"));

        p2.setLayout(new BorderLayout());
        p2.add("East", new Button("Isticno dugme"));
        p2.add("North",new Button("Ovo je SEVER"));
        p2.add("West", new Button("ZAPAD!"));
	//p2.add(new Label("Dugme2", Label.RIGHT));
        //p2.add(new Button("Desno"));

     add(p1);
     add(p2);
     Label labela = new Label("Ovo je nova labela");
     add(labela);
     Button dugme = new Button("Dugmence");
     add(dugme);
   }
 }
