package p14;
//: c14:BorderLayout1.java
// Demonstrates BorderLayout.
//<applet code=BorderLayout1 width=300 height=250></applet>
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import javax.swing.*;
import java.awt.*;
import com.bruceeckel.swing.*;

public class BorderLayout1 extends JApplet {
  public void init() {
    Container cp = getContentPane();
    cp.add(BorderLayout.NORTH, new JButton("North"));
    cp.add(BorderLayout.SOUTH, new JButton("South"));
    cp.add(BorderLayout.EAST, new JButton("East"));
    cp.add(BorderLayout.WEST, new JButton("West"));
    cp.add(BorderLayout.CENTER, new JButton("Center"));
  }
  public static void main(String[] args) {
    Console.run(new BorderLayout1(), 300, 250);
  }
} ///:~
