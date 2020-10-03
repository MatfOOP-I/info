/*

Написати Јава програм који омогућује рад са геометријским објектима у равни.

Подаци о разним врстама геометријских објеката су организовани по класама, 
које се налазе у одвојеним датотекама.

*/

// Задатак представља илустрацију примене метода и поља класе Math,
// као и коришћење наредбе import static при раду са класом Math.

package rs.math.oop1.z070603.konstruktori.z01.geometrija;

public class PokretanjeGeometrija {

   public static void main(String[] args) {
      Tacka a = new Tacka("A", 14.5, 15);
      Tacka b = new Tacka("B", 10, 11.5);
      Tacka c = new Tacka("C", 10.45, 22);
      Tacka d = new Tacka("D", 22.3, 17.5);
      Tacka e = new Tacka("E", 25, 25.5);

      Duz ab = new Duz("AB", a, b);
      ab.prikaziSe();
      System.out.println("\nDuzina duzi " + ab.oznaka
               + " je " + ab.duzina());
      System.out.println();

      Trougao bcd = new Trougao("BCD", b, c, d);
      bcd.prikaziSe();
      System.out.println("\nObim trougla " + bcd.oznaka
               + " je " + bcd.obim());
      System.out.println("Povrsina trougla " + bcd.oznaka
               + " je " + bcd.povrsina());
      if (bcd.sadrzi(a)) {
         System.out.print("Trougao " + bcd.oznaka
                  + " sadrzi tacku ");
         a.prikaziSe();
      } else {
         System.out.print("Trougao " + bcd.oznaka
                  + " ne sadrzi tacku ");
         a.prikaziSe();
      }
      System.out.println("\n");

      Cetvorougao bcde = new Cetvorougao("BCDE", b, c, d, e);
      bcde.prikaziSe();
      System.out.println("\nObim cetvorougla " + bcde.oznaka
               + " je " + bcde.obim());
      System.out.println("Povrsina cetvorougla "
               + bcde.oznaka + " je " + bcde.povrsina());
      if (bcde.sadrzi(a)) {
         System.out.print("Cetvorougao " + bcde.oznaka
                  + " sadrzi tacku ");
         a.prikaziSe();
      } else {
         System.out.print("Cetvorougao " + bcde.oznaka
                  + " ne sadrzi tacku ");
         a.prikaziSe();
      }
      System.out.println("\n");

      Krug k1 = new Krug();
      k1.init("k1", b, 18);
      k1.prikaziSe();
      System.out.println("\nObim kruga " + k1.oznaka
               + " je " + k1.obim());
      System.out.println("Povrsina kruga " + k1.oznaka
               + " je " + k1.povrsina());
      if (k1.sadrzi(a)) {
         System.out.print(
                  "Krug " + k1.oznaka + " sadrzi tacku ");
         a.prikaziSe();
      } else {
         System.out.print("Krug " + k1.oznaka
                  + " ne sadrzi tacku ");
         a.prikaziSe();
      }
   }

}
