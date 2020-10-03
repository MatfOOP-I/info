/*

Написати Јава програм који омогућује рад са геометријским објектима у равни.

Подаци о разним врстама геометријских објеката су организовани по класама, 
које се налазе у одвојеним датотекама.

*/

// Програм илуструје рад са класама, креирање и позивање метода и комуникацију
// међу објектима.
// Програм такође илуструје и преоптерећење метода (Tacka).

package rs.math.oop1.z070402.pozivMetoda.z05.geometrijaPreopterecenje;

public class PokretanjeGeometrija {

   public static void main(String[] args) {
      Tacka a = new Tacka();
      a.init("A", 2, 3);
      a.prikaziSe();
      System.out.println();
      Tacka o = new Tacka();
      o.init("O", 0, 0);
      o.prikaziSe();
      System.out.println();

      Duz ao = new Duz();
      //ao.init("AO", a, o); // ovo je dobro!
      ao.initNeValja("AO", a, o); // ovo nije dobro!
      ao.prikaziSe();
      System.out.println();

      o.y = 7.5;
      ao.prikaziSe();
      System.out.println();

   }

}
