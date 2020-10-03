/*

Написати Јава програм који омогућује рад са геометријским објектима у равни.

Подаци о разним врстама геометријских објеката су организовани по класама, 
које се налазе у одвојеним датотекама. 

На поља и методе у класама су примењени модификатори приступа.

*/

// Задатак илуструје примену иницијализационих блокова примерка.

package rs.math.oop1.z070601.inicijalizacioniBlokPrimerka.z04.geometrija;

public class PokretanjeGeometrija {

   public static void main(String[] args) {
      Tacka a = new Tacka();
      a.init("A", 14.5, 15);
      a.prikaziSe();
      Tacka b = new Tacka();
      b.init("B", 10, 11.5);
      b.prikaziSe();
      Tacka c = new Tacka();
      c.init("C", 10.45, 22);
      c.prikaziSe();
      Tacka d = new Tacka();
      d.init("D", 22.3, 17.5);
      d.prikaziSe();
      Tacka e = new Tacka();
      e.init("E", 25, 25.5);
      e.prikaziSe();
      System.out.println();

      Duz ab = new Duz();
      ab.init("AB", a, b);
      ab.prikaziSe();
      System.out.println();

      Trougao bcd = new Trougao();
      bcd.init("BCD", b, c, d);
      bcd.prikaziSe();
      System.out.println();

      Cetvorougao bcde = new Cetvorougao();
      bcde.init("BCDE", b, c, d, e);
      bcde.prikaziSe();
      System.out.println();

      Krug k1 = new Krug();
      k1.init("k1", b, 18);
      k1.prikaziSe();
      
      System.out.println();
      System.out.println("Ukupno je kreirano " + Tacka.brojKreiranih + " tacaka.");
   }

}
