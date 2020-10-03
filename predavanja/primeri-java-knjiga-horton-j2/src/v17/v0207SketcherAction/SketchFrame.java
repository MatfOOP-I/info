// Frame for the Sketcher application
package v17.v0207SketcherAction;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import javax.swing.JMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Event;
import java.awt.BorderLayout;

import java.awt.event.ActionEvent;

import java.io.File;

public class SketchFrame extends JFrame implements Constants {

  // Constructor
  public SketchFrame(String title) {
    setTitle(title);                             // Set the window title
    setJMenuBar(menuBar);                       // Add the menu bar to the window
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    JMenu fileMenu = new JMenu("File");          // Create File menu
    JMenu elementMenu = new JMenu("Elements");   // Create Elements menu
    fileMenu.setMnemonic('F');                   // Create shortcut
    elementMenu.setMnemonic('E');                // Create shortcut

    // Create the action items for the file menu
    newAction = new FileAction("New", KeyStroke.getKeyStroke('N',Event.CTRL_MASK ));
    openAction = new FileAction("Open", KeyStroke.getKeyStroke('O',Event.CTRL_MASK ));
    closeAction = new FileAction("Close");
    saveAction = new FileAction("Save", KeyStroke.getKeyStroke('S',Event.CTRL_MASK ));
    saveAsAction = new FileAction("Save As...");
    printAction = new FileAction("Print", KeyStroke.getKeyStroke('P',Event.CTRL_MASK ));

    // Construct the file pull down menu
    addMenuItem(fileMenu, newAction);
    addMenuItem(fileMenu, openAction);
    addMenuItem(fileMenu, closeAction);
    fileMenu.addSeparator();                                      // Add separator
    addMenuItem(fileMenu, saveAction);
    addMenuItem(fileMenu, saveAsAction);
    fileMenu.addSeparator();                                      // Add separator
    addMenuItem(fileMenu, printAction);

    // Construct the Element pull down menu
    addMenuItem(elementMenu, lineAction = new TypeAction("Line", LINE));
    addMenuItem(elementMenu, rectangleAction = new TypeAction("Rectangle", RECTANGLE));
    addMenuItem(elementMenu, circleAction = new TypeAction("Circle", CIRCLE));
    addMenuItem(elementMenu, curveAction = new TypeAction("Curve", CURVE));

    // We will add the types menu items here using actions...

    fileMenu.addSeparator();                      // Add separator

    JMenu colorMenu = new JMenu("Color");         // Color sub-menu
    elementMenu.add(colorMenu);                   // Add the sub-menu

    // We will add the color menu items here using actions...
    addMenuItem(colorMenu, redAction = new ColorAction("Red", Color.RED));
    addMenuItem(colorMenu, yellowAction = new ColorAction("Yellow", Color.YELLOW));
    addMenuItem(colorMenu, greenAction = new ColorAction("Green", Color.GREEN));
    addMenuItem(colorMenu, blueAction = new ColorAction("Blue", Color.BLUE));
    
    menuBar.add(fileMenu);                       // Add the file menu
    menuBar.add(elementMenu);                    // Add the element menu 

    toolBar.setFloatable(false);    // Inhibit toolbar floating
    getContentPane().add(toolBar, BorderLayout.NORTH);

    // Add file buttons
    toolBar.addSeparator();                                 // Space at the start
    addToolBarButton(newAction);
    addToolBarButton(openAction);
    addToolBarButton(saveAction);
    addToolBarButton(printAction);
   
    // Add element type buttons
    toolBar.addSeparator();
    addToolBarButton(lineAction);
    addToolBarButton(rectangleAction);
    addToolBarButton(circleAction);
    addToolBarButton(curveAction);

    // Add element color buttons
    toolBar.addSeparator();
    addToolBarButton(redAction);
    addToolBarButton(yellowAction);
    addToolBarButton(greenAction);
    addToolBarButton(blueAction);
    toolBar.addSeparator();                            // Space at the end

    toolBar.setBorder(BorderFactory.createCompoundBorder(       // Toolbar border
                      BorderFactory.createLineBorder(Color.darkGray),
                      BorderFactory.createEmptyBorder(2,2,4,2)));   

    toolBar.setFloatable(false);                       // Inhibit toolbar floating
    getContentPane().add(toolBar, BorderLayout.NORTH); // Add the toolbar
  }

  private JButton addToolBarButton(Action action) {
    JButton button = toolBar.add(action);              // Add toolbar button
    button.setBorder(BorderFactory.createRaisedBevelBorder());// Add button border
    return button;
  }

  // We will add inner classes defining action objects here...
  class FileAction extends AbstractAction {    
    // Constructor
    FileAction(String name) {
      super(name);
      String iconFileName = "Images/" + name + ".gif";
      if(new File(iconFileName).exists())
        putValue(SMALL_ICON, new ImageIcon(iconFileName));
    }

   // Constructor
    FileAction(String name, KeyStroke keystroke) {
      this(name);
      if(keystroke != null)
        putValue(ACCELERATOR_KEY, keystroke);
    }

    // Event handler
    public void actionPerformed(ActionEvent e) {
      // We will add action code here eventually...
    }
  }

  class TypeAction extends AbstractAction {    
    TypeAction(String name, int typeID) {
      super(name);
      this.typeID = typeID;
      String iconFileName = "Images/" + name + ".gif";
      if(new File(iconFileName).exists())
        putValue(SMALL_ICON, new ImageIcon(iconFileName));
    }
    
    public void actionPerformed(ActionEvent e) {
      elementType = typeID;  
    }

    private int typeID;
  }

  // Handles color menu items
  class ColorAction  extends AbstractAction {
    public ColorAction(String name, Color color) {
      super(name);
      this.color = color;
      String iconFileName = "Images/" + name + ".gif";
      if(new File(iconFileName).exists())
        putValue(SMALL_ICON, new ImageIcon(iconFileName));
    }

    public void actionPerformed(ActionEvent e) {
      elementColor = color;
      // This is temporary - just to show it works
      getContentPane().setBackground(color);
    }

    private Color color;
  }

  private JMenuItem addMenuItem(JMenu menu, Action action) {
    JMenuItem item = menu.add(action);                  // Add the menu item

    KeyStroke keystroke = (KeyStroke)action.getValue(action.ACCELERATOR_KEY);
    if(keystroke != null)
      item.setAccelerator(keystroke);
      
    // remove this comments to disable icons
    // item.setIcon(null);                                 // Remove the icon
    return item;                                        // Return the menu item
  }

  // We will add action objects as members here...

  // Element color actions
  private ColorAction redAction, yellowAction, greenAction, blueAction;

  // Element type actions
  private TypeAction lineAction, rectangleAction, circleAction, curveAction;

  // File actions
  private FileAction newAction, openAction, closeAction, saveAction, saveAsAction, printAction;

  private JMenuBar menuBar = new JMenuBar();     // Window menu bar

  private Color elementColor = DEFAULT_ELEMENT_COLOR;   // Current element color
  private int elementType = DEFAULT_ELEMENT_TYPE;       // Current element type

  private JToolBar toolBar = new JToolBar();      // Window toolbar
}