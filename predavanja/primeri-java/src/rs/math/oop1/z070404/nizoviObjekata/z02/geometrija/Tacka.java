package rs.math.oop1.z070404.nizoviObjekata.z02.geometrija;

class Tacka {
   double x;
   double y;
   String oznaka;

   void init(String o, double xKoord, double yKoord) {
      oznaka = o;
      x = xKoord;
      y = yKoord;
   }

   void prikaziSe(boolean bezOznake) {
      if (!bezOznake)
         System.out.print(oznaka + "(" + x + "," + y + ")");
      else
         System.out.print("(" + x + "," + y + ")");
   }
   
   double rastojanje(Tacka t) {
      return (Math.sqrt(Math.pow(t.x - x, 2)
               + Math.pow(t.y - y, 2)));
   }

}
