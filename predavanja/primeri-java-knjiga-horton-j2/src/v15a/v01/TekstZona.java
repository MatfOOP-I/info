package v15a.v01;
import java.awt.*;

public class TekstZona extends java.applet.Applet {

  public void init() {
    add(new TextArea());
    add(new TextArea(5,5));
    add(new TextArea("Pera"));

    String str = "Ovo je tekst po redovima \n" +
     "On sadzi nebitan tekst, ali demonstrira\n" +
     "kako se operise sa tekstom. \n" +
     "TekstArea ne izaziva akcije. \n" +
     "Evo kako to izgleda.\n" +
     " ";
    

     add(new TextArea(str,10,50));
  } 
}

