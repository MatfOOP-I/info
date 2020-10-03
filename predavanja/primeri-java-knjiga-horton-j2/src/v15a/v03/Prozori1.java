package v15a.v03;

import java.awt.*;
public class Prozori1 extends java.applet.Applet{
 Frame prozor;

 public void init(){
   add(new Button("Otvori prozor"));
   add(new Button("Zatvori prozor"));

   prozor = new  MojProzor("Probni prozor");
   prozor.resize(150,150);
   prozor.setLocation(400,400);
   prozor.show();
 }

 public boolean action(Event dog, Object arg){
     if(dog.target instanceof Button) {
       String labela = (String) arg;
       if(labela.equals("Otvori prozor")){
         if (!prozor.isShowing()) prozor.show();
       }
       else if(labela == "Zatvori prozor"){
          if (prozor.isShowing())
               prozor.hide();
     }
     return true;
    }
     else return false;
   }
 }

 class MojProzor extends Frame{
   Label l;
   MojProzor (String naslov){
    super(naslov);
    setLayout(new GridLayout(1,1));
    l = new Label("Glavni prozor");
    add(l);
 }
}
