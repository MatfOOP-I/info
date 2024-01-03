public class Kvadrat extends GeometrijskaFigura {
    float duzinaStranice;

    public Kvadrat(String ime, float duzinaStranice) {
        super(ime);
        this.duzinaStranice = duzinaStranice;
    }

    @Override
    public double povrsina() {
        return duzinaStranice*duzinaStranice;
    }

    @Override
    public void ispisi() {
        System.out.println("Kvadrat " + this.ime + " - stranica: " + this.duzinaStranice);
    }
}
