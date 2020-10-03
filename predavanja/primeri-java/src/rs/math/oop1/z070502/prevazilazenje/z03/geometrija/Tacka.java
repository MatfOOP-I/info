package rs.math.oop1.z070502.prevazilazenje.z03.geometrija;

public class Tacka extends GeometrijskiObjekat {

   private double x;
   private double y;

   public Tacka(String oznaka, double x, double y) {
      super(oznaka);
      this.x = x;
      this.y = y;
   }

   public Tacka(double x, double y) {
      this("", x, y);
   }

   public Tacka(String oznaka) {
      this(oznaka, 0, 0);
   }

   public Tacka() {
      this("O", 0, 0);
   }

   public Tacka(final Tacka t) {
      this(t.getOznaka(), t.x, t.y);
   }

   public double getX() {
      return x;
   }

   public void setX(double x) {
      this.x = x;
   }

   public double getY() {
      return y;
   }

   public void setY(double y) {
      this.y = y;
   }

   public void prikaziSe() {
      super.prikaziSe();
      System.out.printf("(" + x + "," + y + ")");
   }

   public double rastojanje(Tacka t) {
      return (Math.sqrt(Math.pow(t.x - x, 2)
               + Math.pow(t.y - y, 2)));
   }

   public boolean jeKonveksan() {
      return true;
   }

   public boolean jeOgranicen() {
      return true;
   }

}
