public class Krug extends GeometrijskaFigura {
    double poluprecnik;

    public Krug(String ime, double poluprecnik) {
        super(ime);
        this.poluprecnik = poluprecnik;
    }

    @Override
    public double povrsina() {
        return poluprecnik*poluprecnik*Math.PI;
    }

    @Override
    public void ispisi() {
        System.out.println("Krug " + this.ime + " - poluprecnik: " + this.poluprecnik);
    }
}
