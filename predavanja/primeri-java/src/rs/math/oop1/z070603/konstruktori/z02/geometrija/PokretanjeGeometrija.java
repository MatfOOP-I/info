/*

Написати Јава програм који омогућује рад са геометријским објектима у равни.

Подаци о разним врстама геометријских објеката су организовани по класама, 
које се налазе у одвојеним датотекама. 

На поља и методе у класама су примењени модификатори приступа.

*/

// Задатак илуструје основну примену конструктора.

package rs.math.oop1.z070603.konstruktori.z02.geometrija;

public class PokretanjeGeometrija {

   public static void main(String[] args) {
      Tacka a = new Tacka("A", 14.5, 15);
      a.prikaziSe();
      Tacka b = new Tacka("B", 10, 11.5);
      b.prikaziSe();
      Tacka c = new Tacka("C");
      c.prikaziSe();
      Tacka d = new Tacka("D", 22.3, 17.5);
      d.prikaziSe();
      Tacka e = new Tacka("E", 25, 25.5);
      e.prikaziSe();
      System.out.println();

      Duz ab = new Duz("AB", a, b);
      ab.prikaziSe();
      System.out.println();

      Duz ax = new Duz("AX", a, new Tacka("X",7,8));
      ax.prikaziSe();
      System.out.println();

      Trougao bcd = new Trougao("BCD", b, c, d);
      bcd.prikaziSe();
      System.out.println();

      Cetvorougao bcde = new Cetvorougao("BCDE", b, c, d,
               e);
      bcde.prikaziSe();
      System.out.println();

      Krug k1 = new Krug("k1", b, 18);
      k1.prikaziSe();
      System.out.println();
      System.out.println("Ukupno je kreirano "
               + Tacka.brojKreiranih + " tacaka.");
   }

}
