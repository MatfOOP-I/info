package rs.math.oop1.z070502.prevazilazenje.z03.geometrija;

public class Prava extends GeometrijskiObjekat {

   private double a;
   private double b;
   private double c;

   public Prava(String oznaka, double a, double b,
            double c) {
      super(oznaka);
      this.a = a;
      this.b = b;
      this.c = c;
   }

   public Prava(double a, double b, double c) {
      this("", a, b, c);
   }

   public Prava(String oznaka, Tacka t1, Tacka t2) {
      super(oznaka);
      a = t2.getY() - t1.getY();
      b = t1.getX() - t2.getX();
      c = t1.getY() * (t2.getX() - t1.getX())
               - t1.getX() * (t2.getY() - t1.getY());
   }

   public Prava(Tacka t1, Tacka t2) {
      this("", t1, t2);
   }

   public void prikaziSe() {
      super.prikaziSe();
      System.out.print(
               ":[a=" + a + ";b=" + b + ";c=" + c + "]");
   }

   private double uvrstiKoordinate(Tacka t) {
      return a * t.getX() + b * t.getY() + c;
   }

   public boolean sadrzi(Tacka t) {
      return (uvrstiKoordinate(t) == 0);
   }

   public boolean suSaIsteStranePrave(Tacka t1, Tacka t2) {
      return uvrstiKoordinate(t1)
               * uvrstiKoordinate(t2) > 0;
   }

   public boolean suSaRaznihStranaPrave(Tacka t1,
            Tacka t2) {
      return !suSaIsteStranePrave(t1, t2);
   }

   public boolean jeParalelnaSa(Prava p) {
      return p.a * b == a * p.b;
   }

   public boolean jeKonveksan() {
      return true;
   }

   public boolean jeOgranicen() {
      return false;
   }

}
