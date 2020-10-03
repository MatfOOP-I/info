package rs.math.oop1.z080100.apstraktneKlase.z02.ljudi;


import java.util.Scanner;

class Nastavnik extends Covek {
   private String predmet;
   private int godinaStaza;

   public Nastavnik(String ime, String prezime, String jmbg, String predmet, int godinaStaza) {
      super(ime, prezime, jmbg);
      this.predmet = predmet;
      this.godinaStaza = godinaStaza;
   }

   public Nastavnik() {
      this("", "", "", "", 0);
   }

   public String getPredmet() {
      return predmet;
   }

   public void setPredmet(String predmet) {
      this.predmet = predmet;
   }

   public int getGodinaStaza() {
      return godinaStaza;
   }

   public void setGodinaStaza(int godinaStaza) {
      this.godinaStaza = godinaStaza;
   }

   public void ucitajSe(Scanner ulaz) {
      System.out.println("Informacije o nastavniku");
      System.out.print("Ime: ");
      setIme(ulaz.next());
      System.out.print("Prezime: ");
      setPrezime(ulaz.next());
      System.out.print("JMBG: ");
      setJmbg(ulaz.next());
      System.out.print("Predmet: ");
      setPredmet(ulaz.next());
      System.out.print("Staz: ");
      setGodinaStaza(ulaz.nextInt());
   }

   @Override
   public String toString() {
      return "Nastavnik{"
            + getIme() + " " + getPrezime() + " " + getJmbg() + " "
            + predmet + " " + godinaStaza +
            '}';
   }

   @Override
   public void predstaviSe() {
      System.out.println(this);
   }

   @Override
   public void leciSe() {
      System.out.println( "Odlazi u u dom zdravlja..." );
   }

}