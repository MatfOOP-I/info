package p14;
//: c14:DynamicEvents.java
// You can change event behavior dynamically.
// Also shows multiple actions for an event.
// <applet code=DynamicEvents
// width=250 height=400></applet>
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.bruceeckel.swing.*;

public class DynamicEvents extends JApplet {
  private java.util.List list = new ArrayList();
  private int i = 0;
  private JButton
    b1 = new JButton("Button1"),
    b2 = new JButton("Button2");
  private JTextArea txt = new JTextArea();
  class B implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      txt.append("A button was pressed\n");
    }
  }
  class CountListener implements ActionListener {
    private int index;
    public CountListener(int i) { index = i; }
    public void actionPerformed(ActionEvent e) {
      txt.append("Counted Listener " + index + "\n");
    }
  }
  class B1 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      txt.append("Button 1 pressed\n");
      ActionListener a = new CountListener(i++);
      list.add(a);
      b2.addActionListener(a);
    }
  }
  class B2 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      txt.append("Button2 pressed\n");
      int end = list.size() - 1;
      if(end >= 0) {
        b2.removeActionListener(
          (ActionListener)list.get(end));
        list.remove(end);
      }
    }
  }
  public void init() {
    Container cp = getContentPane();
    b1.addActionListener(new B());
    b1.addActionListener(new B1());
    b2.addActionListener(new B());
    b2.addActionListener(new B2());
    JPanel p = new JPanel();
    p.add(b1);
    p.add(b2);
    cp.add(BorderLayout.NORTH, p);
    cp.add(new JScrollPane(txt));
  }
  public static void main(String[] args) {
    Console.run(new DynamicEvents(), 250, 400);
  }
} ///:~