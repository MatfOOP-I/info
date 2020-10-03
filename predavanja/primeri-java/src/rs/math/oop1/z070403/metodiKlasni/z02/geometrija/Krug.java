package rs.math.oop1.z070403.metodiKlasni.z02.geometrija;

class Krug {
   String oznaka;
   Tacka o;
   double r;

   static int brojInicijalizacija = 0;
   
   void init(String ozn, Tacka centar,
            double poluprecnik) {
      oznaka = ozn;
      o = new Tacka();
      o.init(centar.getOznaka(), centar.getX(),
               centar.getY());
      r = poluprecnik;
      brojInicijalizacija++;
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
      return 2 * r * Math.PI;
   }

   double povrsina() {
      return Math.pow(r, 2) * Math.PI;
   }

   boolean sadrzi(Tacka t) {
      return t.rastojanje(o) <= r;
   }
}
