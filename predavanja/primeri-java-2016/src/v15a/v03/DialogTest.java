package v15a.v03;
import java.applet.*;
import java.awt.*; 

public class DialogTest extends Applet {

  public void init() {
    
    Dialog mojDialog = new Dialog(new Frame(), false);
    mojDialog.setSize(250, 250);
    mojDialog.setLocation(320,240);
    mojDialog.add("South", new Button("OK"));
    mojDialog.show();
    
  }
  
}

