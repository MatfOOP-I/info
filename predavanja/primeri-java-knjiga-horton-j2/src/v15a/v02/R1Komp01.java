package v15a.v02;
import java.awt.*;
import java.awt.Font;

 public class  R1Komp01 extends java.applet.Applet{
    Font f = new Font("TimesRoman", Font.BOLD, 26);
    Label labela;
    Button dugme;

  public void init(){
     setFont(f);
     setLayout(new FlowLayout(FlowLayout.LEFT, 40,40));
     add(new Label("Levo dugme", Label.LEFT));
     add(new Button("Levo"));
     add(new Label("Desno dugme", Label.RIGHT));
     add(new Button("Desno"));
     add(new Label("Centrirano dugme", Label.CENTER));
     add(new Button("CENTRALNO"));
     labela = new Label("Ovo je nova labela");
     add(labela);
     dugme = new Button("Dugmence");
     add(dugme);
   }
 }
