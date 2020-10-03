import java.util.Comparator;

public class StavkaRasporeda implements Comparable<StavkaRasporeda> {
    private ReliVozac vozac;
    private int startH;
    private int startM;

    public StavkaRasporeda(ReliVozac vozac, int startH, int startM) {
        this.vozac = vozac;
        this.startH = startH;
        this.startM = startM;
    }

    @Override
    public String toString() {
        return "[" + this.startH + ":" + this.startM + "] " + this.vozac.toString();
    }

    public boolean imaKonfliktSa(StavkaRasporeda o, int maxVreme) {
        int s1 = this.startH * 60 + this.startM;
        int e1 = s1 + maxVreme;
        int s2 = o.startH * 60 + o.startM;
        int e2 = s2 + maxVreme;
        return !(s2 > e1 || s1 > e2);
    }

    @Override
    public int compareTo(StavkaRasporeda o) {
        if (this.startH < o.startH)
            return -1;
        if (o.startH < this.startH)
            return 1;
        if (this.startM == o.startM)
            return 0;
        return this.startM < o.startM ? -1 : 1;
    }

    public ReliVozac getVozac() {
        return vozac;
    }
}
