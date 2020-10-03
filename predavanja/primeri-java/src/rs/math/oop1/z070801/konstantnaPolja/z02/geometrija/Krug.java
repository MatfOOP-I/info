package rs.math.oop1.z070801.konstantnaPolja.z02.geometrija;

class Krug {
   String oznaka;
   Tacka o;
   double r;
 
   final double PI = Math.PI;
   
   void init(String ozn, Tacka centar,
            double poluprecnik) {
      oznaka = ozn;
      o = new Tacka();
      o.init(centar.getOznaka(), centar.getX(),
               centar.getY());
      r = poluprecnik;
    }

   String getOznaka() {
      return oznaka;
   }

   void prikaziSe() {
      System.out.print(oznaka + ":[");
      o.prikaziSe(false);
      System.out.print(";" + r + "]");
   }

   double obim() {
      return 2 * r * PI;
   }

   double povrsina() {
      return Math.pow(r, 2) * PI;
   }

   boolean sadrzi(Tacka t) {
      return t.rastojanje(o) <= r;
   }
}
