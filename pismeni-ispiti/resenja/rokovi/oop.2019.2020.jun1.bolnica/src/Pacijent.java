public class Pacijent implements Izleciv, Comparable<Pacijent> {
    private ZaraznaBolest dijagnoza;
    private String ime, prezime;
    private int idKnjizice;
    private int duzinaLecenja;
    private boolean zarazen;

    public Pacijent(String ime, String prezime, int idKnjizice, ZaraznaBolest dijagnoza){
        this.ime = ime;
        this.prezime = prezime;
        this.idKnjizice = idKnjizice;
        this.dijagnoza = dijagnoza;
        this.duzinaLecenja = 0;
        this.zarazen = false;
    }

    public int getIdKnjizice() {
        return idKnjizice;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public ZaraznaBolest getDijagnoza() {
        return dijagnoza;
    }

    public void setDuzinaLecenja(int duzinaLecenja) {
        this.duzinaLecenja = duzinaLecenja;
    }

    public boolean isZarazen() {
        return zarazen;
    }

    public void setZarazen(boolean zarazen) {
        this.zarazen = zarazen;
    }

    @Override
    public String toString() {
        int vremeDoIzlecenja = (dijagnoza.getDuzinaBolesti() - duzinaLecenja) > 0 ?
                (dijagnoza.getDuzinaBolesti() - duzinaLecenja) : 0;
        return "Id: " + idKnjizice + " " + ime + " " + prezime + (izlecen()? "" : "\n boluje od: " + dijagnoza +
                " Vreme do izlecenja: " + vremeDoIzlecenja);
    }

    @Override
    public void leci(int brojDana) {
        duzinaLecenja += brojDana;
    }

    @Override
    public boolean izlecen() {
        return duzinaLecenja >= dijagnoza.getDuzinaBolesti();
    }

    @Override
    public int compareTo(Pacijent o) {
        if(dijagnoza instanceof Korona && o.getDijagnoza() instanceof Grip){
            return -1;
        }
        else if(dijagnoza instanceof Korona && o.getDijagnoza() instanceof Korona ||
                dijagnoza instanceof Grip && o.getDijagnoza() instanceof Grip) {
            return Integer.compare(o.getDijagnoza().getDuzinaBolesti(), dijagnoza.getDuzinaBolesti());
        }
        else if(dijagnoza instanceof Grip && o.getDijagnoza() instanceof Korona){
            return 1;
        }
        else{
            return 0;
        }
    }
}