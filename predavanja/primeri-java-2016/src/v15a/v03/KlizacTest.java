package v15a.v03;
import java.awt.*;

public class KlizacTest extends java.applet.Applet {
  Label l;

  public void init() {
    setLayout(new GridLayout(1,2));
    l = new Label("0", Label.CENTER);
    add(l);
    add(new Scrollbar(Scrollbar.HORIZONTAL,0,0,1,100));
  }

/*  public Insets insets() {
    return new Insets(15,15,15,15);
  }
*/
  public boolean handleEvent(Event evt) {
    if (evt.target instanceof Scrollbar) {
      int v = ((Scrollbar)evt.target).getValue();
      l.setText(String.valueOf(v));
      repaint();
      return true;
    } else return false;
  }

}

