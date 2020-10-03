package v15a.v03;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;

public class In1 extends Applet {
  Font f= new Font("TimesRoman", Font.BOLD, 18);
  TextField t;
  String poruka=" Cena je 45000               ";

 
  public void init() {
  
    Checkbox c;
    this.add(new Label("Kako placate?"));
    CheckboxGroup cbg = new CheckboxGroup();
    setFont(f);
 
    this.t = new TextField(poruka);
    // Sada sprecavamo da korisnici menjaju cenu
    t.setEditable(false); 

    Cenovnik p = new Cenovnik(poruka, t);
    c = new Checkbox("Visa", cbg, false);
    this.add(c);
    c.addItemListener(p);
    c = new Checkbox("Mastercard", cbg, false);
    c.addItemListener(p);
    this.add(c);
    c = new Checkbox("American Express", cbg, false);
    c.addItemListener(p);
    this.add(c);
    c = new Checkbox("Cek", cbg, false);
    c.addItemListener(p);
    this.add(c);
    c = new Checkbox("Kes", cbg, true);
    c.addItemListener(p);
    this.add(c);
    this.add(t);
    
  }
  
}

class Cenovnik implements ItemListener {

  TextField izlaz;
  String poruka;
  String naziv;

  public Cenovnik(String osnovna, TextField izlaz) {
    this.poruka = osnovna;
    this.izlaz = izlaz;
  }
  
  public void itemStateChanged(ItemEvent ie) {
  
    if (ie.getStateChange() == ItemEvent.SELECTED)
    {  
       naziv = (String) ie.getItem();
       if(naziv=="Kes") poruka="Svaka cast, majtore! Popust 10%";
       else if(naziv=="Mastercard") poruka="Zar  opet?";
       else if(naziv=="Cek") poruka= "Dokle cekovi!";
       else poruka="Uh,uh,uh,...  ";
      this.izlaz.setText(poruka);
    }
  }

}
