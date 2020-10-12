/*

Написати Јава програм који омогућује рад са геометријским објектима у равни.

Подаци о разним врстама геометријских објеката су организовани по класама, 
које се налазе у одвојеним датотекама.

*/

// Програм илуструје рад са класама и објектима, као и рад са низовима
// објеката датог типа (PokretanjeGeometrija).

package rs.math.oop1.z070401.definicjeMetoda.z02.geometrija;

public class PokretanjeGeometrija1 {

   public static void main(String[] args) {
      Tacka a = new Tacka();
      a.init("A", 2, 3);

      Tacka b = new Tacka();
      b.init("B", 3, 4);
      b.y = 22;

      Duz ab = new Duz();
      ab.init("AB", a, b);

      a.prikaziSe(false);
      b.prikaziSe(false);
      ab.prikaziSe();
      System.out.println();

      b.y = -3;
      a.prikaziSe(false);
      b.prikaziSe(false);
      ab.prikaziSe();
      System.out.println();

   }

}
