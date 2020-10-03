package rs.math.oop1.z070903.prevazilazenje.z01.niskaReprezentacijaGeometrija;

public class Duz extends GeometrijskiObjekat {
   private Tacka a;
   private Tacka b;

   public Duz(String oznaka, Tacka a, Tacka b) {
      super(oznaka);
      this.a = new Tacka(a);
      this.b = new Tacka(b);
   }

   public Duz(Tacka a, Tacka b) {
      this("", a, b);
   }

   public Duz(final Duz d) {
      this(d.getOznaka(), d.a, d.b);
   }

   public double duzina() {
      return a.rastojanje(b);
   }

   public boolean sadrzi(Tacka t) {
      boolean kolinearne = ((t.getY() - a.getY())
               * (b.getX() - a.getX()) == (b.getY()
                        - a.getY())
                        * (t.getX() - a.getX()));
      return kolinearne && t.getX() >= a.getX()
               && t.getX() <= b.getX();
   }

   @Override
   public String toString() {
      return super.toString() + ":[" + a + ";" + b + "]";
   }

   @Override
   public boolean jeKonveksan() {
      return true;
   }

   @Override
   public boolean jeOgranicen() {
      return true;
   }
}
