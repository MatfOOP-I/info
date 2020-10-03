/*

Написати Јава програм који омогућује рад са геометријским објектима у равни.

Подаци о разним врстама геометријских објеката су организовани по класама, 
које се налазе у одвојеним датотекама.

*/

// Програм илуструје рад са класама, креирање и позивање метода и комуникацију
// међу објектима.

package rs.math.oop1.z070402.pozivMetoda.z10.geometrija;

public class PokretanjeGeometrija {

   public static void main(String[] args) {
      Tacka a = new Tacka();
      a.init("A", 2, 3);
      a.prikaziSe( false );
      System.out.println();
      Tacka o = new Tacka();
      o.init("O", 0, 0);
      o.prikaziSe( false );
      System.out.println();

      Duz ao = new Duz();
      ao.init("AO", a, o);
      ao.prikaziSe();
      System.out.println();

      o.y = 7.5;
      ao.prikaziSe();
      System.out.println();

   }

}
