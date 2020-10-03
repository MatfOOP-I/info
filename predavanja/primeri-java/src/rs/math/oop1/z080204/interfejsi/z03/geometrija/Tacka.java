package rs.math.oop1.z080204.interfejsi.z03.geometrija;

import java.util.Objects;

public class Tacka extends GeometrijskiObjekat implements OblikPrikaz, Sadrzavanje {

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


   public double rastojanje(Tacka t) {
      return (Math.sqrt(Math.pow(t.x - x, 2)
            + Math.pow(t.y - y, 2)));
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      Tacka tacka = (Tacka) o;
      return Double.compare(tacka.getX(), getX()) == 0 &&
            Double.compare(tacka.getY(), getY()) == 0;
   }

   @Override
   public int hashCode() {
      return Objects.hash(getX(), getY());
   }

   @Override
   public String toString() {
      return getOznaka() + "(" + x + "," + y + ")";
   }

   @Override
   public void prikaziNaKonzoli() {
      System.out.printf("%s", this);
   }

   @Override
   public boolean jeKonveksan() {
      return true;
   }

   @Override
   public boolean jeOgranicen() {
      return true;
   }

   @Override
   public boolean sadrzi(Tacka t) {
      return x == t.x && y == t.y;
   }
}
