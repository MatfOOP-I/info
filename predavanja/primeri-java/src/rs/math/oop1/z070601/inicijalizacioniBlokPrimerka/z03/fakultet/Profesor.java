/*

Јава класа која представља професора

*/

package rs.math.oop1.z070601.inicijalizacioniBlokPrimerka.z03.fakultet;

import java.util.Scanner;

public class Profesor {
   private String ime;
   private String prezime;
   private String zvanje;
   private String katedra;
   private boolean[] predaje;

   // inicijalizacioni blok primerka
   {
      int brojPredmeta = Predmet.brojPredmeta;
      predaje = new boolean[brojPredmeta];
      for (int i = 0; i < brojPredmeta; i++)
         predaje[i] = false;
      zvanje = "?";
   }

   public String getIme() {
      return ime;
   }

   public void setIme(String profIme) {
      ime = profIme;
   }

   public String getPrezime() {
      return prezime;
   }

   public void setPrezime(String profPrezime) {
      prezime = profPrezime;
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

   public void prikazi() {
      System.out.printf("\nProfesor: %s %s\n", ime,
               prezime);
      System.out.printf(
               "Katedra: %s. Zvanje: %s\nPredaje sledece predmete:\n",
               katedra, zvanje);
      for (int i = 0; i < predaje.length; i++)
         System.out.printf("%s:\t%s\n",
                  Predmet.getNazivPredmeta(i),
                  (predaje[i]) ? "da " : "ne ");
   }

   public static Profesor ucitaj(Scanner skener) {
      Profesor prof = new Profesor();
      System.out.println("Ime i prezime nastavnika");
      prof.setIme(skener.next());
      prof.setPrezime(skener.next());
      System.out.println("Katedra na kojoj radi nastavnik");
      prof.setKatedra(skener.next());
      System.out.println("Zvanje nastavnika");
      prof.setZvanje(skener.next());
      System.out.printf(
               "Unesi na kojim od %d predmeta nastavnika predaje (0 znaci da ne predaje)\n",
               Predmet.brojPredmeta);
      for (int i = 0; i < Predmet.brojPredmeta; i++) {
         System.out
                  .print(Predmet.getSifraPredmeta(i) + ":");
         String unos = skener.next().trim();
         prof.setPredmetPredaje(i,
                  (unos.equals("0")) ? false : true);
      }
      return prof;
   }

}
