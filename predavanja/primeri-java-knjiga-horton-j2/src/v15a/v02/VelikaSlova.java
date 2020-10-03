package v15a.v02;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;


public class VelikaSlova extends Applet {

  TextField input;
  TextField output;
  
  public void init () {
   
     // Construct the TextFields
     this.input = new TextField(40);
     this.output = new TextField(40);
     this.output.setEditable(false);
     Button b = new Button("Capitalize");

     // add the button to the layout
     this.add(input);
     this.add(b);
     this.add(output);

     // specify that action events sent by the
     // button or the input TextField should be handled 
     // by the same CaptializerAction object
     CapitalizerAction ca = new CapitalizerAction(input, output);
     b.addActionListener(ca);
     this.input.addActionListener(ca);

     // notice that ActionEvents produced by output are ignored.
   
   }

}


class CapitalizerAction implements ActionListener {

  TextField in;
  TextField out;

  public CapitalizerAction(TextField in, TextField out) {
    this.in = in;
    this.out = out;
  }

  public void actionPerformed(ActionEvent ae) {

    String s = in.getText();
    out.setText(s.toUpperCase());

  }

}

