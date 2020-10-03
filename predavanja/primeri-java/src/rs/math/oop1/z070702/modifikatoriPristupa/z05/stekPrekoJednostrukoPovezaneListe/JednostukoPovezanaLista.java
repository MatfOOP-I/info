package rs.math.oop1.z070702.modifikatoriPristupa.z05.stekPrekoJednostrukoPovezaneListe;

public class JednostukoPovezanaLista {

    private ElemenatListe pocetak = null;
    private ElemenatListe kraj = null;

    public void init(String elem) {
        if (elem != null) {
            ElemenatListe el = new ElemenatListe();
            el.init(elem);
            kraj = pocetak = el;
        }
    }

    public void dodajElemenatNaKraj(String elem) {
        ElemenatListe noviKraj = new ElemenatListe();
        noviKraj.init(elem);
        if (pocetak == null)
            pocetak = kraj = noviKraj;
        else {
            kraj.setSledeci(noviKraj);
            kraj = noviKraj;
        }
    }

    public String ukloniElemenatSaKraja() {
        if (kraj == null)
            return null;
        if (pocetak == kraj) {
            ElemenatListe jedini = kraj;
            pocetak = kraj = null;
            return jedini.getSadrzaj();
        }
        ElemenatListe poslednji = kraj;
        ElemenatListe pretposlednji = pocetak;
        while (pretposlednji.getSledeci() != poslednji)
            pretposlednji = pretposlednji.getSledeci();
        pretposlednji.setSledeci(null);
        kraj = pretposlednji;
        return poslednji.getSadrzaj();
    }

    public void dodajElemenatNaPocetak(String elem) {
        ElemenatListe noviPocetak = new ElemenatListe();
        noviPocetak.init(elem);
        if (kraj == null)
            pocetak = kraj = noviPocetak;
        else {
            noviPocetak.setSledeci(pocetak);
            pocetak = noviPocetak;
        }
    }

    public String ukloniElemenatSaPocetka() {
        if (pocetak == null)
            return null;
        if (pocetak == kraj) {
            ElemenatListe jedini = kraj;
            pocetak = kraj = null;
            return jedini.getSadrzaj();
        }
        ElemenatListe prvi = pocetak;
        pocetak = prvi.getSledeci();
        return prvi.getSadrzaj();
    }

    public int duzina() {
        int rez = 0;
        ElemenatListe tekuci = pocetak;
        while (tekuci != null) {
            rez++;
            tekuci = tekuci.getSledeci();
        }
        return rez;
    }
}
