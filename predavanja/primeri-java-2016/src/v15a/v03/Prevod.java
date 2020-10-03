package v15a.v03;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Prevod extends Applet implements ActionListener {

  TextField tc= new TextField(9), tf=new TextField(9);


  public void init() {
  
    add(new Label("Farenhajt"));
    add(tf);
    add(new Label("Celzijus"));
    add(tc);
    tf.addActionListener(this);
    tc.addActionListener(this);
}

  public void actionPerformed (ActionEvent e){
     double f, c;
     if (e.getSource()==tf){
       f=new Double(tf.getText()).doubleValue();
       c=5.0*(f-32.0)/9.0;
       tc.setText(c+" ");
     }
     else{
       c=new Double(tc.getText()).doubleValue();
       f=9.0*c/5.0+32.0;
       tf.setText(f+" ");
     }
}
}