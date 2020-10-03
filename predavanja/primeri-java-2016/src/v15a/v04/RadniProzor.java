package v15a.v04;

 import javax.swing.*;


 public class RadniProzor extends JFrame {

     public RadniProzor() {

         super("Prva aplikacija");

         JButton prvo = new JButton("Prvo dugme");
         JLabel lab = new JLabel("Ovo je prvo dugme");
         JPanel pan = new JPanel();
         pan.add(prvo);
         pan.add(lab);
         setContentPane(pan);
     }

     public static void main(String[] args) {
         JFrame okvir = new RadniProzor();
         okvir.setBounds(100,50, 200,200);
         okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         okvir.setVisible(true);
     }
 }  
 
 
  
 

  
