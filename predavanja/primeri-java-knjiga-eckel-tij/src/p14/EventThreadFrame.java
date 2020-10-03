package p14;
//: c14:EventThreadFrame.java
// Race Conditions using Swing Components.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.bruceeckel.swing.Console;

public class EventThreadFrame extends JFrame {
  private JTextField statusField =
    new JTextField("Initial Value");
  public EventThreadFrame() {
    Container cp = getContentPane();
    cp.add(statusField, BorderLayout.NORTH);
    addWindowListener(new WindowAdapter() {
      public void windowOpened(WindowEvent e) {
        try { // Simulate initialization overhead
          Thread.sleep(2000);
        } catch (InterruptedException ex) {
          throw new RuntimeException(ex);
        }
        statusField.setText("Initialization complete");
      }
    });
  }
  public static void main (String[] args) {
    EventThreadFrame etf = new EventThreadFrame();
    Console.run(etf, 150, 60);
    etf.statusField.setText("Application ready");
    System.out.println("Done");
  }
} ///:~
