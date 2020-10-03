package v15a.v03;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

class Alert extends Dialog implements ActionListener {

  public Alert (String s) {
  
    super(new Frame(), true);

    this.add("Center", new Label(s));
    Panel p = new Panel();
    p.setLayout(new BorderLayout());

    Button yes = new Button("Yes");
    yes.addActionListener(this);
    p.add("West",yes);

    Button no = new Button("No");
    no.addActionListener(this);
    p.add("East",no);

    this.add("South", p);
    this.setSize(300,100);
    this.setLocation(100, 200);
  
  }  
  
  public void actionPerformed(ActionEvent e) {

    this.setVisible(false);
    this.dispose();
  }
  
}


public class PraviDialog extends Applet {

  public void init () {
     
     Alert a = new  Alert(" Da li si siguran da umes da plivas?");
     a.setVisible(true);
    
  }

}

