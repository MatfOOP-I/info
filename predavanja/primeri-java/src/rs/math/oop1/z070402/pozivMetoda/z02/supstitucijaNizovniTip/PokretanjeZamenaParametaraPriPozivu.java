/*
 
 Направити Јава програм који тестира какав је ефекат позива метода: 
 1) Када метод мења вредности неких елемената параметра низовног типа.
 2) Када се у телу метода параметар низовног типа постави тако да
    реферише на неки други низ.
 3) Када метод врати низ као резултат.

 */

// Програм илуструје ефекте супституције параметра по вредности, која  
// се дешава у Јави приликом позива датог метода

package rs.math.oop1.z070402.pozivMetoda.z02.supstitucijaNizovniTip;

public class PokretanjeZamenaParametaraPriPozivu {

   static String prikaziPomocno(double[] x) {
      String rezultat = "";
      for (double broj : x)
         rezultat += " | " + broj;
      return rezultat;
   }

   static void utrostruciSve(double[] niz) {
      System.out.println("\tUnutar metoda, na pocetku izvrsavanja: niz=" + prikaziPomocno(niz));
      for (int i = 0; i < niz.length; i++)
         niz[i] = 3 * niz[i];
      System.out.println("\tUnutar metoda, na kraju izvrsavanja:   niz=" + prikaziPomocno(niz));
   }

   static void praviNovi(double[] niz) {
      System.out.println("\tUnutar metoda, na pocetku izvrsavanja: niz=" + prikaziPomocno(niz));
      double[] noviNiz = new double[10];
      for (int i = 0; i < noviNiz.length; i++)
         noviNiz[i] = 2 * i;
      niz = noviNiz;
      System.out.println("\tUnutar metoda, na kraju izvrsavanja:   niz=" + prikaziPomocno(niz));
   }

   static double[] praviNovi1(double[] niz) {
      System.out.println("\tUnutar metoda, na pocetku izvrsavanja: niz=" + prikaziPomocno(niz));
      double[] noviNiz = new double[10];
      for (int i = 0; i < noviNiz.length; i++)
         noviNiz[i] = 2 * i;
      niz = noviNiz;
      System.out.println("\tUnutar metoda, na kraju izvrsavanja:   niz=" + prikaziPomocno(niz));
      return niz;
   }

   public static void main(String[] args) {
      // Pokretanje 1: Metod moze da promeni neki od elemenata u parametru nizovnog
      // tipa
      System.out.println("\nPokretanjeiranje metoda utrostruciSve():");
      double[] brojevi = { 1.0, 2, 3, 4, 5 };
      System.out.println("Pre poziva:   brojevi=" + prikaziPomocno(brojevi));
      utrostruciSve(brojevi);
      System.out.println("Posle poziva: brojevi=" + prikaziPomocno(brojevi));

      // Pokretanje 2: Method ne moze nizovnom parametru trajno pridruziti neki drugi
      // niz
      System.out.println("\nPokretanjeiranje metoda praviNovi():");
      double[] brojevi1 = { 1.0, 2, 3, 4, 5 };
      System.out.println("Pre poziva: brojevi1=" + prikaziPomocno(brojevi1));
      praviNovi(brojevi1);
      System.out.println("Posle poziva: brojevi1=" + prikaziPomocno(brojevi1));

      // Pokretanje 3: Metod moze da vrati niz kao rezultat
      System.out.println("\nPokretanjeiranje metoda praviNovi1():");
      double[] brojevi2 = { 1.0, 2, 3, 4, 5 };
      System.out.println("Pre poziva:   brojevi2=" + prikaziPomocno(brojevi2));
      brojevi2 = praviNovi1(brojevi2);
      System.out.println("Posle poziva: brojevi2=" + prikaziPomocno(brojevi2));
   }
}
