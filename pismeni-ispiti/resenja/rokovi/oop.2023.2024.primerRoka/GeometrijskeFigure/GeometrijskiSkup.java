public class GeometrijskiSkup {
    public GeometrijskaFigura[] geometrijskeFigure;

    public GeometrijskiSkup(GeometrijskaFigura[] geometrijskeFigure) {
        this.geometrijskeFigure = geometrijskeFigure;
    }

    public float ukupnaPovrsina() {
        float zbir = 0;
        for (GeometrijskaFigura figura : this.geometrijskeFigure) {
            zbir += figura.povrsina();
        }
        return zbir;
    }
}
