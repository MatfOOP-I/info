/*

Написати Јава програм који омогућује рад са геометријским објектима у равни.

Подаци о разним врстама геометријских објеката су организовани по класама, 
које се налазе у одвојеним датотекама. 

*/

// Користи се константно поље за чување броја PI


package rs.math.oop1.z070801.konstantnaPolja.z02.geometrija;

public class PokretanjeGeometrija {

   public static void main(String[] args) {
      Tacka a = new Tacka();
      a.init("A", 14.5, 15);
      Tacka b = new Tacka();
      b.init("B", 10, 11.5);
      Tacka c = new Tacka();
      c.init("C", 10.45, 22);
      Tacka d = new Tacka();
      d.init("D", 22.3, 17.5);
      Tacka e = new Tacka();
      e.init("E", 25, 25.5);
      Tacka[] tacke = {a,b,c,d,c};
      for( Tacka t:tacke)
         t.prikaziSe(true);
      System.out.println("\n");

      Duz ab = new Duz();
      ab.init("AB", a, b);
      ab.prikaziSe();
      System.out.println("\n");

      Trougao bcd = new Trougao();
      bcd.init("BCD", b, c, d);
      bcd.prikaziSe();
      System.out.println("\n");

      Cetvorougao bcde = new Cetvorougao();
      bcde.init("BCDE", b, c, d, e);
      bcde.prikaziSe();
      System.out.println("\n");

      Krug k1 = new Krug();
      k1.init("k1", b, 18);
      k1.prikaziSe();
    }
}
