package v15a.v05;

 import javax.swing.*;
 import java.awt.*;    

 public class ProzorMod12{

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

        
        JToolBar alatLin = new JToolBar();
        JButton adugme= new JButton("Otvori");
        alatLin.add(adugme);
        adugme.setBorder(BorderFactory.createRaisedBevelBorder());
        nekiProzor.getContentPane().add(alatLin, BorderLayout.NORTH);

        meniLinija.add(dat);
        ProzorMod12.dodajDat();
        dat.setMnemonic('F');
    
        

        meniLinija.add(el);
        ProzorMod12.dodajEl();
        el.setMnemonic('E');
        
        meniLinija.add(op);
        ProzorMod12.dodajOp();
        op.setMnemonic('O');
               
        nekiProzor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nekiProzor.setVisible(true);
     }

    static void dodajDat(){

        JMenuItem novi = dat.add("New");
        novi.setAccelerator(KeyStroke.getKeyStroke ('N', Event.CTRL_MASK));
       
        JMenuItem otvori = new JMenuItem("Open");
        dat.add(otvori);
        dat.addSeparator();
        JMenuItem stampa = dat.add("Print");
        stampa.setAccelerator(KeyStroke.getKeyStroke ('P', Event.CTRL_MASK));

    }
   
    static void dodajEl(){

        el.add( linija = new JRadioButtonMenuItem("Linija", true));
        linija.setAccelerator(KeyStroke.getKeyStroke ('L', Event.CTRL_MASK));

        el.add( prav = new JRadioButtonMenuItem("Pravougaonik", false));
        prav.setAccelerator(KeyStroke.getKeyStroke ('P', Event.CTRL_MASK));

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
        fles.setAccelerator(KeyStroke.getKeyStroke ('U', Event.CTRL_MASK));
        op.addSeparator();
        op.add( modem = new JCheckBoxMenuItem("Modem", true));
    }
 }  
 
 
  
 

  
