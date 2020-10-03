package rs.math.oop1.z090102.statickeUgnjezdene.z01.koriscenje;

public class Spoljasnja {
   private static int sp;
   private int np;

   private void nm() {
   }

   private static void sm() {
   }

   //instanca ugnjezdene staticke klase nije uslovljena postojanjem instance spoljne klase
   static class StatickaUgnjezdena {
      private static int sp;
      private int np;

      private void nm() {
         //pristup spoljnoj statickoj
         Spoljasnja.sp = 5;
         //ne mozemo pristupiti nestatickoj promenljivoj iz
         //staticke klase
         //Spoljasnja.np = 8;
         //ne mozemo pristupiti ni nestatickoj metodi
         //spoljne klase
         //Spoljasnja.nm();
         //ali mozemo statickoj metodi spoljne klase
         Spoljasnja.sm();
      }

      private static void sm() {
         //slicno kao i u nestatickoj nm() metodi,
         //mozemo pristupiti sledecim elementima spoljne klase 					Spoljasnja.sp=5;
         Spoljasnja.sm();
      }
   }

   class Unutrasnja {
      //unutrasnja klasa ne moze imati staticke promenljive i metode
      //private static int sp;
      private int np;

      private void nm() {
         //pristup spoljnim statickim i nestatickim promenljivama 					Spoljasnja.sp=5;
         //ovo je np iz objekta Spoljasnje klase
         Spoljasnja.this.np = 7;
         //a ovo je np iz objekta klase Ugnjezdena
         np = 8;
         //slicno i za metode
         Spoljasnja.sm();
         //nestaticka metoda spoljne klase
         Spoljasnja.this.nm();
         //nestaticka metoda ove klase (rekurzija!)
         nm();
         //pristup statickim elementima klase StatickaUgnjezdena 					StatickaUgnjezdena.sp=5;
         StatickaUgnjezdena.sm();
      }
   }

   public static void main(String[] args) {
      Spoljasnja.sp++;
      Spoljasnja.sm();

      Spoljasnja spObjekat = new Spoljasnja();
      spObjekat.np += 2;
      spObjekat.nm();

      Spoljasnja.StatickaUgnjezdena.sp += 3;
      Spoljasnja.StatickaUgnjezdena.sm();

      Spoljasnja.StatickaUgnjezdena spsuObjekat = new Spoljasnja.StatickaUgnjezdena();
      spsuObjekat.np += 4;
      spsuObjekat.nm();

      Unutrasnja spunObjekat = spObjekat.new Unutrasnja();
      spunObjekat.np += 5;
      spunObjekat.nm();
   }
}