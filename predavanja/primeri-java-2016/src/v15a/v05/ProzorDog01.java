package v15a.v05;

 import javax.swing.*;
 import java.awt.*;    
 import java.awt.event.*; 

 public class ProzorDog01{

  public  static JFrame nekiProzor = new JFrame("Vazna aplikacija");


     public static void main(String[] args) {

        Toolkit alat = nekiProzor.getToolkit();    
        Dimension prozorVel = alat.getScreenSize();  
 
 
       nekiProzor.setBounds(prozorVel.width/4, prozorVel.height/4,  //Pozicija
                             prozorVel.width/2, prozorVel.height/2); //Velicina
   
   
    
      
        Container okno = nekiProzor.getContentPane();
       
        okno.setLayout(new FlowLayout());
 
    okno.add(new Label("Koju boju zelite?"));
    ButtonGroup rg = new ButtonGroup();
    JRadioButton r;
 
    
    Boje b = new Boje();

    rg.add( r=new JRadioButton("crvena"));
    okno.add(r);
    r.addItemListener(b);

    rg.add( r=new JRadioButton("zuta"));
    okno.add(r);
    r.addItemListener(b);
    
    
    rg.add(r = new JRadioButton("plava"));
    r.addItemListener(b);
    okno.add(r);
    
 
        nekiProzor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nekiProzor.setVisible(true);
     }
 }  
 
    
class Boje implements ItemListener  {

  public String boja = "plava";
  String naziv;
  
 public void itemStateChanged(ItemEvent ie) {
  
    if (ie.getStateChange() == ItemEvent.SELECTED)
    {  
       naziv = (String) ie.getItem();
       if(naziv=="crvena") ProzorDog01.nekiProzor.getContentPane().setBackground(Color.pink);
       else if(naziv=="plava") boja="plava?";
       else if(naziv=="zuta") boja= "zuta";
      
    }
  }


}
 

  
