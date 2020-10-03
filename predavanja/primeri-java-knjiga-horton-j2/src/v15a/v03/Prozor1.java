package v15a.v03;

 import javax.swing.*;
 import java.awt.*;

 public class Prozor1{

    static JFrame nekiProzor = new JFrame("Ovo je naslov prozora");


     public static void main(String[] args) {
        nekiProzor.setBounds(50,50, 200,200); // Pocetak i velicina
        nekiProzor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        nekiProzor.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        nekiProzor.getContentPane().setBackground(Color.pink);

        nekiProzor.setVisible(true);
     }
 }  
 
 
  
 

  
