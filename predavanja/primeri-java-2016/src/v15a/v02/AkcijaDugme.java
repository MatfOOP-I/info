package v15a.v02;
 import java.awt.*;
 
 public class AkcijaDugme extends java.applet.Applet {
 
   public void init() {
     setBackground(Color.white);
 
    add(new Button("Crvena"));
    add(new Button("Plava"));
    add(new Button("Zelena"));
    add(new Button("Bela"));
    add(new Button("Crna"));
  }

  public boolean action(Event evt, Object arg) {
    if (evt.target instanceof Button) {
      promenaBoje((String)arg);
      return true;
    } else return false;
  }

  void promenaBoje(String bojaIme) {
    if (bojaIme.equals("Crvena")) setBackground(Color.red);
    else if (bojaIme.equals("Plava")) setBackground(Color.blue);
    else if (bojaIme.equals("Zelena")) setBackground(Color.green);
    else if (bojaIme.equals("Bela")) setBackground(Color.white);
    else setBackground(Color.black);

    repaint();
  }
}

