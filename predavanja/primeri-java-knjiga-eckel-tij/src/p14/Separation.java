package p14;
//: c14:Separation.java
// Separating GUI logic and business objects.
// <applet code=Separation width=250 height=150></applet>
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.applet.*;
import com.bruceeckel.swing.*;

class BusinessLogic {
  private int modifier;
  public BusinessLogic(int mod) { modifier = mod; }
  public void setModifier(int mod) { modifier = mod; }
  public int getModifier() { return modifier; }
  // Some business operations:
  public int calculation1(int arg){ return arg * modifier;}
  public int calculation2(int arg){ return arg + modifier;}
}

public class Separation extends JApplet {
  private JTextField
    t = new JTextField(15),
    mod = new JTextField(15);
  private JButton
    calc1 = new JButton("Calculation 1"),
    calc2 = new JButton("Calculation 2");
  private BusinessLogic bl = new BusinessLogic(2);
  public static int getValue(JTextField tf) {
    try {
      return Integer.parseInt(tf.getText());
    } catch(NumberFormatException e) {
      return 0;
    }
  }
  class Calc1L implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      t.setText(Integer.toString(
        bl.calculation1(getValue(t))));
    }
  }
  class Calc2L implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      t.setText(Integer.toString(
        bl.calculation2(getValue(t))));
    }
  }
  // If you want something to happen whenever
  // a JTextField changes, add this listener:
  class ModL implements DocumentListener {
    public void changedUpdate(DocumentEvent e) {}
    public void insertUpdate(DocumentEvent e) {
      bl.setModifier(getValue(mod));
    }
    public void removeUpdate(DocumentEvent e) {
      bl.setModifier(getValue(mod));
    }
  }
  public void init() {
    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());
    cp.add(t);
    calc1.addActionListener(new Calc1L());
    calc2.addActionListener(new Calc2L());
    JPanel p1 = new JPanel();
    p1.add(calc1);
    p1.add(calc2);
    cp.add(p1);
    mod.getDocument().addDocumentListener(new ModL());
    JPanel p2 = new JPanel();
    p2.add(new JLabel("Modifier:"));
    p2.add(mod);
    cp.add(p2);
  }
  public static void main(String[] args) {
    Console.run(new Separation(), 250, 100);
  }
} ///:~