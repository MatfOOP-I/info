package rs.math.oop1.z080100.apstraktneKlase.z04.stek;

public class PovezanaListaNiski {

   private ElemenatListe pocetak = null;
   private ElemenatListe kraj = null;

   public PovezanaListaNiski() {
   }

   public PovezanaListaNiski(String elem) {
      if (elem != null)
         kraj = pocetak = new ElemenatListe(elem);
   }

   public PovezanaListaNiski(String[] elementi) {
      if (elementi == null)
         return;
      for (int i = 0; i < elementi.length; i++)
         dodajElemenatNaKraj(elementi[i]);
   }

   public void dodajElemenatNaKraj(String elem) {
      ElemenatListe noviKraj = new ElemenatListe(elem);
      if (pocetak == null)
         pocetak = kraj = noviKraj;
      else {
         kraj.setSledeci(noviKraj);
         kraj = noviKraj;
      }
   }

   public String ukloniElemenatSaKraja() {
      if (kraj == null)
         return null;
      if (pocetak == kraj) {
         ElemenatListe jedini = kraj;
         pocetak = kraj = null;
         return jedini.getSadrzaj();
      }
      ElemenatListe poslednji = kraj;
      ElemenatListe pretposlednji = pocetak;
      while (pretposlednji.getSledeci() != poslednji)
         pretposlednji = pretposlednji.getSledeci();
      pretposlednji.setSledeci(null);
      kraj = pretposlednji;
      return poslednji.getSadrzaj();
   }

   public void dodajElemenatNaPocetak(String elem) {
      ElemenatListe noviPocetak = new ElemenatListe(elem);
      if (kraj == null)
         pocetak = kraj = noviPocetak;
      else {
         noviPocetak.setSledeci(pocetak);
         pocetak = noviPocetak;
      }
   }

   public String ukloniElemenatSaPocetka() {
      if (pocetak == null)
         return null;
      if (pocetak == kraj) {
         ElemenatListe jedini = kraj;
         pocetak = kraj = null;
         return jedini.getSadrzaj();
      }
      ElemenatListe prvi = pocetak;
      pocetak = prvi.getSledeci();
      return prvi.getSadrzaj();
   }

   public void prikazi() {
      System.out.print("[");
      ElemenatListe tekuci = pocetak;
      while (tekuci != null) {
         System.out.print("'" + tekuci.getSadrzaj() + "' ");
         tekuci = tekuci.getSledeci();
      }
      System.out.print("]");
   }

   public int broj() {
      int br = 0;
      for (ElemenatListe tekuci = pocetak; tekuci != null; tekuci = tekuci.getSledeci())
         br++;
      return br;
   }

}
