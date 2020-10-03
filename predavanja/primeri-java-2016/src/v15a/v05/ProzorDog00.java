package v15a.v05;

 import javax.swing.*;
 import java.awt.*;    
 import java.awt.event.*; 

 public class ProzorDog00{

    static JFrame nekiProzor = new JFrame("Vazna aplikacija");


     public static void main(String[] args) {

        Toolkit alat = nekiProzor.getToolkit();    
        Dimension prozorVel = alat.getScreenSize();  
 
 
       nekiProzor.setBounds(prozorVel.width/4, prozorVel.height/4,  //Pozicija
                             prozorVel.width/2, prozorVel.height/2); //Velicina
   
   
    
      
        Container okno = nekiProzor.getContentPane();
        JButton dugme = new JButton("Start");
        okno.add(dugme);
        JTextField polje = new JTextField(30);
        okno.add(polje);
        JTextField polje1 = new JTextField(30);
        okno.add(polje1);

        okno.setLayout(new FlowLayout());

        ObradaDugme od = new ObradaDugme(polje);
        dugme.addActionListener(od);

        ObradaPolja op = new ObradaPolja(polje1);
        polje.addActionListener(op);

        nekiProzor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nekiProzor.setVisible(true);
     }
 }  
 
    
class ObradaDugme implements ActionListener {

  JTextField p;

  public ObradaDugme( JTextField p) {
    this.p = p;
  }

  public void actionPerformed(ActionEvent ae) {
    String s = "Gde si stari prijatelju?";
    p.setText(s);

  }
}
 
    
class ObradaPolja implements ActionListener {

  JTextField iz;

  public ObradaPolja(JTextField iz) {
    this.iz= iz;
  }

  public void actionPerformed(ActionEvent dog) {
    String s = "Uvek na RAF-u!";
    iz.setText(s);

  }
} 
 

  
