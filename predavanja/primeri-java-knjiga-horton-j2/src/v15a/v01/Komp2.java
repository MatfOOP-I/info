package v15a.v01;
import java.awt.*;
import java.awt.Font;

 public class Komp2 extends java.applet.Applet{
    Font f = new Font("TimesRoman", Font.BOLD, 22);

  public void init(){
     setFont(f);
     setForeground(Color.red);
     add(new Checkbox("Kola"));
     add(new Checkbox("Pivo"));
     add(new Checkbox("Vino"));
     add(new Checkbox("Rakija"));
     add(new Checkbox("Tonic", null, true));
     add(new Checkbox("Sok-narandza"));
 
     setForeground(Color.blue);
     add(new Label("Sledi primer sa radio-dugmadima"));
     CheckboxGroup  grupa=new CheckboxGroup();
     add(new Checkbox("Plava", grupa, true));
     add(new Checkbox("Crvena", grupa, true));
     add(new Checkbox("Zelena", grupa, true));
     add(new Checkbox("Bela", grupa, false));
     

   }
 }
