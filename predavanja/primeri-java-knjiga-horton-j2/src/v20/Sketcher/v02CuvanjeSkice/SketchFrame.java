// Frame for the Sketcher application
package v20.Sketcher.v02CuvanjeSkice;
import javax.swing.*;

import java.awt.Color;
import java.awt.Event;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Font;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.*;

import java.util.Observer;
import java.util.Observable;

public class SketchFrame extends JFrame
                         implements Constants, ActionListener, Observer {
  // Method called by SketchModel object when it changes
  public void update(Observable o, Object obj) {
    sketchChanged = true;
  }

  // Constructor
  public SketchFrame(String title, Sketcher theApp) {
    //setTitle(title);                             // Set the window title
    this.theApp = theApp;
    setJMenuBar(menuBar);                       // Add the menu bar to the window
    setDefaultCloseOperation(EXIT_ON_CLOSE);      // Default is exit the application

    JMenu fileMenu = new JMenu("File");          // Create File menu
    JMenu elementMenu = new JMenu("Elements");   // Create Elements menu
    JMenu optionsMenu = new JMenu("Options");              // Create options menu
    JMenu helpMenu = new JMenu("Help");           // Create Help menu

    fileMenu.setMnemonic('F');                   // Create shortcut
    elementMenu.setMnemonic('E');                // Create shortcut
    optionsMenu.setMnemonic('O');                          // Create shortcut
    helpMenu.setMnemonic('H');                    // Create shortcut 

    // Create the action items for the file menu
    newAction = new FileAction("New", KeyStroke.getKeyStroke('N',Event.CTRL_MASK ), "Create new sketch");
    openAction = new FileAction("Open", KeyStroke.getKeyStroke('O',Event.CTRL_MASK), "Open existing sketch");
    saveAction = new FileAction("Save", KeyStroke.getKeyStroke('S',Event.CTRL_MASK), "Save sketch");
    saveAsAction = new FileAction("Save As...", "Save as new file");
    printAction = new FileAction("Print", KeyStroke.getKeyStroke('P',Event.CTRL_MASK), "Print sketch");

    addMenuItem(fileMenu, newAction);
    addMenuItem(fileMenu, openAction);
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
    addMenuItem(elementMenu, textAction = new TypeAction("Text", TEXT, "Draw text"));

    elementMenu.addSeparator();                      // Add separator

    JMenu colorMenu = new JMenu("Color");         // Color sub-menu
    elementMenu.add(colorMenu);                   // Add the sub-menu

    addMenuItem(colorMenu, redAction = new ColorAction("Red", Color.RED, "Draw in red"));
    addMenuItem(colorMenu, yellowAction = new ColorAction("Yellow", Color.YELLOW, "Draw in yellow"));
    addMenuItem(colorMenu, greenAction = new ColorAction("Green", Color.GREEN, "Draw in green"));
    addMenuItem(colorMenu, blueAction = new ColorAction("Blue", Color.BLUE, "Draw in blue"));
    
    menuBar.add(fileMenu);                       // Add the file menu
    menuBar.add(elementMenu);                    // Add the element menu 
    menuBar.add(optionsMenu);                     // Add the options menu
    
    toolBar.setFloatable(false);    // Inhibit toolbar floating
    getContentPane().add(toolBar, BorderLayout.NORTH);

    // Add file buttons
    toolBar.addSeparator();                                 // Space at the start
    addToolBarButton(newAction);
    addToolBarButton(openAction);
    addToolBarButton(saveAction);
    addToolBarButton(printAction);
    
    fileMenu.addSeparator();                                // Add separator
    addMenuItem(fileMenu, closeAction = new FileAction("Exit",
                KeyStroke.getKeyStroke('X',Event.CTRL_MASK ),
                "Exit Sketcher"));

    // Add element type buttons
    toolBar.addSeparator();
    addToolBarButton(lineAction);
    addToolBarButton(rectangleAction);
    addToolBarButton(circleAction);
    addToolBarButton(curveAction);
    addToolBarButton(textAction);

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
    //saveAction.setEnabled(false);
    //closeAction.setEnabled(false);
    //printAction.setEnabled(false);

    getContentPane().add(statusBar, BorderLayout.SOUTH);        // Add the statusbar

    // Add the About item to the Help menu
    aboutItem = new JMenuItem("About");           // Create the item
    aboutItem.addActionListener(this);            // Listener is the frame
    helpMenu.add(aboutItem);                      // Add item to menu
    menuBar.add(helpMenu);                        // Add the Help menu

    // Add the font choice item to the options menu
    fontItem = new JMenuItem("Choose font...");
    fontItem.addActionListener(this);
    optionsMenu.add(fontItem);

    fontDlg = new FontDialog(this);
    
    // Create pop-up menu
    popup.add(lineAction);
    popup.add(rectangleAction);
    popup.add(circleAction);
    popup.add(curveAction);
    popup.add(textAction);

    popup.addSeparator();
    popup.add(redAction);
    popup.add(yellowAction);
    popup.add(greenAction);
    popup.add(blueAction);

    customColorItem = popup.add("Custom Color...");    // Add the item
    customColorItem.addActionListener(this);           // and add its listener
    
    frameTitle = title + ": ";
    setTitle(frameTitle + filename);

    if(!DEFAULT_DIRECTORY.exists())
      if(!DEFAULT_DIRECTORY.mkdirs())
        JOptionPane.showMessageDialog(this,
                                      "Error creating default directory",
                                      "Directory Creation Error",
                                      JOptionPane.ERROR_MESSAGE);

    files = new JFileChooser(DEFAULT_DIRECTORY);
  }

  // Method for opening file
  public void openSketch(File inFile) {
    try {
      ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(
                                       new FileInputStream(inFile)));
      theApp.insertModel((SketchModel)in.readObject());
      in.close();
      modelFile = inFile;
      filename = modelFile.getName();            // Update the file name
      setTitle(frameTitle+modelFile.getPath());  // Change the window title
      sketchChanged = false;                     // Status is unchanged
    } catch(Exception e) {
      System.out.println(e);
      JOptionPane.showMessageDialog(SketchFrame.this,
                                    "Error reading a sketch file.",
                                    "File Input Error",
                                    JOptionPane.ERROR_MESSAGE);
    }
  }

  // Prompt for save operation when necessary
  public void checkForSave() {
    if(sketchChanged)
      if(JOptionPane.YES_OPTION ==
            JOptionPane.showConfirmDialog(SketchFrame.this,
                             "Current file has changed. Save current file?",
                             "Confirm Save Current File",
                             JOptionPane.YES_NO_OPTION,
                             JOptionPane.WARNING_MESSAGE))
        saveOperation();
  }

  // Write a sketch to outFile
  private void saveSketch(File outFile) {
    try {
      ObjectOutputStream out =  new ObjectOutputStream(
                                new BufferedOutputStream(
                                new FileOutputStream(outFile)));
      out.writeObject(theApp.getModel());        // Write the sketch to the
                                                 // stream
      out.close();                               // Flush & close it
    } catch(IOException e) {
      System.err.println(e);
      JOptionPane.showMessageDialog(SketchFrame.this,
                                    "Error writing a sketch file.",
                                    "File Output Error",
                                    JOptionPane.ERROR_MESSAGE);
      return;                                    // Serious error - return
    }
    if(outFile != modelFile) {             // If we are saving to a new file
                                           // we must update the window
      modelFile = outFile;                       // Save file reference
      filename = modelFile.getName();            // Update the file name
      setTitle(frameTitle + modelFile.getPath());  // Change the window
                                                   // title
    }
    sketchChanged = false;                       // Set as unchanged
  }

  // Save the sketch if it is necessary
  private void saveOperation() {
    if(!sketchChanged)
      return;

    File file = modelFile;
    if(file == null) {
      file = showDialog("Save Sketch",
                        "Save",
                        "Save the sketch",
                        's',
                        new File(files.getCurrentDirectory(), filename));
      if(file == null || (file.exists() &&                      // Check for existence
        JOptionPane.NO_OPTION ==          // Overwrite warning
            JOptionPane.showConfirmDialog(SketchFrame.this,
                                          file.getName()+" exists. Overwrite?",
                                          "Confirm Save As",
                                          JOptionPane.YES_NO_OPTION,
                                          JOptionPane.WARNING_MESSAGE)))
                                          return;                            // No selected file
    }
    saveSketch(file);    
  }

  // Display a custom file save dialog
  private File showDialog(String dialogTitle,
                          String approveButtonText,
                          String approveButtonTooltip,
                          char approveButtonMnemonic,
                          File file) {                // Current file - if any

    files.setDialogTitle(dialogTitle);
    files.setApproveButtonText(approveButtonText);
    files.setApproveButtonToolTipText(approveButtonTooltip);
    files.setApproveButtonMnemonic(approveButtonMnemonic);
    files.setFileSelectionMode(files.FILES_ONLY);
    files.rescanCurrentDirectory();
    files.setSelectedFile(file);

    ExtensionFilter sketchFilter = new ExtensionFilter(".ske",
                                                    "Sketch files (*.ske)");
    files.addChoosableFileFilter(sketchFilter);            // Add the filter
    files.setFileFilter(sketchFilter);                     // and select it

    int result = files.showDialog(SketchFrame.this, null);  // Show the dialog
    return (result == files.APPROVE_OPTION) ? files.getSelectedFile() : null;
  }

  // Retrieve the pop-up menu
  public JPopupMenu getPopup() {  
    return popup;  
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
      String name = (String)getValue(NAME);
      if(name.equals(saveAction.getValue(NAME))) {
        saveOperation();
      } else if(name.equals(saveAsAction.getValue(NAME))) {
       File file = showDialog("Save Sketch As",
                              "Save",
                              "Save the sketch",
                              's',
                              modelFile == null ? new File(
                                                files.getCurrentDirectory(),
                                                filename):modelFile);
       if(file != null) {
          if(file.exists() && !file.equals(modelFile))
           if(JOptionPane.NO_OPTION ==                  // Overwrite warning
              JOptionPane.showConfirmDialog(SketchFrame.this,
                                       file.getName()+" exists. Overwrite?",
                                       "Confirm Save As",
                                       JOptionPane.YES_NO_OPTION,
                                       JOptionPane.WARNING_MESSAGE))
            return;                                     // No file selected
          saveSketch(file);
        }
        return;
      } else if(name.equals(openAction.getValue(NAME))) {
        checkForSave();

        // Now open a sketch file
        File file = showDialog(
                           "Open Sketch File",        // Dialog window title
                           "Open",                    // button lable
                           "Read a sketch from file", // Button tooltip text
                           'o',                       // Shortcut character
                           null);                     // No file selected
        if(file != null)                           // If a file was selected
          openSketch(file);                        // then read it
      } else if(name.equals(newAction.getValue(NAME))) {
        checkForSave();
        theApp.insertModel(new SketchModel());    // Insert new empty sketch
        modelFile = null;                         // No file for it
        filename = DEFAULT_FILENAME;              // Default name
        setTitle(frameTitle + files.getCurrentDirectory() + 
                 "\\" + filename);
        sketchChanged = false;                    // Not changed yet
      } else if(name.equals(closeAction.getValue(NAME))) {
        checkForSave();
        System.exit(0);
      } if(name.equals(printAction.getValue(NAME))) {
        // code to deal with print action
      }
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
      statusBar.setTypePane(typeID);
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
      statusBar.setColorPane(color);
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

  // Handle About menu action events
  public void actionPerformed(ActionEvent e)  {
    if(e.getSource() == aboutItem) {
      // Create about dialog with the menu item as parent
      JOptionPane.showMessageDialog(this,                          // Parent
                            "Sketcher Copyright Ivor Horton 2001", // Message
                            "About Sketcher",                      // Title
                            JOptionPane.INFORMATION_MESSAGE);      // Message type

    } else if(e.getSource() == fontItem) {      // Set the dialog window position
      Rectangle bounds = getBounds();
      fontDlg.setLocation(bounds.x + bounds.width/3, bounds.y + bounds.height/3);
      fontDlg.setVisible(true);            // Show the dialog

    } else if(e.getSource() == customColorItem) {
      Color color = JColorChooser.showDialog(this, "Select Custom Color",
                                                           elementColor);
      if(color != null) {
        elementColor = color;
        statusBar.setColorPane(color);
      }
    }
  }

    // Class defining a general purpose message box
  class AboutDialog extends JDialog implements ActionListener   {
    public AboutDialog(Frame parent, String title, String message)  {
      super(parent, title, true);
      // If there was a parent, set dialog position inside
      if(parent != null) {
        Dimension parentSize = parent.getSize();     // Parent size
        Point p = parent.getLocation();              // Parent position
        setLocation(p.x+parentSize.width/4,p.y+parentSize.height/4); 
      }

      // Create the message pane
      JPanel messagePane = new JPanel();
      messagePane.add(new JLabel(message));        
      getContentPane().add(messagePane);

      // Create the button pane
      JPanel buttonPane = new JPanel();
      JButton button = new JButton("OK");        // Create OK button
      buttonPane.add(button);                    // add to content pane
      button.addActionListener(this);
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      pack();                                    // Size window for components
      setVisible(true);
    }

    // OK button action
    public void actionPerformed(ActionEvent e)  {
      setVisible(false);                         // Set dialog invisible
      dispose();                                 // Release the dialog resources
    }
  }

  public Font getCurrentFont() {  
    return font;  
  }

  public void setCurrentFont(Font font) {  
    this.font = font;  
  }

  private JPopupMenu popup = new JPopupMenu("General");       // Window pop-up

  // Element color actions
  private ColorAction redAction, yellowAction, greenAction, blueAction;

  // Element type actions
  private TypeAction lineAction, rectangleAction, circleAction, curveAction, textAction;

  // File actions
  private FileAction newAction, openAction, closeAction, saveAction, saveAsAction, printAction;

  private JMenuBar menuBar = new JMenuBar();     // Window menu bar

  private Color elementColor = DEFAULT_ELEMENT_COLOR;   // Current element color
  private int elementType = DEFAULT_ELEMENT_TYPE;       // Current element type

  private JToolBar toolBar = new JToolBar();      // Window toolbar
  private Sketcher theApp;

  private StatusBar statusBar = new StatusBar();    // Window status bar

  // Sundry menu items
  private JMenuItem aboutItem, fontItem;
  private Font font = DEFAULT_FONT;                      // Current font

  private FontDialog fontDlg;                      // The font dialog
  private String frameTitle;                  // Frame title
  private String filename = DEFAULT_FILENAME; // Current model file name
  private File modelFile;                     // File for the current sketch
  private boolean sketchChanged = false;         // Model changed flag
  private JFileChooser files;                   // File chooser dialog

  private JMenuItem customColorItem;
}