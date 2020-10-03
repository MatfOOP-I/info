public class P050401OmotacCelogBrojaZ04LongrPoredjenjePokretanje {
   public static void main(String[] args) {
      Long dimenzija = 10_000L;
      long pocetak = System.nanoTime();
      Long suma = 0L;
      for( Long i=0L; i.compareTo(dimenzija) <= 0; i=i+1)
         suma = suma.longValue() + i.longValue();
      double trajanje = (System.nanoTime() - pocetak)/1e9;
      System.out.printf("Suma prvih %d brojaeva: %s \nProteklo vreme: %f\n\n",
            dimenzija, suma, trajanje);

      long dim = dimenzija.longValue();
      pocetak = System.nanoTime();
      long sum = 0L;
      for( long i=0L; i<=dim; i++)
         sum += i;
      trajanje = (System.nanoTime() - pocetak)/1e9;
      System.out.printf("Suma prvih %d brojaeva: %d \nProteklo vreme: %f",
            dim, sum, trajanje);
   }

}
