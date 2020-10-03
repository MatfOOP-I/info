/*

Написати Јава програм који омогућује рад са геометријским објектима у равни.

Подаци о разним врстама геометријских објеката су организовани по класама, 
које се налазе у одвојеним датотекама. 

На поља и методе у класама су примењени модификатори приступа.

*/

// Задатак илуструје преоптерећење конструктора (Tacka).
// Задатак илуструје коришћење кључне речи this (Tacka).
// Задатак илуструје проблем када компоненте објекта могу да мењају стање (Duz).

package rs.math.oop1.z070603.konstruktori.z05.geometrijaPreopterecenje;

public class PokretanjeGeometrija {

   public static void main(String[] args) {
      Tacka a = new Tacka("A", 14.5, 15);
      a.prikaziSe();
      Tacka b = new Tacka(10, 11.5);
      b.prikaziSe();
      Tacka c = new Tacka("C");
      c.prikaziSe();
      Tacka d = new Tacka();
      d.prikaziSe();
      System.out.println();

      Duz ac = new Duz("AC", a, c);
      ac.prikaziSe();
      System.out.println();
      c.setY(6);
      c.prikaziSe();
      ac.prikaziSe();
      System.out.println();

      Duz bd = new Duz("BD", b, d);
      bd.prikaziSe();
      System.out.println();
      d.setY(-6.6);
      d.prikaziSe();
      bd.prikaziSe();
      System.out.printf( "\n\nUkupno kreirano %d tacaka.\n\n", Tacka.brojKreiranih);

   }

}
