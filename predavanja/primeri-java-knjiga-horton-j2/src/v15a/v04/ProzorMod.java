package v15a.v04;

 import javax.swing.*;
 import java.awt.*;     //NOVO - nece raditi bez ovoga!

 public class ProzorMod{

    static JFrame nekiProzor = new JFrame("Ovo je naslov prozora");


     public static void main(String[] args) {

        Toolkit alat = nekiProzor.getToolkit();      // NOVA LINIJA
        Dimension prozorVel = alat.getScreenSize();  // NOVO: Velicina ekrana

    //    nekiProzor.setBounds(50,50, 200,200); // Stara postavka
    //  Sledi nova postavka   
 
       nekiProzor.setBounds(prozorVel.width/4, prozorVel.height/4,  //Pozicija
                             prozorVel.width/2, prozorVel.height/2); //Velicina



        nekiProzor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nekiProzor.setVisible(true);
     }
 }  
 
 
  
 

  
