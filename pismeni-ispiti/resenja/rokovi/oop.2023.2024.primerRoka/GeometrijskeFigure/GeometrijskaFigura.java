public abstract class GeometrijskaFigura implements Ispis{
    public String ime;

    public GeometrijskaFigura(String ime) {
        this.ime = ime;
    }
    public abstract double povrsina();
}
