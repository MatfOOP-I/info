package p14;
//: c14:InvokeLaterFrame.java
// Eliminating race Conditions using Swing Components.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.bruceeckel.swing.Console;

public class InvokeLaterFrame extends JFrame {
  private JTextField statusField =
    new JTextField("Initial Value");
  public InvokeLaterFrame() {
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
  public static void main(String[] args) {
    final InvokeLaterFrame ilf = new InvokeLaterFrame();
    Console.run(ilf, 150, 60);
    // Use invokeAndWait() to synchronize output to prompt:
    // SwingUtilities.invokeAndWait(new Runnable() {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        ilf.statusField.setText("Application ready");
      }
    });
    System.out.println("Done");
  }
} ///:~
