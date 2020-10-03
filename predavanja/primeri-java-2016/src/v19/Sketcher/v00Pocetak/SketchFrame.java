// Frame for the Sketcher application
package v19.Sketcher.v00Pocetak;
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
  public SketchFrame(String title, Sketcher theApp) {
    setTitle(title);                             // Set the window title
    this.theApp = theApp;
    setJMenuBar(menuBar);                       // Add the menu bar to the window
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    JMenu fileMenu = new JMenu("File");          // Create File menu
    JMenu elementMenu = new JMenu("Elements");   // Create Elements menu
    fileMenu.setMnemonic('F');                   // Create shortcut
    elementMenu.setMnemonic('E');                // Create shortcut

    // Create the action items for the file menu
    newAction = new FileAction("New", KeyStroke.getKeyStroke('N',Event.CTRL_MASK ), "Create new sketch");
    openAction = new FileAction("Open", KeyStroke.getKeyStroke('O',Event.CTRL_MASK), "Open existing sketch");
    closeAction = new FileAction("Close", "Close sketch");
    saveAction = new FileAction("Save", KeyStroke.getKeyStroke('S',Event.CTRL_MASK), "Save sketch");
    saveAsAction = new FileAction("Save As...", "Save as new file");
    printAction = new FileAction("Print", KeyStroke.getKeyStroke('P',Event.CTRL_MASK), "Print sketch");

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
    addMenuItem(elementMenu, lineAction = new TypeAction("Line", LINE, "Draw lines")); 
    addMenuItem(elementMenu, rectangleAction = new TypeAction("Rectangle",RECTANGLE, "Draw rectangles"));
    addMenuItem(elementMenu, circleAction = new TypeAction("Circle", CIRCLE, "Draw circles"));
    addMenuItem(elementMenu, curveAction = new TypeAction("Curve", CURVE, "Draw curves"));

    fileMenu.addSeparator();                      // Add separator

    JMenu colorMenu = new JMenu("Color");         // Color sub-menu
    elementMenu.add(colorMenu);                   // Add the sub-menu

    addMenuItem(colorMenu, redAction = new ColorAction("Red", Color.RED, "Draw in red"));
    addMenuItem(colorMenu, yellowAction = new ColorAction("Yellow", Color.YELLOW, "Draw in yellow"));
    addMenuItem(colorMenu, greenAction = new ColorAction("Green", Color.GREEN, "Draw in green"));
    addMenuItem(colorMenu, blueAction = new ColorAction("Blue", Color.BLUE, "Draw in blue"));
    
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
    
    // Disable actions
    saveAction.setEnabled(false);
    closeAction.setEnabled(false);
    printAction.setEnabled(false);
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

    FileAction(String name, String tooltip) {
      this(name);                                // Call the other constructor
      if(tooltip != null)                        // If there is tooltip text
        putValue(SHORT_DESCRIPTION, tooltip);    // ...squirrel it away
    }

    FileAction(String name, KeyStroke keystroke, String tooltip) {
      this(name, keystroke);                         // Call the other constructor
      if(tooltip != null)                             // If there is tooltip text
        putValue(SHORT_DESCRIPTION, tooltip);         // ...squirrel it away
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
    
    TypeAction(String name, int typeID, String tooltip) {
      this(name, typeID);
      if(tooltip != null)                               // If there is a tooltip
        putValue(SHORT_DESCRIPTION, tooltip);           // ...squirrel it away
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
    
    public ColorAction(String name, Color color, String tooltip) {
      this(name, color);
       if(tooltip != null)                               // If there is a tooltip
         putValue(SHORT_DESCRIPTION, tooltip);           // ...squirrel it away
    }
    
    public void actionPerformed(ActionEvent e) {
      elementColor = color;
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

    public Color getElementColor() { 
      return elementColor; 
    }

  public int getElementType() { 
    return elementType; 
  }

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
  private Sketcher theApp;
}