package rs.math.oop1.z120501.strukturisanjePodataka.z01.samorastuciNiz;

public class SamorastuciNiz<E> {
    private E[] elementi;
    private int uvecanjeDimenzije = 0;

    public int vratiKapacitet() {
        return elementi.length;
    }

    private void obezbediKapacitetPomocni(int noviKapacitet) {
        if (noviKapacitet > vratiKapacitet()) {
            int inkrementKapaciteta = (uvecanjeDimenzije>0)? vratiKapacitet() + uvecanjeDimenzije: 2 *vratiKapacitet();
            noviKapacitet = (noviKapacitet>inkrementKapaciteta)? noviKapacitet:inkrementKapaciteta;
            E[] noviNiz = (E[]) new Object[noviKapacitet];
            // probati sa arraycopy...
            for (int i = 0; i < elementi.length; i++)
                noviNiz[i] = elementi[i];
            elementi = noviNiz;
        }
    }

    public SamorastuciNiz(int inicijalnaDimenzija, int uvecanjeDimenzije) {
        elementi = (E[]) new Object[inicijalnaDimenzija];
        this.uvecanjeDimenzije = uvecanjeDimenzije;
    }

    public SamorastuciNiz(int inicijalnaDimenzija) {
        this(inicijalnaDimenzija, 0);
    }

    public SamorastuciNiz() {
        this(10);
    }

    public E naPoziciji(int indeks) throws IndexOutOfBoundsException {
        if (indeks < 0 || indeks >= elementi.length)
            throw new IndexOutOfBoundsException();
        return elementi[indeks];
    }

    public void postaviNaPoziciju(E element, int indeks) throws IndexOutOfBoundsException {
        if (indeks < 0)
            throw new IndexOutOfBoundsException();
        obezbediKapacitetPomocni(indeks+1);
        elementi[indeks] = element;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < elementi.length; i++) {
            if (i % 10 == 0 && i!=0)
                sb.append("\r\n");
            sb.append(elementi[i] + "\t");
        }
        return sb.toString();
    }
}
