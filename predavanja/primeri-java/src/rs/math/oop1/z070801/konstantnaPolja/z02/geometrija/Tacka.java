package rs.math.oop1.z070801.konstantnaPolja.z02.geometrija;

class Tacka {
   String oznaka;
   double x;
   double y;

   void init(String o, double xKoord, double yKoord) {
      x = xKoord;
      y = yKoord;
      oznaka = o;
   }

   String getOznaka() {
      return oznaka;
   }

   double getX() {
      return x;
   }

   double getY() {
      return y;
   }

   void prikaziSe(boolean bezOznake) {
      System.out.print((bezOznake ? "" : oznaka) + "(" + x + "," + y + ")");
   }

   double rastojanje(Tacka t) {
      return (Math.sqrt(Math.pow(t.x - x, 2) + Math.pow(t.y - y, 2)));
   }

}
