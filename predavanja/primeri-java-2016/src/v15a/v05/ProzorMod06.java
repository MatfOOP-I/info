package v15a.v05;

 import javax.swing.*;
 import java.awt.*;     //NOVO - nece raditi bez ovoga!

 public class ProzorMod06{

    static JFrame nekiProzor = new JFrame("Ovo je naslov prozora");


     public static void main(String[] args) {

        Toolkit alat = nekiProzor.getToolkit();      // NOVA LINIJA
        Dimension prozorVel = alat.getScreenSize();  // NOVO: Velicina ekrana

    //    nekiProzor.setBounds(50,50, 200,200); // Stara postavka
    //  Sledi nova postavka   
 
       nekiProzor.setBounds(prozorVel.width/4, prozorVel.height/4,  //Pozicija
                             prozorVel.width/2, prozorVel.height/2); //Velicina
   
   
    
        nekiProzor.getContentPane().add(new JLabel("Zdravo Pero!"));
        Container okno = nekiProzor.getContentPane();
        okno.add(new JButton("Evo dugmeta!"));
        okno.setLayout(new FlowLayout());

        JMenuBar  meniLinija = new JMenuBar();
        nekiProzor.setJMenuBar(meniLinija);
        JMenu dat = new JMenu("File");
        meniLinija.add(dat);
        JMenu edi = new JMenu("Edit");
        meniLinija.add(edi);
       
 
        JMenuItem novi = dat.add("New");
       
        JMenuItem otvori = new JMenuItem("Open");
        dat.add(otvori);

        dat.addSeparator();
 
        JMenuItem stampa = dat.add("Print");
       
        
        nekiProzor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nekiProzor.setVisible(true);
     }
 }  
 
 
  
 

  
