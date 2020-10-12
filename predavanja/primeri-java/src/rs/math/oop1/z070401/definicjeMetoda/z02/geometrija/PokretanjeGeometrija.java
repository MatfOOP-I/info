/*

Написати Јава програм који омогућује рад са геометријским објектима у равни.

Подаци о разним врстама геометријских објеката су организовани по класама, 
које се налазе у одвојеним датотекама.

*/

// Програм илуструје рад са класама и објектима, као и рад са низовима
// објеката датог типа (PokretanjeGeometrija).

package rs.math.oop1.z070401.definicjeMetoda.z02.geometrija;

public class PokretanjeGeometrija {

   public static void main(String[] args) {
      Tacka a = new Tacka();
      a.init("A", 2, 3);
   
      Tacka o = new Tacka();
      o.init("O", 0, 0);

      Tacka b = new Tacka();
      b.init("B", 3, 4);
      b.y = 22;

      Tacka c = new Tacka();
      c.init("C", 13, 7);
      c.x = 10;

      Tacka[] tacke = { a, o, b, c };
      for (int i = 0; i < tacke.length; i++)
         tacke[i].prikaziSe(false);
      System.out.println();

      Duz ao = new Duz();
      ao.init("AO", a, o);

      Duz ab = new Duz();
      ab.init("AB", a, b);

      Duz ac = new Duz();
      ac.init("AC", a, c);

      Duz ob = new Duz();
      ob.init("OB", o, b);

      Duz oc = new Duz();
      oc.init("OC", o, c);

      Duz bc = new Duz();
      bc.init("BC", b, c);

      Duz[] duzi = new Duz[6];
      duzi[0] = ao;
      duzi[1] = ab;
      duzi[2] = ac;
      duzi[3] = ob;
      duzi[4] = oc;
      duzi[5] = bc;

      for (Duz d : duzi)
         d.prikaziSe();
   }

}
