import java.util.Random;

public class Korona extends ZaraznaBolest {
    private boolean pokazujeSimptome;
    private static int brojTestiranih = 0;
    private static Random random = new Random();

    public Korona(int duzinaBolesti, boolean pokazujeSimptome) {
        super(duzinaBolesti);
        this.pokazujeSimptome = pokazujeSimptome;
    }

    public Korona() {
        this(0, false);
    }

    public Korona(Korona k){
        this(k.getDuzinaBolesti(), k.pokazujeSimptome);
    }


    public boolean isPokazujeSimptome() {
        return pokazujeSimptome;
    }

    public static int getBrojTestiranih() {
        return brojTestiranih;
    }

    public boolean test() {
        double r = random.nextDouble();
        brojTestiranih++;
        if (pokazujeSimptome) {
            return r < 0.8;
        }
        else {
            return r < 0.4;
        }
    }


    @Override
    public String toString() {
        return "Korona traje: " + super.getDuzinaBolesti() + " dana " + (pokazujeSimptome ? "sa simptomima" : "bez simptoma");
    }
}
