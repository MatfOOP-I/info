package rs.math.oop1.z100103.izuzeciIzbacivanje.z04.stekPrekoListeKorisnickiIzuzetak;

public class PovezanaListaNiski {

   private ElemenatListe pocetak = null;
   private ElemenatListe kraj = null;
   private ElemenatListe tekuci = null;

   public PovezanaListaNiski() {
   }

   public PovezanaListaNiski(String elem) throws ArgumentJeNullException {
      if( elem == null)
         throw new ArgumentJeNullException();
      tekuci = kraj = pocetak = new ElemenatListe(elem);
   }

   public PovezanaListaNiski(String[] elementi) throws ArgumentJeNullException{
      if (elementi == null)
         throw new ArgumentJeNullException();
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

   public String ukloniElemenatSaKraja() throws PovezanaListaJePraznaException {
      if (kraj == null)
         throw new PovezanaListaJePraznaException();
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

   public String ukloniElemenatSaPocetka() throws PovezanaListaJePraznaException {
      if (pocetak == null)
         throw new PovezanaListaJePraznaException();
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
