/*

Написати Јава програм који омогућује рад са геометријским објектима у равни.

Подаци о разним врстама геометријских објеката су организовани по класама, 
које се налазе у одвојеним датотекама. 

*/

// Задатак илуструје коришћење наслеђивања.
// Задатак илуструје коришћење кључне речи super.

package rs.math.oop1.z080204.interfejsi.z03.geometrija;

import java.util.Scanner;

public class PokretanjeGeometrija2 {

   public static void main(String[] args) {
      Tacka a = new Tacka("A", 14.5, 15);
      System.out.print(a + " ");
      Tacka b = new Tacka("B", 10, 11.5);
      System.out.print(b + " ");
      Tacka c = new Tacka("C", 10.45, 22);
      System.out.print(c + " ");
      Tacka d = new Tacka("D",22.3, 17.5);
      System.out.print(d + " ");
      Tacka e = new Tacka("E", 25, 25.5);
      System.out.print(e + " ");
      Duz ab = new Duz("dAB", a, b);
      System.out.print(ab + " ");
      Prava p = new Prava("pAD", a, d);
      System.out.print(p + " ");
      Trougao bcd = new Trougao("tBCD", b, c, d);
      System.out.print(bcd + " ");
      Cetvorougao bcde = new Cetvorougao("cBCDE",b, c, d, e);
      System.out.print(bcde + " ");
      Krug k1 = new Krug("kB18",b, 18);
      System.out.print(k1 + " ");
      System.out.println(k1 + " ");

      Scanner sc = new Scanner(System.in);
      System.out.print("Unesite koordinate tacke X: ");
      Tacka x = new Tacka("X", sc.nextDouble(), sc.nextDouble());
      sc.close();

      Sadrzavanje[] svi = {a, b, c, d, e, ab, p, bcd, bcde, k1};
      System.out.println("Objekti koji sadrze datu tacku X " + x + "su: " );
      for (Sadrzavanje sd : svi)
         if( sd.sadrzi(x))
            System.out.println(sd);
      System.out.println("Tokom rada programa kreirano je "
            + GeometrijskiObjekat.brojKreiranih
            + " geometrijskih objekata.");
   }

}
