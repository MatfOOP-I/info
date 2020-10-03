package busplus;

public class Nepersonalizovana extends BusPlus {
    private int kredit;
    private boolean ocitana;

    public static int cena_voznje = 90;

    public Nepersonalizovana(int id, int zona, int kredit, boolean ocitana) {
        super(id, zona);
        this.kredit = kredit;
        this.ocitana = ocitana;
    }

    public int getKredit() {
        return kredit;
    }

    public boolean isOcitana() {
        return ocitana;
    }

    public boolean nedovoljnoKredita() {
        return this.kredit - cena_voznje < 0;
    }

    public boolean ocitajKartu() {
        if(isOcitana())
            return false;
        if (nedovoljnoKredita())
            return false;

        this.ocitana = true;
        this.kredit -= cena_voznje;
        return true;
    }

    @Override
    public int compareTo(BusPlus o) {
        if(o instanceof Personalizovana)
            return 1;
        else
            return Integer.compare(((Nepersonalizovana)o).kredit, this.kredit);
    }

    @Override
    public String toString() {
        return "[NP] " + super.toString() + ", kredit: " + kredit + " | " +
                (isOcitana() ? "ocitana" : (nedovoljnoKredita() ? "nedovoljno kredita" : "nije ocitana"));
    }
}
