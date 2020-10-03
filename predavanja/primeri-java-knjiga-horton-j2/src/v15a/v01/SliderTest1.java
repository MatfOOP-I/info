package v15a.v01;
import java.awt.*;

public class SliderTest1 extends java.applet.Applet {
  Label l,l1;
  int v;
  public void init() {
    setBackground(Color.yellow);
    setLayout(new GridLayout(2,1, 10,10));
    l1= new Label("v", Label.CENTER);
    add(l1);

    l = new Label("0", Label.CENTER);
    add(l);
    add(new Scrollbar(Scrollbar.HORIZONTAL,0,1,1,100));
 
  }

  public boolean handleEvent(Event evt) {
    if (evt.target instanceof Scrollbar) {
      v = ((Scrollbar)evt.target).getValue();
      l.setText(String.valueOf(v));
      repaint();
      return true;
    } else return false;
  }

  public void paint(Graphics g){
   g.setColor(Color.red);
   g.drawLine(200,400,200+2*v,400-2*v);
  }
}

