package rs.math.oop1.z070603.konstruktori.z05.geometrijaPreopterecenje;

public class Duz {
   private String oznaka;
   private Tacka a;
   private Tacka b;

   // OK
   public Duz(String o, Tacka t1, Tacka t2) {
   	   oznaka = o;
   	   a = new Tacka(t1.getOznaka(), t1.getX(), t1.getY());
   	   b = new Tacka(t2.getOznaka(), t2.getX(), t2.getY());
   }

   /* nije OK! */
   // public Duz(String o, Tacka t1, Tacka t2) {
   //    oznaka = o;
   //    a = t1;
   //    b = t2;
   // }

   public String getOznaka() {
      return oznaka;
   }

   public void prikaziSe() {
      System.out.print(oznaka + ":[");
      a.prikaziSe();
      System.out.print(";");
      b.prikaziSe();
      System.out.print("]");
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
}
