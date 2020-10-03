package rs.math.oop1.z070603.konstruktori.z07.okretanjeSteka;

public class PovezanaLista {

   private ElemenatListe pocetak = null;
   private ElemenatListe kraj = null;
   private ElemenatListe tekuci = null;

   public PovezanaLista() {
   }

   public PovezanaLista(String elem) {
      if (elem != null)
         tekuci = kraj = pocetak = new ElemenatListe(elem);
   }

   public PovezanaLista(String[] elementi) {
      if (elementi == null)
         return;
      for (int i = 0; i < elementi.length; i++)
         dodajElemenatNaKraj(elementi[i]);
      tekuci = pocetak;
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

   public String getPrvi() {
      tekuci = pocetak;
      return tekuci == null ? null : tekuci.getSadrzaj();
   }

   public String getSledeci() {
      if (tekuci != null)
         tekuci = tekuci.getSledeci();
      return tekuci == null ? null : tekuci.getSadrzaj();
   }

}
