package sakupljanjeDragulja;

import java.util.Random;

public class Tragac extends ObjekatIgre {
    private Ranac ranac;
    private static String smerKretanja = "";
    private static Random random = new Random();

    public Tragac(String naziv, int x, int y, Ranac ranac) {
        super(naziv, x, y);
        this.ranac = ranac;
    }

    public static void setSmerKretanja(String sk) {
        if (sk.equalsIgnoreCase("dd") || sk.equalsIgnoreCase("gl"))
            smerKretanja = sk;
    }

    public boolean pokupiDragulj(Rudnik rudnik) {
        return ranac.smestiDragulj(rudnik.getTezinaDragulja());
    }

    public Ranac getRanac() {
        return ranac;
    }

    @Override
    public void izvrsiAkciju() {

        boolean horizontalno = random.nextBoolean();
        if (smerKretanja.equalsIgnoreCase("dd")) {
            if (horizontalno) X++;
            else Y++;
        } else if (smerKretanja.equalsIgnoreCase("gl")) {
            if (horizontalno) X--;
            else Y++;
        } else {
            System.out.println("Ovo ne bi trebalo da se desi! smer="+smerKretanja);
        }
    }

    @Override
    public String toString() {
        return "Tragac: "+super.toString()+" ima "+ranac;
    }
}
