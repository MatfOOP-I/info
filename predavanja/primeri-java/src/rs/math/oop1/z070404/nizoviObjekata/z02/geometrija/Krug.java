package rs.math.oop1.z070404.nizoviObjekata.z02.geometrija;

class Krug {
   String oznaka;
   Tacka o;
   double r;
  
   void init(String ozn, Tacka centar,
            double poluprecnik) {
      oznaka = ozn;
      o = new Tacka();
      o.init(centar.oznaka, centar.x,
               centar.y);
      r = poluprecnik;
   }

   String getOznaka() {
      return oznaka;
   }

   void prikaziSe() {
      System.out.print(oznaka + ":[");
      o.prikaziSe( false );
      System.out.print(";" + r + "]");
   }

   double obim() {
      return 2 * r * Math.PI;
   }

   double povrsina() {
      return Math.pow(r, 2) * Math.PI;
   }

}
