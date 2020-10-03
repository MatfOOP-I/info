/*

Јава класа која представља професора

*/

package rs.math.oop1.z080100.apstraktneKlase.z01.fakultet;

import java.util.Scanner;

public class Profesor extends Covek {
   private String zvanje;
   private String katedra;
   private boolean[] predaje;

   {
      predaje = new boolean[Predmet.brojPredmeta];
      for (int i = 0; i < predaje.length; i++)
         predaje[i] = false;
   }

   public Profesor(String ime, String prezime,
            String zvanje, String katedra) {
      super(ime, prezime);
      this.zvanje = zvanje;
      this.katedra = katedra;
   }

   public Profesor(String ime, String prezime,
            String zvanje, String katedra,
            boolean[] predaje) {
      this(ime, prezime, zvanje, katedra);
      // Treba proveriti da li je prosledjeni niz OK !!
      this.predaje = new boolean[predaje.length];
      for(int i=0; i<this.predaje.length; i++)
               this.predaje[i] = predaje[i];
   }

   public String getZvanje() {
      return zvanje;
   }

   public void setZvanje(String profZvanje) {
      zvanje = profZvanje;
   }

   public String getKatedra() {
      return katedra;
   }

   public void setKatedra(String profKatedra) {
      katedra = profKatedra;
   }

   public boolean getPredmetPredaje(int predmet) {
      return predaje[predmet];
   }

   public void setPredmetPredaje(int predmet,
            boolean pred) {
      predaje[predmet] = pred;
   }

   public byte getPredmetPredajeBroj() {
      byte brojPredmeta = 0;
      for (boolean predmet : predaje)
         if (predmet)
            brojPredmeta++;
      return brojPredmeta;
   }

   @Override
   public void prikazi() {
      System.out.printf("Profesor: " + getIme() + " " + getPrezime());
      System.out.printf(
               "\nKatedra: %s. Zvanje: %s\nPredaje sledece predmete:\n",
               katedra, zvanje);
      for (int i = 0; i < predaje.length; i++)
         System.out.printf("%s:\t%s\n",
                  Predmet.getNazivPredmeta(i),
                  (predaje[i]) ? "da " : "ne ");
   }

   public static Profesor ucitaj(Scanner skener) {
      System.out.println("Ime i prezime nastavnika");
      String profIme = skener.next();
      String profPrezime = skener.next();
      System.out.println("Katedra na kojoj radi nastavnik");
      String profKatedra = skener.next();
      System.out.println("Zvanje nastavnika");
      String profZvanje = skener.next();
      boolean profPredajeNa[] = new boolean[Predmet.brojPredmeta];
      System.out.printf(
               "Unesi na kojim od %d predmeta nastavnika predaje (0 znaci da ne predaje)\n",
               profPredajeNa.length);
      for (int i = 0; i < profPredajeNa.length; i++) {
         System.out
                  .print(Predmet.getSifraPredmeta(i) + ":");
         String unos = skener.next().trim();
         profPredajeNa[i] = unos.equals("0") ? false : true;
      }
      return new Profesor(profIme, profPrezime, profKatedra,
               profZvanje, profPredajeNa);
   }

}
