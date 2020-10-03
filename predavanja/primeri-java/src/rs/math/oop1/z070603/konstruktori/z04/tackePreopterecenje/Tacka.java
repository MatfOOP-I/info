package rs.math.oop1.z070603.konstruktori.z04.tackePreopterecenje;

public class Tacka {
   int x;
   int y;
   String oznaka;

   Tacka(int xKoord, int yKoord, String o) {
      x = xKoord;
      y = yKoord;
      oznaka = o;
   }

   Tacka(String o) {
      this(0, 0, o);
   }

   Tacka() {
      this(0, 0, "Ishodiste");
   }

   void prikaziSe() {
      System.out.print(oznaka + ":(" + x + "," + y + ")");
   }

   double rastojanje(Tacka drugaTacka) {
      return Math.max(Math.abs(x - drugaTacka.x), Math.abs(y - drugaTacka.y));
   }

}
