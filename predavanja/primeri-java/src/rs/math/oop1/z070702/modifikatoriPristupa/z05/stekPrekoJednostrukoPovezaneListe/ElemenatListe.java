package rs.math.oop1.z070702.modifikatoriPristupa.z05.stekPrekoJednostrukoPovezaneListe;

public class ElemenatListe {
    private String sadrzaj;
    private ElemenatListe sledeci;

    public void init(String elem) {
        sadrzaj = elem;
        sledeci = null;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public ElemenatListe getSledeci() {
        return sledeci;
    }

    public void setSledeci(ElemenatListe sledeci) {
        this.sledeci = sledeci;
    }
}
