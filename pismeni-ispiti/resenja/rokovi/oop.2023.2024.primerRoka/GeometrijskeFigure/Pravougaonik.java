public class Pravougaonik extends GeometrijskaFigura {
    float duzina, sirina;

    public Pravougaonik(String ime, float duzina, float sirina) {
        super(ime);
        this.duzina = duzina;
        this.sirina = sirina;
    }

    @Override
    public double povrsina() {
        return duzina*sirina;
    }

    @Override
    public void ispisi() {
        System.out.println("Pravougaonik " + this.ime + " - duzina: " + this.duzina + ", sirina: " + this.sirina);
    }
}
