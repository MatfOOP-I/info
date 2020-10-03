package v15a.v04;

 import javax.swing.*;
 import java.awt.*;     //NOVO - nece raditi bez ovoga!

 public class ProzorMod7
 {

    static JFrame nekiProzor = new JFrame("Ovo je naslov prozora");

     static JRadioButtonMenuItem linija, prav, kriva, krug;

     public static void main(String[] args) 
     {

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
        JMenu el = new JMenu("Elemeti");
        meniLinija.add(el);
       
 
        JMenuItem novi = dat.add("New");
       
        JMenuItem otvori = new JMenuItem("Open");
        dat.add(otvori);

        dat.addSeparator();
 
        JMenuItem stampa = dat.add("Print");

// Sledi dodavanje menija u obliku radio-dugmadi

        nekiProzor.add( linija = new JRadioButtonMenuItem("Line", true));
        el.add( prav = new JRadioButtonMenuItem("Rectangle", false));
        el.add( kriva = new JRadioButtonMenuItem("Curve", false));
        el.add( krug = new JRadioButtonMenuItem("Circle", false));

        ButtonGroup nova = new ButtonGroup();
        nova.add(linija);
        nova.add(prav);
        nova.add(kriva);
        nova.add(krug);
      
    
        


        
        nekiProzor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nekiProzor.setVisible(true);
     }
 }  
 
 
  
 

  
