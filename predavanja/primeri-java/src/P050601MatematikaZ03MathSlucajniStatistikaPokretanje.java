public class P050601MatematikaZ03MathSlucajniStatistikaPokretanje {

   public static void main(String[] args) {
      System.out.println("Broj izvlacenja:");
      java.util.Scanner ulaz = new java.util.Scanner(System.in);
      int n = ulaz.nextInt();
      System.out.println("Broj intervala:");
      int brojIntervala = ulaz.nextInt();
      int[] intervali = new int[brojIntervala];
      for(int i=0; i<n; i++)
         intervali[(int)(Math.random() * brojIntervala)]++;
//      {
//         double x = Math.random();
//         int pozicija = (int)(x * brojIntervala);
//         intervali[pozicija]++;
//      }
      for(int elem: intervali)
      {
         System.out.printf("%d ", elem);
      }
      ulaz.close();

   }

}




