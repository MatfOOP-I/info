package primer02Comparator.comparatorV1;

import java.util.Comparator;

public class PorediPoXPaY implements Comparator<Tacka> {

    @Override
    public int compare(Tacka o1, Tacka o2) {
        return o1.getX() != o2.getX()?
                Integer.compare(o1.getX(), o2.getX()):
                Integer.compare(o1.getY(), o2.getY());
    }
}
