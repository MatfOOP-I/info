package v15a.v03;
import java.awt.*;

class MojaApl extends Frame {

    MojaApl(String naslov) {
        super(naslov);
        setLayout(new FlowLayout());
        add(new Button("OK"));
        add(new Button("Ponovo"));
        add(new Button("Prekini"));
    }

    public static void main(String args[]) {
        MojaApl apl = new MojaApl("Zdravo! Kako izgledam?");
        apl.resize(300,300);
        apl.show();
    }
}