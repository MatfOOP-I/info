package rs.math.oop1.z080301.uredjenje.z02.geometrija;

import java.util.Arrays;

public class GeometrijaTestSort {

   /**
    * @param args
    */
   public static void main(String[] args) {
      Tacka a = new Tacka(420, 30, "A");

      Tacka b = new Tacka(100, 40, "B");

      Tacka c = new Tacka(80, 120, "C");

      Tacka d = new Tacka(160, 150, "D");

      Tacka e = new Tacka(150, 160, "E");


      Tacka[] niz = {a, b, c, d, e};
      System.out.println("Pre sortiranja");
      for (Tacka t : niz) {
         t.prikaziSe();
         System.out.println();
      }
      Arrays.sort(niz);
      System.out.println("Posle sortiranja");
      for (Tacka t : niz) {
         t.prikaziSe();
         System.out.println();
      }
   }

}
