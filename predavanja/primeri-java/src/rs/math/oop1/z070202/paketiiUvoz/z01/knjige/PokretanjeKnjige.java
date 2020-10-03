// Пример илуструје различите начине за декларисање променљивих.

package rs.math.oop1.z070202.paketiiUvoz.z01.knjige;

import java.util.Scanner;

public class PokretanjeKnjige {

   public static void main(String[] args) {
      Scanner sc = new Scanner(
            "Горски вијенац/Његош/1954/134/Страва/Небојша Јеврић/2003/114");
      sc.useDelimiter("/");
      Knjiga k1;
      k1 = new Knjiga();
      k1.naslov = sc.next();
      k1.autor = sc.next();
      k1.godinaIzdavanja = sc.nextInt();
      k1.brojStranica = sc.nextInt();
      Knjiga k2;
      k2 = new Knjiga();
      k2.naslov = sc.next();
      k2.autor = sc.next();
      k2.godinaIzdavanja = sc.nextInt();
      k2.brojStranica = sc.nextInt();
      sc.close();

      System.out.printf( "Knjiga1: %s\n", k1);
      System.out.printf( "Knjiga1: [%s: %s, %d, %d str.]\n",
            k1.autor, k1.naslov, k1.godinaIzdavanja, k1.brojStranica);
      System.out.printf( "Knjiga2: %s\n", k2);
      System.out.printf( "Knjiga2: [%s: %s, %d, %d str.]\n",
            k2.autor, k2.naslov, k2.godinaIzdavanja, k2.brojStranica);
   }
}
