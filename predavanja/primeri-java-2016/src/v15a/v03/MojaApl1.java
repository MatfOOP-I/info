package v15a.v03;
import java.awt.*;

class MojaApl1 extends Frame {

    MojaApl1(String naslov) {
        super(naslov);
        setLayout(new FlowLayout());
        add(new Button("OK"));
        add(new Button("Ponovo"));
        add(new Button("Prekini"));
    }

    public static void main(String args[]) {
        MojaApl1 apl = new MojaApl1("Kako izgledam?");
        apl.resize(300,300);
        apl.setLocation(400,400);
        apl.show();
          for (int i=1;i<100000000; i++)Math.random();
        apl.hide();      
        System.exit(0);
        
    }
   
}