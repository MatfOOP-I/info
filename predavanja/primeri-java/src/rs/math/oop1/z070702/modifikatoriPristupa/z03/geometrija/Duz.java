package rs.math.oop1.z070702.modifikatoriPristupa.z03.geometrija;

public class Duz {
   private String oznaka;
   private Tacka a;
   private Tacka b;

   
   public void init(String o, Tacka t1, Tacka t2) {
      oznaka = o;
      a = new Tacka();
      a.init(t1.getOznaka(), t1.getX(), t1.getY());
      b = new Tacka();
      b.init(t2.getOznaka(), t2.getX(), t2.getY());
   }

   public void prikaziSe() {
      System.out.print(oznaka + ":[");
      a.prikaziSe(false);
      System.out.print(";");
      b.prikaziSe(false);
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
      double xMin = a.getX()<b.getX()? a.getX(): b.getX(); 
      double xMax = a.getX()<b.getX()? b.getX(): a.getX();
      double yMin = a.getY()<b.getY()? a.getY(): b.getY(); 
      double yMax = a.getY()<b.getY()? b.getY(): a.getY();
           return kolinearne 
                    && (t.getX() >= xMin && t.getX() <= xMax) 
                    && (t.getY() >= yMin && t.getY() <= yMax);
   }
}
