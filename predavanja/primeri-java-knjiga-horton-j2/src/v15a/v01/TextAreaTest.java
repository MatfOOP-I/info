package v15a.v01;
import java.awt.*;

public class TextAreaTest extends java.applet.Applet {

  public void init() {
   /*  String str = "Ovo je tekst po redovima \n" +
     "On sadzi nebitan tekst, ali demonstrira\n" +
     "kako se operise sa tekstom. \n" +
     "TekstArea ne izaziva akcije. \n" +
     "Evo kako to izgleda.\n" +
     " ";
     //   */

     add(new TextArea("Mika",10,50));
  } 
}

