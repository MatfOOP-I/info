package rs.math.oop1.z080501.dogadjaji.z02.koriscenje;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.EventListener;

/**
 * Primer za izvor dogadjaja - primerak ove klase
 * ispaljuje SunceKretanjeDogadjaj svima koji
 * osmataju kretanje sunca.
 * Kroz ulaz sa konzole korisnik ispaljuje
 * dogadjaje izlaska i zalaska sunca.
 */
public class SunceKretanjeDogadjajIzvor {
   private int maxBrojOsluskivaca = 1000;
   private transient EventListener[] osluskivaci = new EventListener[maxBrojOsluskivaca];
   private int brojOsluskivaca = 0;

   /**
    * Konstruktor
    */
   public SunceKretanjeDogadjajIzvor() {
   }

   /**
    * Registruje osluskivac za SunceKretanjeDogadjaj
    */
   synchronized public void dodajOsluskivac(SunceKretanjeDogadjajOsluskivac l) {
      if( brojOsluskivaca >= maxBrojOsluskivaca){
         maxBrojOsluskivaca = Math.max(2*maxBrojOsluskivaca, brojOsluskivaca);
         EventListener[] stariOsluskivaci = osluskivaci;
         osluskivaci = new EventListener[maxBrojOsluskivaca];
         System.arraycopy(stariOsluskivaci,0,osluskivaci, 0, brojOsluskivaca);
      }
      osluskivaci[brojOsluskivaca++] = l;
   }

   /**
    * Uklanja osluskivac za SunceKretanjeDogadjaj
    */
   synchronized public void ukloniOsluskivac(SunceKretanjeDogadjajOsluskivac l) {
      int pozicija = 0;
      for (; pozicija < brojOsluskivaca; pozicija++)
         if (osluskivaci[pozicija].equals(l))
            break;
      if( pozicija < brojOsluskivaca) {
         for (int i = pozicija; i < brojOsluskivaca - 1; i++)
            osluskivaci[i] = osluskivaci[i + 1];
         brojOsluskivaca--;
      }
   }

   /**
    * Ispaljuje dogadjaj tipa SunceKretanjeDogadjaj za sve registrovane osluskivace
    */
   protected void ispaliDogadjaj(boolean izaslo) {
      // ako nema osluskivaca, ne radi nista...
      if (brojOsluskivaca == 0)
         return;
      // kreiraj objekat za dogadjaj koji se salje
      SunceKretanjeDogadjaj dogadjaj = new SunceKretanjeDogadjaj(this, izaslo, LocalDateTime.now());

      // napravi kopiju liste osluskivaca,
      // za slucaj da neko doda/ukloni osluskivace
      Object[] kopija;
      int brojKopija = brojOsluskivaca;
      synchronized (this) {
         kopija = Arrays.copyOf( osluskivaci,brojKopija);
      }
      // iteriranje kroz kopiju liste osluskivaca
      // i pozivanje metoda sunceSePomerilo za svaki od njih
      for(int i=0; i<brojKopija; i++) {
         SunceKretanjeDogadjajOsluskivac osl = (SunceKretanjeDogadjajOsluskivac) kopija[i];
         osl.sunceSePomerilo(dogadjaj);
      }
   }
}