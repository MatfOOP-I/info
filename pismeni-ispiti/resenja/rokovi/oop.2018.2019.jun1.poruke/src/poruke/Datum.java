package poruke;

public class Datum implements Comparable<Datum> {

    private int dan, mesec, godina;

    public Datum(String datum) {
        dan = Integer.parseInt(datum.substring(0, 2));
        mesec = Integer.parseInt(datum.substring(3, 5));
        godina = Integer.parseInt(datum.substring(6, 10));
    }

    public int getDan() {
        return dan;
    }

    public int getMesec() {
        return mesec;
    }

    public int getGodina() {
        return godina;
    }

    public String dvocifrenBroj(int i) {
        if (i > 9)
            return "" + i;
        else
            return "0" + i;
    }

    @Override
    public String toString() {
        return dvocifrenBroj(dan) + "." + dvocifrenBroj(mesec) + "." + godina + ".";
    }

    public int compareTo(Datum o) {
        if(this.godina != o.godina)
            return o.godina - this.godina;
        else if (this.mesec != o.mesec)
            return o.mesec - this.mesec;
        else
            return o.dan - this.dan;
    }
}
