package rs.math.oop1.z080100.apstraktneKlase.z02.ljudi;

import java.util.Scanner;

/**
 * Program ilustruje koncept polimorfizma i apstraktnih klasa.
 */
public class PokretanjeLjudi2 {

   public static void main(String[] args) {
      Student marko = new Student("Marko", "Markovic", "",
            "I smer", "12/2009", 3);
      Apsolvent janko = new Apsolvent("Janko", "Jankovic", "",
            "I smer", "12/2010", 3, 10);
      Nastavnik milica = new Nastavnik("Milica", "Petrovic", "",
            "OOP", 12);

      Scanner sc = new Scanner(System.in);
      Nastavnik perica = new Nastavnik();
      perica.ucitajSe(sc);
      sc.close();

      Covek[] niz = {marko, janko, milica, perica};
      for (int i = 0; i < niz.length; i++) {
         niz[i].predstaviSe();
      }

      for (Covek c : niz) {
         c.leciSe();
      }

   }

}
