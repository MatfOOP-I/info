// Пример илуструје различите начине за декларисање променљивих.

package rs.math.oop1.z070201.paketi.z01.knjige;

public class PokretanjeKnjige {

   public static void main(String[] args) {
      Knjiga k2;
      k2 = new Knjiga();
      java.util.Scanner sc = new java.util.Scanner(System.in);
      System.out.print("Unesite naslov knjige: ");
      k2.naslov = sc.next();
      System.out.print("Unesite naziv autora: ");
      k2.autor = sc.next();
      System.out.print("Unesite godinu izdavanja: ");
      k2.godinaIzdavanja = sc.nextInt();
      System.out.print("Unesite broj stranica: ");
      k2.brojStranica = sc.nextInt();
      sc.close();

      System.out.printf( "Knjiga: %s\n", k2);
      System.out.printf( "Knjiga: [%s: %s, %d, %d str.]\n",
            k2.autor, k2.naslov, k2.godinaIzdavanja, k2.brojStranica);

   }
}
