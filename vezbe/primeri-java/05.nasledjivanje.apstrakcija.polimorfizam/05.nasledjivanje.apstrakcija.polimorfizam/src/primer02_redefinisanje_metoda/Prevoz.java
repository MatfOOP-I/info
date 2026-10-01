package primer02_redefinisanje_metoda;

public class Prevoz {
    private String naziv;

    public Prevoz(String naziv) {
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    /**
     * Privremena podrazumevana implementacija. U sledećem primeru ćemo
     * shvatiti da opšti Prevoz zapravo nema dovoljno informacija da
     * smisleno odredi cenu i metoda će postati apstraktna.
     */
    public int izracunajCenu(int udaljenostKm) {
        return udaljenostKm * 10;
    }
}
