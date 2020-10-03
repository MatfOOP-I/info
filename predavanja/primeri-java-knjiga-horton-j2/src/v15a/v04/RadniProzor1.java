package v15a.v04;

 import javax.swing.*;
 import java.awt.*;

 public class RadniProzor1 extends JFrame {

     public RadniProzor1() {

         super("Prva aplikacija");

         JButton prvo = new JButton("Prvo dugme");
         JLabel lab = new JLabel("Ovo je prvo dugme");
         JPanel pan = new JPanel();
        
         pan.add(prvo);
         pan.add(lab);
         setContentPane(pan);
     }

     public static void main(String[] args) {
         
         JFrame okvir = new RadniProzor1();
         okvir.setBounds(100,50, 200,200);
         okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         okvir.setVisible(true);

// definisanje boje pozadine i promena oblika kursora

         okvir.getContentPane().setBackground(Color.pink);
         okvir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       
     }
 }  
 
 
  
 

  
