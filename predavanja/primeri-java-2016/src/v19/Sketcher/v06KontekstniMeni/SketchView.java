package v19.Sketcher.v06KontekstniMeni;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;

import java.util.Observer;                  
import java.util.Observable;                  
import java.util.Iterator;

import java.awt.Graphics;
import java.awt.Graphics2D;                          
import java.awt.Point;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Component;

import java.awt.event.ActionEvent;    
import java.awt.event.ActionListener;    
import java.awt.event.MouseEvent;    

import java.awt.font.TextLayout;  

import javax.swing.event.MouseInputAdapter;    

class SketchView extends JComponent implements Observer, Constants, ActionListener {
  public SketchView(Sketcher theApp) {
    this.theApp = theApp;
    MouseHandler handler = new MouseHandler();        // create the mouse listener
    addMouseListener(handler);                        // Listen for button events
    addMouseMotionListener(handler);                  // Listen for motion events

    // Add the pop-up menu items
    moveItem = elementPopup.add("Move");
    deleteItem = elementPopup.add("Delete");
    rotateItem = elementPopup.add("Rotate");
    sendToBackItem = elementPopup.add("Send-to-back");

    // Add the menu item listeners
    moveItem.addActionListener(this);
    deleteItem.addActionListener(this);
    rotateItem.addActionListener(this);
    sendToBackItem.addActionListener(this);

  }

  public void actionPerformed(ActionEvent e ) {
    Object source = e.getSource();
    if(source == moveItem) {
      // Process a move...

    } else if(source == deleteItem) {
      if(highlightElement != null) {                    // If there's an element
        theApp.getModel().remove(highlightElement);     // then remove it
        highlightElement = null;                        // Remove the reference
      }

    } else if(source == rotateItem) {
      // Process a rotate

    } else if(source == sendToBackItem) {
      if(highlightElement != null) {
        theApp.getModel().remove(highlightElement);
        theApp.getModel().add(highlightElement);
        highlightElement.setHighlighted(false);
        highlightElement = null;
        repaint();
      }
    }
  }

  public void paint(Graphics g) {
    Graphics2D g2D = (Graphics2D)g;                 // Get a 2D device context
    Iterator elements = theApp.getModel().getIterator();
    while(elements.hasNext())                       // Go through the list
      ((Element)elements.next()).draw(g2D);         // Get the next element to draw 
                                                    // itself
  }

  public void update(Observable o, Object rectangle) {
    if(rectangle == null)
      repaint();
    else
      repaint((Rectangle)rectangle);
  }

  class MouseHandler extends MouseInputAdapter {
    public void mousePressed(MouseEvent e) {
      start = e.getPoint();                   // Save the cursor position in start
      if((button1Down = (e.getButton()==MouseEvent.BUTTON1)) &&
         (theApp.getWindow().getElementType() != TEXT)) {
        g2D = (Graphics2D)getGraphics();                 // Get graphics context
        g2D.setXORMode(getBackground());                 // Set XOR mode
        g2D.setPaint(theApp.getWindow().getElementColor());     // Set color
      }
    }

    public void mouseDragged(MouseEvent e) {
      last = e.getPoint();                               // Save cursor position

      if(button1Down && (theApp.getWindow().getElementType() != TEXT)) {
        if(tempElement == null) {                       // Is there an element?
          tempElement = createElement(start, last);     // No, so create one
        } else {
          tempElement.draw(g2D);                          // Yes - draw to erase it
          tempElement.modify(start, last);              // Now modify it
        }
        tempElement.draw(g2D);                          // and draw it      }
      }
    }

    public void mouseReleased(MouseEvent e) {
      if(e.isPopupTrigger()) {
        start = e.getPoint();
        if(highlightElement == null)
          theApp.getWindow().getPopup().show((Component)e.getSource(),
                                             start.x, start.y);
        else
          elementPopup.show((Component)e.getSource(), start.x, start.y);

        start = null;
      } else if((e.getButton()==MouseEvent.BUTTON1) && 
                (theApp.getWindow().getElementType() != TEXT)) {

        button1Down = false;                    // Reset the button 1 flag
        if(tempElement != null) {
          theApp.getModel().add(tempElement);   // Add element to the model
          tempElement = null;                   // No temporary now stored
        }
        if(g2D != null) {                       // If there's a graphics context
          g2D.dispose();                        // ...release the resource
          g2D = null;                           // Set field to null
        }
        start = last = null;                    // Remove the points
      }
    }

    private Element createElement(Point start, Point end) {
      switch(theApp.getWindow().getElementType()) {
        case LINE:
           return new Element.Line(start, end,
                                  theApp.getWindow().getElementColor());   
        case RECTANGLE:
           return new Element.Rectangle(start, end,
                                        theApp.getWindow().getElementColor());
        
        case CIRCLE:
           return new Element.Circle(start, end, 
                                     theApp.getWindow().getElementColor());

        case CURVE:
         return new Element.Curve(start, end,
                                  theApp.getWindow().getElementColor());
        default:
          //assert false;                     // We should never get to here
     }
      return null;
    }

    public void mouseClicked(MouseEvent e) {
      if((e.getButton()== MouseEvent.BUTTON1) && 
         (theApp.getWindow().getElementType() == TEXT)) {

        start = e.getPoint();              // Save cursor position - start of text
        String text = JOptionPane.showInputDialog(
                     (Component)e.getSource(),            // Used to get the frame
                     "Enter Text:",                       // The message
                     "Dialog for Text Element",           // Dialog title
                     JOptionPane.PLAIN_MESSAGE);          // No icon

        if(text != null && text.length()!=0)  {           // If we have text        
                                                         // create the element
          g2D = (Graphics2D)getGraphics();
          Font font = theApp.getWindow().getCurrentFont();
          tempElement = new Element.Text(
                       font,                                  // The font
                       text,                                  // The text
                       start,                                 // Position of the text
                       theApp.getWindow().getElementColor(),  // The text color
               new java.awt.font.TextLayout(text, font,       // The bounding rectangle
          g2D.getFontRenderContext()).getBounds().getBounds());

          if(tempElement != null) {                          // If we created one
            theApp.getModel().add(tempElement);              // add it to the model
            tempElement = null;                              // and reset the field
          }
          g2D.dispose();                                     // Release context resources
          g2D = null;
          start = null;
        }
      }
    }

    // Handle mouse moves
    public void mouseMoved(MouseEvent e) {
      Point currentCursor = e.getPoint();  // Get current cursor position
      Iterator elements = theApp.getModel().getIterator();
      Element element = null;                             // Stores an element

      while(elements.hasNext())  {                        // Go through the list
        element = (Element)elements.next();               // Get the next element
        if(element.getBounds().contains(currentCursor)) { // Under the cursor?
          if(element==highlightElement)            // If its already highlighted
            return;                                // we are done
          g2D = (Graphics2D)getGraphics();         // Get graphics context
          if(highlightElement!=null)   {           // If an element is highlighted
            highlightElement.setHighlighted(false);// un-highlight it and
            highlightElement.draw(g2D);            // draw it normal color
          }
          element.setHighlighted(true);           // Set highlight for new element
          highlightElement = element;             // Store new highlighted element
          element.draw(g2D);                      // Draw it highlighted 
          g2D.dispose();                      // Release graphic context resources
          g2D = null;

          return;
        }
      }

      // Here there is no element under the cursor so...
      if(highlightElement!=null)   {            // If an element is highlighted
        g2D = (Graphics2D)getGraphics();        // Get graphics context
        highlightElement.setHighlighted(false); // ...turn off highlighting
        highlightElement.draw(g2D);             // Redraw the element
        highlightElement = null;                // No element highlighted
        g2D.dispose();                        // Release graphic context resources
        g2D = null;
      }
    }

    private Point start;                     // Stores cursor position on press
    private Point last;                      // Stores cursor position on drag
    private Element tempElement;             // Stores a temporary element

    private boolean button1Down = false;          // Flag for button 1 state
    private Graphics2D g2D = null;                   // Temporary graphics context
  }

  private JPopupMenu elementPopup = new JPopupMenu("Element");
  private JMenuItem moveItem, deleteItem,rotateItem, sendToBackItem;

  private Sketcher theApp;           // The application object
  private Element highlightElement;            // Highlighted element
}
