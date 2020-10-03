/*

Написати Јава програм који омогућује рад са геометријским објектима у равни.

Подаци о разним врстама геометријских објеката су организовани по класама, 
које се налазе у одвојеним датотекама. 

*/

// Задатак илуструје коришћење наслеђивања.
// Задатак илуструје коришћење кључне речи super.

package rs.math.oop1.z080204.interfejsi.z03.geometrija;

public class PokretanjeGeometrija {

   public static void main(String[] args) {
      Tacka a = new Tacka("A", 14.5, 15);
      a.prikaziNaKonzoli();
      Tacka b = new Tacka(10, 11.5);
      b.prikaziNaKonzoli();
      Tacka c = new Tacka(10.45, 22);
      c.prikaziNaKonzoli();
      Tacka d = new Tacka(22.3, 17.5);
      d.prikaziNaKonzoli();
      Tacka e = new Tacka("E", 25, 25.5);
      e.prikaziNaKonzoli();
      System.out.println();

      Duz ab = new Duz("AB", a, b);
      ab.prikaziNaKonzoli();
      System.out.println("l=" + ab.duzina());

      Prava p = new Prava("p", a, d);
      p.prikaziNaKonzoli();

      Trougao bcd = new Trougao(b, c, d);
      bcd.prikaziNaKonzoli();
      System.out.println("P=" + bcd.povrsina());

      Cetvorougao bcde = new Cetvorougao(b, c, d, e);
      bcde.prikaziNaKonzoli();
      System.out.println("P=" + bcde.povrsina());

      Krug k1 = new Krug(b, 18);
      k1.prikaziNaKonzoli();
      System.out.println("P=" + k1.povrsina());

      double ukupanObim = 0;
      double ukupnaPovrsina = 0;
      System.out.println("\nGeometrijski objekti:");
      GeometrijskiObjekat[] svi = {a, b, c, d, e, ab, p, bcd, bcde, k1};
      for (GeometrijskiObjekat go : svi) {
         if (go instanceof Prikaz)
            ((Prikaz) go).prikaziNaKonzoli();
         if (go instanceof Oblik) {
            Oblik obl = (Oblik) go;
            if (obl.jeKonveksan())
               System.out.print("Konveksan ");
            else
               System.out.print("Nekonveksan ");
            if (obl.jeOgranicen())
               System.out.println("Ogranicen");
            else
               System.out.println("Neogranicen");
         }
         if( go instanceof  Mera){
            ukupanObim += ((Mera)go).obim();
            ukupnaPovrsina += ((Mera)go).povrsina();
         }
      }
      System.out.println("Ukupan obim:     " + ukupanObim);
      System.out.println("Ukupna povrsina: " + ukupnaPovrsina);
      System.out.println("Tokom rada programa kreirano je "
            + GeometrijskiObjekat.brojKreiranih
            + " geometrijskih objekata.");
   }

}
