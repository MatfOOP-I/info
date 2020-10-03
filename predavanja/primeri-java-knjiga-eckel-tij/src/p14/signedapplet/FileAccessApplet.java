//: c14:signedapplet:FileAccessApplet.java
// Demonstration of File dialog boxes.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
package p14.signedapplet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import com.bruceeckel.swing.*;
import com.bruceeckel.swing.Console;

public class FileAccessApplet extends JApplet {
  private JTextField
    filename = new JTextField(),
    dir = new JTextField();
  private JButton
    open = new JButton("Open"),
    save = new JButton("Save");
  private JEditorPane ep = new JEditorPane();
  private JScrollPane jsp = new JScrollPane();
  private File file;
  public void init() {
    JPanel p = new JPanel();
    open.addActionListener(new OpenL());
    p.add(open);
    save.addActionListener(new SaveL());
    p.add(save);
    Container cp = getContentPane();
    jsp.getViewport().add(ep);
    cp.add(jsp, BorderLayout.CENTER);
    cp.add(p, BorderLayout.SOUTH);
    dir.setEditable(false);
    save.setEnabled(false);
    ep.setContentType("text/html");
    filename.setEditable(false);
    p = new JPanel();
    p.setLayout(new GridLayout(2, 1));
    p.add(filename);
    p.add(dir);
    cp.add(p, BorderLayout.NORTH);
  }
  class OpenL implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JFileChooser c = new JFileChooser();
      c.setFileFilter(new TextFileFilter());
      // Demonstrate "Open" dialog:
      int rVal = c.showOpenDialog(FileAccessApplet.this);
      if(rVal == JFileChooser.APPROVE_OPTION) {
        file = c.getSelectedFile();
        filename.setText(file.getName());
        dir.setText(c.getCurrentDirectory().toString());
        try {
          System.out.println("Url is " + file.toURL());
          ep.setPage(file.toURL());
          // ep.repaint();
        } catch (IOException ioe) {
          throw new RuntimeException(ioe);
        }
      }
      if(rVal == JFileChooser.CANCEL_OPTION) {
        filename.setText("You pressed cancel");
        dir.setText("");
      } else {
        save.setEnabled(true);
      }
    }
  }
  class SaveL implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JFileChooser c = new JFileChooser(file);
      c.setSelectedFile(file);
      // Demonstrate "Save" dialog:
      int rVal = c.showSaveDialog(FileAccessApplet.this);
      if(rVal == JFileChooser.APPROVE_OPTION) {
        filename.setText(c.getSelectedFile().getName());
        dir.setText(c.getCurrentDirectory().toString());
        try {
          FileWriter fw = new FileWriter(file);
          ep.write(fw);
        } catch (IOException ioe) {
          throw new RuntimeException(ioe);
        }
      }
      if(rVal == JFileChooser.CANCEL_OPTION) {
        filename.setText("You pressed cancel");
        dir.setText("");
      }
    }
  }
  public class TextFileFilter extends
    javax.swing.filechooser.FileFilter {
    public boolean accept(File f) {
      return f.getName().endsWith(".txt")
        || f.isDirectory();
    }
    public String getDescription() {
      return "Text Files (*.txt)";
    }
  }
  public static void main(String[] args) {
    Console.run(new FileAccessApplet(), 500, 500);
  }
} ///:~