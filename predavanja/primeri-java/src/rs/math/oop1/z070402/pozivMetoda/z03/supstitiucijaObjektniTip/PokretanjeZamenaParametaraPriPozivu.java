/*
 
 Направити Јава програм који тестира какав је ефекат позива метода: 
 1) Када метод мења вредности неких поља датог објекта на који реферише
    параметар објектног типа.
 2) Када се у телу метода параметар објектног типа постави тако да
    реферише на неки други објекат тог типа.
 3) Када метод мења вредности поља датог објекта на који реферише
    параметар објектног типа.
 4) Када се референца на објекат враће из метода као његов резултат. 

 */

// Програм илуструје ефекте супституције параметра по вредности, која  
// се дешава у Јави приликом позива датог метода

package rs.math.oop1.z070402.pozivMetoda.z03.supstitiucijaObjektniTip;

public class PokretanjeZamenaParametaraPriPozivu {

   static void utrostruciPlatu(Profesor x) {
      System.out.println("\tUnutar metoda, na pocetku izvrsavanja: x.plata=" + x.plata);
      x.povecajPlatu(200);
      System.out.println("\tUnutar metoda, na kraju izvrsavanja:   x.plata=" + x.plata);
   }

   static void razmeni(Profesor x, Profesor y) {
      System.out.println("\tUnutar metoda, na pocetku izvrsavanja: x=" + x.imePrezime);
      System.out.println("\tUnutar metoda, na pocetku izvrsavanja: y=" + y.imePrezime);
      Profesor temp = x;
      x = y;
      y = temp;
      System.out.println("\tUnutar metoda, na kraju izvrsavanja:   x=" + x.imePrezime);
      System.out.println("\tUnutar metoda, na kraju izvrsavanja:   y=" + y.imePrezime);
   }

   static void trajnoRazmeni(Profesor x, Profesor y) {
      System.out.println("\tUnutar metoda, na pocetku izvrsavanja: x=" + x.imePrezime);
      System.out.println("\tUnutar metoda, na pocetku izvrsavanja: y=" + y.imePrezime);
      String temp1 = x.imePrezime;
      x.imePrezime = y.imePrezime;
      y.imePrezime = temp1;
      double temp2 = x.plata;
      x.plata = y.plata;
      y.plata = temp2;
      System.out.println("\tUnutar metoda, na kraju izvrsavanja:   x=" + x.imePrezime);
      System.out.println("\tUnutar metoda, na kraju izvrsavanja:   y=" + y.imePrezime);
   }

   static Profesor kreiraj(String ime, String prezime, double plata) {
      System.out.println("\tUnutar metoda, na pocetku izvrsavanja: ime=" + ime);
      System.out.println("\tUnutar metoda, na pocetku izvrsavanja: prezime=" + prezime);
      System.out.println("\tUnutar metoda, na pocetku izvrsavanja: plata=" + plata);
      Profesor rez = new Profesor();
      rez.init(ime + " " + prezime, plata);
      System.out.println("\tUnutar metoda, na kraju izvrsavanja:   rez=" + rez.imePrezime);
      return rez;
   }

   public static void main(String[] args) {
      // Pokretanje 1: Metod moze da promeni vrednosti polja objektnih parametara
      System.out.println("\nPokretanjeiranje metoda utrostruciPlatu():");
      Profesor pera = new Profesor();
      pera.init("Pera", 80_000);
      System.out.println("Pre poziva:   plata=" + pera.plata);
      utrostruciPlatu(pera);
      System.out.println("Posle poziva: plata=" + pera.plata);

      // Pokretanje 2: Metod ne moze objektnom parametru trajno pridruziti neki drugi
      // objekat
      System.out.println("\nPokretanjeiranje metoda razmeni():");
      Profesor a = new Profesor();
      a.init("Aca", 70_000);
      Profesor b = new Profesor();
      b.init("Bora", 60_000);
      System.out.println("Pre poziva:   a=" + a.imePrezime);
      System.out.println("Pre poziva:   b=" + b.imePrezime);
      razmeni(a, b);
      System.out.println("Posle poziva: a=" + a.imePrezime);
      System.out.println("Posle poziva: b=" + b.imePrezime);

      // Pokretanje 3: Metod moze poljima objektnog parametra trajno pridruziti neku
      // drugu vrednost
      System.out.println("\nPokretanjeiranje metoda razmeni():");
      Profesor aa = new Profesor();
      aa.init("Aca", 70_000);
      Profesor bb = new Profesor();
      bb.init("Bora", 60_000);
      System.out.println("Pre poziva:   aa=" + aa.imePrezime);
      System.out.println("Pre poziva:   bb=" + bb.imePrezime);
      trajnoRazmeni(aa, bb);
      System.out.println("Posle poziva: aa=" + aa.imePrezime);
      System.out.println("Posle poziva: bb=" + bb.imePrezime);

      // Pokretanje 4: Metod moze da vrati objekat kao rezultat
      System.out.println("\nPokretanjeiranje metoda kreiraj():");
      String profIme = "Jovan";
      String profPrezime = "Jovanovic";
      double profPlata = 55_000;
      System.out.println("Pre poziva:   profIme=" + profIme);
      System.out.println("Pre poziva:   profPrezime=" + profPrezime);
      System.out.println("Pre poziva:   profPlata=" + profPlata);
      Profesor profa = kreiraj(profIme, profPrezime, profPlata);
      System.out.println("Posle poziva: profa=" + profa.imePrezime);

   }
}
