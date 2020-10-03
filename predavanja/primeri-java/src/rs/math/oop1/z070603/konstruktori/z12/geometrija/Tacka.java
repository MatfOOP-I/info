package rs.math.oop1.z070603.konstruktori.z12.geometrija;

import static java.lang.Math.*;

public class Tacka {
   public static int brojKreiranih = 0;

   private String oznaka;
   private double x;
   private double y;

   {
      Tacka.brojKreiranih++;
   }

   public Tacka(String oznaka, double x, double y) {
      this.oznaka = oznaka;
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

   // kopirajuci konstruktor
   public Tacka(final Tacka t) {
      this(t.oznaka, t.x, t.y);
   }

   public String getOznaka() {
      return oznaka;
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
      System.out.printf(oznaka + "(" + x + "," + y + ")");
   }

   public double rastojanje(Tacka t) {
      return (sqrt(pow(t.x - x, 2) + pow(t.y - y, 2)));
   }

}
