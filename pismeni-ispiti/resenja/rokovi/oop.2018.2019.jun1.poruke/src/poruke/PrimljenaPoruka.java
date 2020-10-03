package poruke;

public class PrimljenaPoruka extends Poruka {

    private String posiljalac;
    private boolean procitano;

    public PrimljenaPoruka(String tekstPoruke, String datum, String posiljalac, boolean procitano) {
        super(tekstPoruke, datum);
        this.posiljalac = posiljalac;
        this.procitano = procitano;
    }

    @Override
    public String sacuvajPoruku() {
        return  "r; " + getDatum() + "; " + posiljalac + "; " + getTekstPoruke() + "; " + (procitano?"da":"ne");
    }

    @Override
    public String toString() {
        return "Posiljalac: " + posiljalac + " " + (procitano?"":" (neprocitano) ") + super.toString();
    }

    @Override
    public int compareTo(Poruka o) {
        if(o instanceof PoslataPoruka) {
            return -1;
        }

        if (this.procitano && !((PrimljenaPoruka) o).procitano)
            return 1;
        else if (!this.procitano && ((PrimljenaPoruka) o).procitano)
            return -1;
        else
            return  this.getDatum().compareTo(o.getDatum());
    }
}
