/*

Написати Јава програм који омогућује рад са геометријским објектима у равни.

Подаци о разним врстама геометријских објеката су организовани по класама, 
које се налазе у одвојеним датотекама. 

*/

// Задатак илуструје превазилажење метода toString.
// Задатак илуструје коришћење анотације @Override.

package rs.math.oop1.z070903.prevazilazenje.z01.niskaReprezentacijaGeometrija;

public class PokretanjeGeometrija {

   public static void main(String[] args) {
      Tacka a = new Tacka("A", 14.5, 15);
      Tacka b = new Tacka(10, 11.5);
      Tacka c = new Tacka(10.45, 22);
      Tacka d = new Tacka(22.3, 17.5);
      Tacka e = new Tacka("E", 25, 25.5);
      System.out.println(
               a + " " + b + " " + c + " " + d + " " + e);
      Duz ab = new Duz("AB", a, b);
      System.out.println(ab + " l=" + ab.duzina());
      Prava p = new Prava(a, d);
      System.out.println("Prava odredjena sa " + a + " i "
               + d + " je " + p);
      Trougao bcd = new Trougao(b, c, d);
      System.out.println(bcd + " P=" + bcd.povrsina());
      Cetvorougao bcde = new Cetvorougao(b, c, d, e);
      System.out.println(bcde + " P=" + bcde.povrsina());
      Krug k1 = new Krug(b, 18);
      System.out.println(k1 + " P=" + k1.povrsina());
      System.out.println("Geometrijski objektiJDK:");
      GeometrijskiObjekat[] svi =
      { a, b, c, d, e, ab, p, bcd, bcde, k1 };
      for (GeometrijskiObjekat go : svi)
         System.out.println(go + " "
                  + (go.jeKonveksan() ? "Konveksan"
                           : "Nekonveksan")
                  + " " + (go.jeOgranicen() ? "Ogranicen"
                           : "Neogranicen"));
   }
}
