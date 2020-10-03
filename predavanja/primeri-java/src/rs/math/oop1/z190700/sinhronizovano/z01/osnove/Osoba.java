package rs.math.oop1.z190700.sinhronizovano.z01.osnove;

public class Osoba {
    private String ime;
    private String prezime;

    public Osoba(String ime, String prezime){
        this.ime = ime;
        this.prezime = prezime;
    }

    public String vratiIme(){
        return ime;
    }

    public String vratiPrezime(){
        return prezime;
    }

}
