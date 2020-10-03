package v15a.v02;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class VelikaSlova1 extends Applet {

  TextField ulaz;
  TextField izlaz;
  
  public void init () {
   
     //  Konstruisemo tekstovna polja
     this.ulaz = new TextField(40);
     this.izlaz = new TextField(40);
     this.izlaz.setEditable(false);
    
     // dodajemo ih:
     this.add(ulaz);
     this.add(izlaz);

     // Opisujemo akciju koju izaziva unos u datoteku ulaz
     
     UvelicanjeSlova us = new UvelicanjeSlova(ulaz,izlaz);
     this.ulaz.addActionListener(us);

     // Akcije izavane dogadjajem u datoteci izlaz su igorisane.
   }
}

class UvelicanjeSlova implements ActionListener {

  TextField in;
  TextField out;

  public UvelicanjeSlova(TextField in, TextField out) {
    this.in = in;
    this.out = out;
  }

  public void actionPerformed(ActionEvent ae) {

    String s = in.getText();
    out.setText(s.toUpperCase());

  }

}

