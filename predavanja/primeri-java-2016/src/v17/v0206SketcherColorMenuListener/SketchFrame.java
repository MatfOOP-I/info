// Frame for the Sketcher application
package v17.v0206SketcherColorMenuListener;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.KeyStroke;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Event;
import java.awt.Color;

public class SketchFrame extends JFrame implements Constants {

  // Constructor
  public SketchFrame(String title) {
    setTitle(title);                             // Set the window title
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    setJMenuBar(menuBar);                        // Add the menu bar to the window

    JMenu fileMenu = new JMenu("File");          // Create File menu
    JMenu elementMenu = new JMenu("Elements");   // Create Elements menu
    fileMenu.setMnemonic('F');                   // Create shortcut
    elementMenu.setMnemonic('E');                // Create shortcut

    // Construct the file pull down menu
    newItem = fileMenu.add("New");                // Add New item
    openItem = fileMenu.add("Open");              // Add Open item
    closeItem = fileMenu.add("Close");            // Add Close item
    fileMenu.addSeparator();                      // Add separator
    saveItem = fileMenu.add("Save");              // Add Save item
    saveAsItem = fileMenu.add("Save As...");      // Add Save As item

    JMenu colorMenu = new JMenu("Color");         // Color sub-menu

    fileMenu.addSeparator();                      // Add separator
    printItem = fileMenu.add("Print");            // Add Print item

    // Add File menu accelerators
    newItem.setAccelerator(KeyStroke.getKeyStroke('N',Event.CTRL_MASK ));
    openItem.setAccelerator(KeyStroke.getKeyStroke('O',Event.CTRL_MASK ));
    saveItem.setAccelerator(KeyStroke.getKeyStroke('S',Event.CTRL_MASK ));
    printItem.setAccelerator(KeyStroke.getKeyStroke('P',Event.CTRL_MASK ));

    // Construct the Element pull down menu
    elementMenu.add(lineItem = new JRadioButtonMenuItem(
                                            "Line", elementType==LINE));
    elementMenu.add(rectangleItem = new JRadioButtonMenuItem(
                                            "Rectangle", elementType==RECTANGLE));
    elementMenu.add(circleItem = new JRadioButtonMenuItem(
                                            "Circle", elementType==CIRCLE));
    elementMenu.add(curveItem = new JRadioButtonMenuItem(
                                            "Curve", elementType==CURVE));
    ButtonGroup types = new ButtonGroup();
    types.add(lineItem);
    types.add(rectangleItem);
    types.add(circleItem);
    types.add(curveItem);

    // Add element type accelerators
    lineItem.setAccelerator(KeyStroke.getKeyStroke('L',Event.CTRL_MASK ));
    rectangleItem.setAccelerator(KeyStroke.getKeyStroke('E',Event.CTRL_MASK ));
    circleItem.setAccelerator(KeyStroke.getKeyStroke('I',Event.CTRL_MASK ));
    curveItem.setAccelerator(KeyStroke.getKeyStroke('V',Event.CTRL_MASK ));

    elementMenu.addSeparator();

    elementMenu.add(colorMenu);                   // Add the sub-menu
    colorMenu.add(redItem = new JCheckBoxMenuItem(                                                                        
                            "Red", elementColor.equals(Color.RED)));
    colorMenu.add(yellowItem = new JCheckBoxMenuItem(
                            "Yellow", elementColor.equals(Color.YELLOW)));
    colorMenu.add(greenItem = new JCheckBoxMenuItem(
                            "Green", elementColor.equals(Color.GREEN)));
    colorMenu.add(blueItem = new JCheckBoxMenuItem(
                            "Blue", elementColor.equals(Color.BLUE)));

    ButtonGroup colors = new ButtonGroup();     // Color menu items button group
    colors.add(redItem);
    colors.add(yellowItem);
    colors.add(greenItem);
    colors.add(blueItem);

    // Add element color accelerators
    redItem.setAccelerator(KeyStroke.getKeyStroke('R',Event.CTRL_MASK ));
    yellowItem.setAccelerator(KeyStroke.getKeyStroke('Y',Event.CTRL_MASK ));
    greenItem.setAccelerator(KeyStroke.getKeyStroke('G',Event.CTRL_MASK ));
    blueItem.setAccelerator(KeyStroke.getKeyStroke('B',Event.CTRL_MASK ));

    // Add type menu item listeners
    lineItem.addActionListener(new TypeListener(LINE));
    rectangleItem.addActionListener(new TypeListener(RECTANGLE));
    circleItem.addActionListener(new TypeListener(CIRCLE));
    curveItem.addActionListener(new TypeListener(CURVE));

    // Add color menu item listeners
    redItem.addActionListener(new ColorListener(Color.RED));
    yellowItem.addActionListener(new ColorListener(Color.YELLOW));
    greenItem.addActionListener(new ColorListener(Color.GREEN));
    blueItem.addActionListener(new ColorListener(Color.BLUE));

    menuBar.add(fileMenu);                       // Add the file menu
    menuBar.add(elementMenu);                    // Add the element menu 
  }

  private JMenuBar menuBar = new JMenuBar();     // Window menu bar

  // File menu items
  private JMenuItem newItem, openItem, closeItem,
                    saveItem, saveAsItem, printItem;

  // Element menu items
  private JRadioButtonMenuItem lineItem,  rectangleItem, circleItem,  // Types
                               curveItem, textItem;
  private JCheckBoxMenuItem    redItem,   yellowItem,                 // Colors
                               greenItem, blueItem ;  

  private Color elementColor = DEFAULT_ELEMENT_COLOR;   // Current element color
  private int elementType = DEFAULT_ELEMENT_TYPE;       // Current element type

  // Handles element type menu items
  class TypeListener implements ActionListener { 
    // Constructor
    TypeListener(int type) {
      this.type = type;
    }
    
    // Sets the element type
    public void actionPerformed(ActionEvent e) {
      elementType = type;  
    }

    private int type;                       // Store the type for the menu
  }

  // Handles color menu items
  class ColorListener implements ActionListener {
    public ColorListener(Color color) {
      this.color = color;
    }

    public void actionPerformed(ActionEvent e) {
      elementColor = color;
    }

    private Color color;
  }
}