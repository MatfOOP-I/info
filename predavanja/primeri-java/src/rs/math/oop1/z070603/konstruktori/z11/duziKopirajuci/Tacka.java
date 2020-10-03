package rs.math.oop1.z070603.konstruktori.z11.duziKopirajuci;

public class Tacka {
   int x;
   int y;
   String oznaka;

   Tacka(int xKoord, int yKoord, String o) {
      x = xKoord;
      y = yKoord;
      oznaka = o;
   }

   Tacka(final Tacka t) {
      this(t.x, t.y, t.oznaka);
   }

   Tacka(String o) {
      this(0, 0, o);
   }

   Tacka() {
      this(0, 0, "O");
   }

   void setX(int xKoord) {
      x = xKoord;
   }

   void setY(int yKoord) {
      y = yKoord;
   }

   void prikaziSe() {
      System.out.print(oznaka + ":(" + x + "," + y + ")");
   }

   double rastojanje(Tacka drugaTacka) {
      return Math.sqrt(Math.pow(x - drugaTacka.x, 2) + Math.pow(y - drugaTacka.y, 2));
   }
}
