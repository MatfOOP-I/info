package v16;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.Spring;

import java.awt.Container; 
import java.awt.Dimension; 
import java.awt.Toolkit;

public class TrySpringLayout
{
  // The window object
  static JFrame aWindow = new JFrame("This is a Spring Layout"); 

  public static void main(String[] args)
  {
    Toolkit theKit = aWindow.getToolkit();         // Get the window toolkit
    Dimension wndSize = theKit.getScreenSize();    // Get screen size
 
    // Set the position to screen center & size to half screen size
    aWindow.setBounds(wndSize.width/4, wndSize.height/4,   // Position
                      wndSize.width/2, wndSize.height/2);  // Size
    aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    SpringLayout layout = new SpringLayout();      // Create a layout manager
    Container content = aWindow.getContentPane();  // Get the content pane
    content.setLayout(layout);                     // Set the container layout mgr

    JButton[] buttons = new JButton[6];            // Array to store buttons
    for(int i = 0; i < buttons.length; i++)
    {
      buttons[i] = new JButton("Press " + (i+1));
      content.add(buttons[i]);      // Add a Button to content pane
    } // end for

    Spring xSpring = Spring.constant(5,15,25);    // x constraint for 1st button
    Spring ySpring = Spring.constant(10,30, 50);  // y constraint for first button
    Spring wSpring = Spring.constant(30,80,130);  // Width constraint for buttons

    // Connect x,y for first button to left and top of container by springs
    SpringLayout.Constraints buttonConstr = layout.getConstraints(buttons[0]);
    buttonConstr.setX(xSpring); 
    buttonConstr.setY(ySpring); 

    // Set width and height of buttons and hook buttons together
    for(int i = 0 ; i< buttons.length ; i++)
    {
      buttonConstr = layout.getConstraints(buttons[i]);
      buttonConstr.setHeight(ySpring);      // Set the button height constraint 
      buttonConstr.setWidth(wSpring);       // and its width constraint 

      if(i>0)                      // For buttons after the first
      {                            // tie W and N edges to E and N of predecessor
        layout.putConstraint(SpringLayout.WEST,buttons[i],
                             xSpring,SpringLayout.EAST, buttons[i-1]);    
        layout.putConstraint(SpringLayout.NORTH,buttons[i],
                             ySpring,SpringLayout.SOUTH, buttons[i-1]);
      } // end if
    } // end for
    
    // relating the size of the window to the springs
    SpringLayout.Constraints constr = layout.getConstraints(content);
    constr.setConstraint(SpringLayout.EAST,
                         Spring.sum(buttonConstr.getConstraint(SpringLayout.EAST),
                                    Spring.constant(15)));
    constr.setConstraint(SpringLayout.SOUTH,
                         Spring.sum(buttonConstr.getConstraint(SpringLayout.SOUTH),
                                    Spring.constant(10)));
    aWindow.pack();

    
    aWindow.setVisible(true);                      // Display the window
  }
}
