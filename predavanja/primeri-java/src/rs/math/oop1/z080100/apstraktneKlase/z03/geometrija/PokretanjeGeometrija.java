/*

Написати Јава програм који омогућује рад са геометријским објектима у равни.

Подаци о разним врстама геометријских објеката су организовани по класама, 
које се налазе у одвојеним датотекама. 

*/

// Задатак илуструје коришћење наслеђивања.
// Задатак илуструје коришћење кључне речи super.

package rs.math.oop1.z080100.apstraktneKlase.z03.geometrija;

public class PokretanjeGeometrija {

   public static void main(String[] args) {
      Tacka a = new Tacka("A", 14.5, 15);
      a.prikaziSe();
      Tacka b = new Tacka(10, 11.5);
      b.prikaziSe();
      Tacka c = new Tacka(10.45, 22);
      c.prikaziSe();
      Tacka d = new Tacka(22.3, 17.5);
      d.prikaziSe();
      Tacka e = new Tacka("E", 25, 25.5);
      e.prikaziSe();
      System.out.println();

      Duz ab = new Duz("AB", a, b);
      ab.prikaziSe();
      System.out.println("l=" + ab.duzina());

      Prava p = new Prava("p", a, d);
      p.prikaziSe();

      Trougao bcd = new Trougao(b, c, d);
      bcd.prikaziSe();
      System.out.println("P=" + bcd.povrsina());

      Cetvorougao bcde = new Cetvorougao(b, c, d, e);
      bcde.prikaziSe();
      System.out.println("P=" + bcde.povrsina());

      Krug k1 = new Krug(b, 18);
      k1.prikaziSe();
      System.out.println("P=" + k1.povrsina());

      System.out.println("Geometrijski objektiJDK:");
      GeometrijskiObjekat[] svi =
      { a, b, c, d, e, ab, p, bcd, bcde, k1 };
      for (GeometrijskiObjekat go : svi) {
         go.prikaziSe();
         if (go.jeKonveksan())
            System.out.print("Konveksan ");
         else
            System.out.print("Nekonveksan ");
         if (go.jeOgranicen())
            System.out.println("Ogranicen");
         else
            System.out.println("Neogranicen");
      }
      System.out.println("Tokom rada programa kreirano je "
               + GeometrijskiObjekat.brojKreiranih
               + " geometrijskih objekata.");
   }

}
