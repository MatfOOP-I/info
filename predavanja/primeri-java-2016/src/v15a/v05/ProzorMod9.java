package v15a.v05;

 import javax.swing.*;
 import java.awt.*;    

 public class ProzorMod9{

     static JFrame nekiProzor = new JFrame("Ovo je naslov prozora");

     private static JRadioButtonMenuItem linija, prav, kriva, krug;
     private static JCheckBoxMenuItem disketa, fles, modem;
     
     private static JMenu dat = new JMenu("File");
     private static JMenu el = new JMenu("Elemeti");
     private static JMenu op = new JMenu("Oprema");
     
     public static void main(String[] args) {

        Toolkit alat = nekiProzor.getToolkit();      
        Dimension prozorVel = alat.getScreenSize();  

 
        nekiProzor.setBounds(prozorVel.width/4, prozorVel.height/4,  
                             prozorVel.width/2, prozorVel.height/2); 
   
    
        JMenuBar  meniLinija = new JMenuBar();
        nekiProzor.setJMenuBar(meniLinija);

        meniLinija.add(dat);
        ProzorMod9.dodajDat();

        meniLinija.add(el);
        ProzorMod9.dodajEl();
        
        meniLinija.add(op);
        ProzorMod9.dodajOp();
               
        nekiProzor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nekiProzor.setVisible(true);
     }

    static void dodajDat(){

        JMenuItem novi = dat.add("New");       
        JMenuItem otvori = new JMenuItem("Open");
        dat.add(otvori);
        dat.addSeparator();
        JMenuItem stampa = dat.add("Print");

    }
   
    static void dodajEl(){

        el.add( linija = new JRadioButtonMenuItem("Linija", true));
        el.add( prav = new JRadioButtonMenuItem("Pravougaonik", false));
        el.add( kriva = new JRadioButtonMenuItem("Kriva", false));
        el.add( krug = new JRadioButtonMenuItem("Krug", false));

        ButtonGroup nova = new ButtonGroup();
        nova.add(linija);
        nova.add(prav);
        nova.add(kriva);
        nova.add(krug);
   }

    static void dodajOp(){

        op.add( disketa = new JCheckBoxMenuItem("Disketa", true));
        op.add( fles = new JCheckBoxMenuItem("USB", false));
        op.addSeparator();
        op.add( modem = new JCheckBoxMenuItem("Modem", true));
    }
 }  
 
 
  
 

  
