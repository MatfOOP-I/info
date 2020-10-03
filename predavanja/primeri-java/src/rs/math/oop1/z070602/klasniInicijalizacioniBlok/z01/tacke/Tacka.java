package rs.math.oop1.z070602.klasniInicijalizacioniBlok.z01.tacke;

public class Tacka {
   int x;
   int y;
   String oznaka;

   static int brojKreiranih = 0;
   static String prefiks = "T";

   static {
      prefiks = (new Character((char) ('A' + Math.random() * 26))).toString();
   }

   {
      x = (int) (Math.random() * 100);
      y = (int) (Math.random() * 100);
   }

   {
      brojKreiranih++;
      oznaka = prefiks + brojKreiranih;
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

}
