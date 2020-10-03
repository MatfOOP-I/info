package v15a.v02;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;


public class TangAplet extends Applet implements ActionListener {
  
   public void init () {
   
     //  Konstruisemo dugme
     Button tang = new Button("Tang");

     // Dodajemo komponentu
     this.add(tang);

     // Navodimo da akcije izazvane dogadjajem pritiska na dugme
     // treba da budu primenjene u samom apletu
     tang.addActionListener(this);
   
   }

  public void actionPerformed(ActionEvent d) {

    Toolkit.getDefaultToolkit().beep();

  }

}

