public class Main {
    public static void main(String[] args) {
        GeometrijskiSkup skup = new GeometrijskiSkup(new GeometrijskaFigura[]{
                new Krug("krug1", 2),
                new Kvadrat("kvadrat1", 3),
                new Pravougaonik("pravougaonik1", 2, 3)
        });

        System.out.println(skup.ukupnaPovrsina());

        for (GeometrijskaFigura figura: skup.geometrijskeFigure) {
            figura.ispisi();
        }
    }
}