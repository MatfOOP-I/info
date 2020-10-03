package p14;
//: c14:JTableDemo.java
// Simple demonstration of JTable.
// <applet code=Table width=350 height=200></applet>
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.event.*;
import com.bruceeckel.swing.*;

public class JTableDemo extends JApplet {
  private JTextArea txt = new JTextArea(4, 20);
  // The TableModel controls all the data:
  class DataModel extends AbstractTableModel {
    Object[][] data = {
      {"one", "two", "three", "four"},
      {"five", "six", "seven", "eight"},
      {"nine", "ten", "eleven", "twelve"},
    };
    // Prints data when table changes:
    class TML implements TableModelListener {
      public void tableChanged(TableModelEvent e) {
        txt.setText(""); // Clear it
        for(int i = 0; i < data.length; i++) {
          for(int j = 0; j < data[0].length; j++)
            txt.append(data[i][j] + " ");
          txt.append("\n");
        }
      }
    }
    public DataModel() { addTableModelListener(new TML());}
    public int getColumnCount() { return data[0].length; }
    public int getRowCount() { return data.length; }
    public Object getValueAt(int row, int col) {
      return data[row][col];
    }
    public void setValueAt(Object val, int row, int col) {
      data[row][col] = val;
      // Indicate the change has happened:
      fireTableDataChanged();
    }
    public boolean isCellEditable(int row, int col) {
      return true;
    }
  }
  public void init() {
    Container cp = getContentPane();
    JTable table = new JTable(new DataModel());
    cp.add(new JScrollPane(table));
    cp.add(BorderLayout.SOUTH, txt);
  }
  public static void main(String[] args) {
    Console.run(new JTableDemo(), 350, 200);
  }
} ///:~